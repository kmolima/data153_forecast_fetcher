package no.hvl.dat153.forecastfetcher;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import no.hvl.dat153.forecastfetcher.data.ForecastTimeStep;
import no.hvl.dat153.forecastfetcher.data.METJSONForecast;
import no.hvl.dat153.forecastfetcher.rest.ApiException;
import no.hvl.dat153.forecastfetcher.rest.ApiInvoker;
import no.hvl.dat153.forecastfetcher.rest.RestRequest;
import no.hvl.dat153.forecastfetcher.room.ForecastViewModel;
import no.hvl.dat153.forecastfetcher.room.WeatherForecast;
import no.hvl.dat153.forecastfetcher.utils.ForecastUtils;

public class TodayForecastActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    private Location requestLocation;
    private boolean isGranted;

    public final static String debugTag = "TodayForecast";

    private ForecastViewModel mForecastViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_forecast);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ForecastAdapter adapter = new ForecastAdapter(new ForecastAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mForecastViewModel = new ViewModelProvider(this).get(ForecastViewModel.class);

        mForecastViewModel.getAllForecasts().observe(this, forecasts -> {
            adapter.submitList(forecasts);
        });




        isGranted = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        if(isGranted){
            Log.e(debugTag,"Location permission granted.");
            useDeviceLocation();
        }
        else {
            Log.e(debugTag,"Location permission not granted.");
            requestLocationPermissions();
        }
    }

    @SuppressLint("MissingPermission")
    private void useDeviceLocation() {
        // Register to Location Service
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        // Logic to handle location object
                        Log.d(debugTag, "Current Location Latitude: "+location.getLatitude()
                                +" and Longitude: "+location.getLongitude());
                        Toast.makeText(TodayForecastActivity.this,"Current Location Latitude: "+location.getLatitude()
                                +" and Longitude: "+location.getLongitude(), Toast.LENGTH_LONG).show();
                        TodayForecastActivity.this.requestLocation = new Location(location);
                        requestData();
                    }
                    else {
                        Log.e(debugTag, "No location data.");
                    }
                });
    }

    private void requestData() {

        // Request Forecast data using generated code
        RestRequest apiInstance = new RestRequest(this);

        Float lat = ForecastUtils.formatCoordinate(new Float(requestLocation.getLatitude())); // Float | Latitude
        Float lon = ForecastUtils.formatCoordinate(new Float(requestLocation.getLongitude())); // Float | Longitude
        Integer altitude = requestLocation.hasAltitude() ?
                new Integer(new Double(requestLocation.getAltitude()).intValue()) : null; // Integer | Whole meters above sea level

        Response.Listener<String> dataCallback = new Response.Listener<String>(){
                @Override
                public void onResponse(String response) {
                    //response.getProperties().getTimeseries().size();
                    try {
                        //TODO use worker thread
                        Log.d("VolleyRequest",response);
                        METJSONForecast data = (METJSONForecast) ApiInvoker.deserialize(response, "", METJSONForecast.class);
                        for(ForecastTimeStep item: data.getProperties().getTimeseries()){
                            String time = item.getTime();

                            String airTemp = String.valueOf(item.getData().getInstant().getDetails().getAirTemperature()) +
                                    " " + data.getProperties().getMeta().getUnits().getAirTemperature();
                            String humidity = String.valueOf(item.getData().getInstant().getDetails().getRelativeHumidity()) +
                                    " " + data.getProperties().getMeta().getUnits().getRelativeHumidity();
                            String windSpeed = String.valueOf(item.getData().getInstant().getDetails().getWindSpeed()) +
                                    " " + data.getProperties().getMeta().getUnits().getWindSpeed();
                            String pressure = String.valueOf(item.getData().getInstant().getDetails().getAirPressureAtSeaLevel()) +
                                    " " + data.getProperties().getMeta().getUnits().getAirPressureAtSeaLevel();

                            WeatherForecast newItem = new WeatherForecast();
                            newItem.setTime(time);
                            newItem.setVariable_name(" Temperature ");
                            newItem.setVariable_unit(airTemp);
                            mForecastViewModel.insert(newItem);

                            newItem = new WeatherForecast();
                            newItem.setTime(time);
                            newItem.setVariable_name(" Humidity ");
                            newItem.setVariable_unit(humidity);
                            mForecastViewModel.insert(newItem);

                            newItem = new WeatherForecast();
                            newItem.setTime(time);
                            newItem.setVariable_name(" Wind ");
                            newItem.setVariable_unit(windSpeed);
                            mForecastViewModel.insert(newItem);

                            newItem = new WeatherForecast();
                            newItem.setTime(time);
                            newItem.setVariable_name(" Pressure ");
                            newItem.setVariable_unit(pressure);
                            mForecastViewModel.insert(newItem);
                        }
                    } catch (ApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

        try {
            apiInstance.compactGet(dataCallback,lat,lon, altitude);
        } catch (ApiException | TimeoutException | ExecutionException | InterruptedException e) {
            Log.e(debugTag,"Exception "+e.getClass().toString()+" when calling DataApi#compactGet");
            if(e.getLocalizedMessage() != null)
                Log.e(debugTag,e.getLocalizedMessage());
        }
    }

    protected void requestLocationPermissions(){
        ActivityResultLauncher<String[]> locationPermissionRequest = registerForActivityResult(
                new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                    Boolean coarseLocationGranted = result.getOrDefault(
                            android.Manifest.permission.ACCESS_COARSE_LOCATION,false);

                    // Access to approximate location granted.
                    if (coarseLocationGranted != null && coarseLocationGranted) {
                        useDeviceLocation();

                    } else {
                        Toast.makeText(this,"Access to device location not granted. Using default location for Bergen",Toast.LENGTH_LONG).show();
                        setDefaultLocation();
                        requestData();
                    }

                });

        locationPermissionRequest.launch(new String[] {
                android.Manifest.permission.ACCESS_COARSE_LOCATION
        });
    }

    private void setDefaultLocation() {
        // Default Bergen Location: http://www.geonames.org/3161732/bergen.html
        Location bergen = new Location("GeoNames");
        float default_latitude = 60.39299f;
        float default_longitude = 5.32415f;

        bergen.setLatitude(ForecastUtils.formatCoordinate(default_latitude));
        bergen.setLongitude(ForecastUtils.formatCoordinate(default_longitude));
        bergen.setTime(System.currentTimeMillis());

        this.requestLocation = new Location(bergen);
    }
}