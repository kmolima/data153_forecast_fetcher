package no.hvl.dat153.forecastfetcher.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/***
 * DAO: data access object
 */
@Dao
public interface ForecastDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(WeatherForecast forecast);

    @Query("DELETE FROM forecast_table")
    void deleteAll();

    @Query("SELECT * FROM forecast_table")
    LiveData<List<WeatherForecast>> getAllForecasts();

}
