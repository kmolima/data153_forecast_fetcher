package no.hvl.dat153.forecastfetcher.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ForecastViewModel extends AndroidViewModel {

    private ForecastRepository mRepository;
    private final LiveData<List<WeatherForecast>> mAllForecasts;

    public ForecastViewModel(Application application) {
        super(application);
        mRepository = new ForecastRepository(application);
        mAllForecasts = mRepository.getAllWords();
    }

    public LiveData<List<WeatherForecast>> getAllForecasts() { return mAllForecasts; }

    public void insert(WeatherForecast forecast) { mRepository.insert(forecast); }


}
