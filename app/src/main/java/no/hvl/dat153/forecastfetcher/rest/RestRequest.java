package no.hvl.dat153.forecastfetcher.rest;

import static com.google.android.gms.common.util.JsonUtils.escapeString;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import no.hvl.dat153.forecastfetcher.data.METJSONForecast;
import no.hvl.dat153.forecastfetcher.utils.Pair;

public class RestRequest {
    Context context = null;

    public RestRequest(Context context) {
        this.context = context;
    }

    /**
     *
     * Weather forecast for a specified place
     * @param lat Latitude
     * @param lon Longitude
     * @param altitude Whole meters above sea level
     * @return METJSONForecast
     */
    public METJSONForecast compactGet (Response.Listener<String> callback, Float lat, Float lon, Integer altitude) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
        Object postBody = null;

        // verify the required parameter 'lat' is set
        if (lat == null) {
            VolleyError error = new VolleyError("Missing the required parameter 'lat' when calling compactGet",
                    new ApiException(400, "Missing the required parameter 'lat' when calling compactGet"));
        }
        // verify the required parameter 'lon' is set
        if (lon == null) {
            VolleyError error = new VolleyError("Missing the required parameter 'lon' when calling compactGet",
                    new ApiException(400, "Missing the required parameter 'lon' when calling compactGet"));
        }

        String[] contentTypes = {
        };

        String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

        String[] authNames = new String[] {  };

        RequestQueue requestQueue;

        // Instantiate the RequestQueue with the cache and network.
        requestQueue = Volley.newRequestQueue(this.context);

        // Start the queue
        requestQueue.start();

        // create request URL
        String basePath = "https://api.met.no/weatherapi/locationforecast/2.0";
        String path = "/compact";
        String url = getURL(basePath,path,lat,lon,altitude);

        Log.e("Volley Request",url);

        // Formulate the request and handle the response from https://github.com/google/volley/blob/master/docs/requestqueue.md
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, callback,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        if(error.getLocalizedMessage() != null)
                            Log.e("Volley Request Error",error.getLocalizedMessage());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() {
                // header params
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                headers.put("User-Agent","OpenAPI-Generator/1.0.0/android");
                return headers;
            }};

        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
        return null;
    }

    private String getURL(String host, String path, Float lat, Float lon, Integer altitude){
        StringBuilder b = new StringBuilder();
        b.append("?");

        // query params
        List<Pair> queryParams = new ArrayList<Pair>();
        queryParams.addAll(ApiInvoker.parameterToPairs("", "altitude", altitude));
        queryParams.addAll(ApiInvoker.parameterToPairs("", "lat", lat));
        queryParams.addAll(ApiInvoker.parameterToPairs("", "lon", lon));

        if (queryParams != null){
            for (Pair queryParam : queryParams){
                if (!queryParam.getName().isEmpty()) {
                    b.append(escapeString(queryParam.getName()));
                    b.append("=");
                    b.append(escapeString(queryParam.getValue()));
                    b.append("&");
                }
            }
        }

        String querystring = b.substring(0, b.length() - 1);
        String url = host + path + querystring;

        return url;
    }
}
