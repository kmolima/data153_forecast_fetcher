package no.hvl.dat153.forecastfetcher;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import no.hvl.dat153.forecastfetcher.room.WeatherForecast;

public class ForecastAdapter extends ListAdapter<WeatherForecast, ForecastViewHolder> {

    protected ForecastAdapter(@NonNull DiffUtil.ItemCallback<WeatherForecast> diffCallback) {
        super(diffCallback);
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ForecastViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        WeatherForecast current = getItem(position);
        holder.bind(current.getTime(),current.getVariable_name(),current.getVariable_unit());

    }

    static class WordDiff extends DiffUtil.ItemCallback<WeatherForecast> {

        @Override
        public boolean areItemsTheSame(@NonNull WeatherForecast oldItem, @NonNull WeatherForecast newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull WeatherForecast oldItem, @NonNull WeatherForecast newItem) {
            return oldItem.getTime().equals(newItem.getTime()) && oldItem.getVariable_name().equals(newItem.getVariable_name())
                    && oldItem.getVariable_unit().equals(newItem.getVariable_unit());
        }
    }

}
