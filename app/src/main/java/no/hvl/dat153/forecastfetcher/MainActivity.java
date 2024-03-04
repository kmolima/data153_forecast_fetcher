package no.hvl.dat153.forecastfetcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    protected Map<String, Object> actions = new HashMap<>();

    public final static String debugTag = "MainActivity";

    void prepareMenu() {
        addMenuItem("Today's Forecast", TodayForecastActivity.class);
        // addMenuItem("Bergen Detailed Weather - Meteogram", MeteogramActivity.class);
        // addMenuItem("Bergen Weather Now", CardActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareMenu();
        String[] keys = actions.keySet().toArray(new String[actions.keySet().size()]);

        ListView av = (ListView) findViewById(R.id.menu_list);
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, keys);

        av.setAdapter(adapter);
        av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                String key = (String) parent.getItemAtPosition(position);
                startActivity((Intent) actions.get(key));
            }
        });

    }

    public void addMenuItem(String label, Class<?> cls) {
        actions.put(label, new Intent(this, cls));
    }
}