package no.hvl.dat153.forecastfetcher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ForecastViewHolder extends RecyclerView.ViewHolder{

    private final TextView forecastItemTime;
    private final TextView forecastItemName;
    private final TextView forecastItemUnit;

    public ForecastViewHolder(@NonNull View itemView) {
        super(itemView);
        forecastItemTime = itemView.findViewById(R.id.textView1);
        forecastItemName = itemView.findViewById(R.id.textView2);
        forecastItemUnit = itemView.findViewById(R.id.textView3);

    }

    public void bind(String time, String name, String unit) {
        forecastItemTime.setText(time);
        forecastItemName.setText(name);
        forecastItemUnit.setText(unit);
    }

    public static ForecastViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ForecastViewHolder(view);
    }


}
