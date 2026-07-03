package com.myapp.mybucketlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PlacesToGoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_places_to_go);

        setupList();
    }

    private void setupList() {
        BucketListEntry[] placesToGo = {
                new BucketListEntry("Vietnam", "Con Dao Islands, Hanoi, Halong Bay, Hoi An, Lang Co.",R.drawable.vietnam, 4.2f),
                new BucketListEntry("Kerala, India", "Try varied tea flavours, stay in houseboat, the fabulous food!",R.drawable.kerala, 5),
                new BucketListEntry("Japan", "Hot springs, sushi, bamboo forest, bullet train through mountains.",R.drawable.japan, 4.5f),
                new BucketListEntry("Iceland", "Dynjandi Waterfall, nature reserves, maybe the Northern Lights too!",R.drawable.iceland, 4),
                new BucketListEntry("The Amazon, Brazil", "Try to survive being scared by all the creepy crawlies!",R.drawable.amazon, 4.4f),
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_view_places_to_go);
        BucketListEntryAdapter adapter = new BucketListEntryAdapter(placesToGo);
        recyclerView.setAdapter(adapter);
    }


}