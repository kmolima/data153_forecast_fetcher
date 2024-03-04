package no.hvl.dat153.forecastfetcher.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "forecast_table")
public class WeatherForecast {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "name")
    private String variable_name;

    @ColumnInfo(name = "unit")
    private String variable_unit;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVariable_name() {
        return variable_name;
    }

    public void setVariable_name(String variable_name) {
        this.variable_name = variable_name;
    }

    public String getVariable_unit() {
        return variable_unit;
    }

    public void setVariable_unit(String variable_unit) {
        this.variable_unit = variable_unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
