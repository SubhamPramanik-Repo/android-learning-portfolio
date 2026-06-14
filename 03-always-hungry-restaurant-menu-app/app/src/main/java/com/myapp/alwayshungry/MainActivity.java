package com.myapp.alwayshungry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CardView card_view_starters;
    CardView card_view_main_courses;
    CardView card_view_desserts;

    TextView text_view_our_location;
    TextView text_view_call_us;
    TextView text_view_whatsapp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card_view_starters = findViewById(R.id.card_view_starters);
        card_view_main_courses = findViewById(R.id.card_view_main_courses);
        card_view_desserts = findViewById(R.id.card_view_desserts);

        text_view_our_location = findViewById(R.id.text_view_our_location);
        text_view_call_us = findViewById(R.id.text_view_call_us);
        text_view_whatsapp = findViewById(R.id.text_view_whatsapp);

        card_view_starters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startersActivityIntent = new Intent(MainActivity.this,StartersActivity.class);
                startActivity(startersActivityIntent);
            }
        });

        card_view_main_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainCoursesActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
                startActivity(mainCoursesActivityIntent);
            }
        });

        card_view_desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dessertActivityIntent = new Intent(MainActivity.this, DessertsActivity.class);
                startActivity(dessertActivityIntent);
            }
        });

        text_view_our_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri locationUri = Uri.parse(
                        "geo:18.5912,73.7389?q=18.5912,73.7389(" +
                                Uri.encode("Always Hungry Restaurant Pune") +")"
                );
                Intent ourLocationIntent = new Intent(Intent.ACTION_VIEW,locationUri);
                ourLocationIntent.setPackage("com.google.android.apps.maps");

                if (ourLocationIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(ourLocationIntent);
                }else{
                    Toast.makeText(MainActivity.this, "No Map app found!", Toast.LENGTH_LONG).show();
                }
            }
        });

        text_view_call_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri callUri = Uri.parse("tel:7679013257");
                Intent callUsIntent = new Intent(Intent.ACTION_DIAL, callUri);
                if(callUsIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(callUsIntent);
                }else{
                    Toast.makeText(MainActivity.this, "No dialer app found!",Toast.LENGTH_LONG).show();
                }
            }
        });

        text_view_whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "917679013257";
                String message = "Hello Always Hungry, I want to know more about your menu.";
                String whatsappURL = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + Uri.encode(message);
                Intent whatsappIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(whatsappURL));
                if(whatsappIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(whatsappIntent);
                }else{
                    Toast.makeText(MainActivity.this, "WhatsApp not found!", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}