package no.hvl.dat153.forecastfetcher.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {WeatherForecast.class}, version = 1, exportSchema = false)
public abstract class ForecastRoomDatabase extends RoomDatabase {
    public abstract ForecastDao ForecastDao();

    private static volatile ForecastRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ForecastRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ForecastRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ForecastRoomDatabase.class, "forecast_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}
