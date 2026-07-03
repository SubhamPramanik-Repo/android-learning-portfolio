package com.myapp.mybucketlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do);

        setupList();

    }

    private void setupList(){
        BucketListEntry[] thingsToDo = {
               new BucketListEntry("Climb Mt Kilimanjaro", "Do it the dificult way!",R.drawable.kilimanjaro, 5),
               new BucketListEntry("Experience the Northern lights", "Somewhere in the arctic circle",R.drawable.northern_lights, 5),
               new BucketListEntry("Road trips across India", "Rent a car and travel to all India",R.drawable.road_trip, 4.5f),
               new BucketListEntry("Scuba Dive", "In Koh Tao",R.drawable.scubadive, 4),
               new BucketListEntry("Skydive", "Perfectly over somewhere with an amazing view",R.drawable.skydive, 3.5f),
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_view_things_to_do);
        BucketListEntryAdapter adapter = new BucketListEntryAdapter(thingsToDo);
        recyclerView.setAdapter(adapter);
    }
}