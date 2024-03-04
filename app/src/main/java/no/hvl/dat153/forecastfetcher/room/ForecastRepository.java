package no.hvl.dat153.forecastfetcher.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ForecastRepository {

    private ForecastDao mForecastDao;
    private LiveData<List<WeatherForecast>> mAllForecasts;

    ForecastRepository(Application application){
        ForecastRoomDatabase db = ForecastRoomDatabase.getDatabase(application);
        mForecastDao = db.ForecastDao();
        mAllForecasts = mForecastDao.getAllForecasts();
    }

    LiveData<List<WeatherForecast>> getAllWords() {
        return mAllForecasts;
    }

    void insert(WeatherForecast forecast) {
        ForecastRoomDatabase.databaseWriteExecutor.execute(() -> {
            mForecastDao.insert(forecast);
        });
    }



}
