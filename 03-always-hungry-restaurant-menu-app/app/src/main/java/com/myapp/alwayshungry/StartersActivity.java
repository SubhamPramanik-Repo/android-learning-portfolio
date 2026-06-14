package com.myapp.alwayshungry;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_starters);

        ListView list_view_starters = findViewById(R.id.list_view_starters);


        Dish[] dishes = {
                new Dish("Paneer Tikka","Soft paneer cubes marinated in yogurt and spices, grilled to perfection",280),
                new Dish("Chicken Tikka","Boneless chicken pieces marinated with spices and cooked in tandoor",320),
                new Dish("Hara Bhara Kebab","Healthy kebabs made from spinach, peas and potatoes",220),
                new Dish("Veg Seekh Kebab","Minced vegetables mixed with herbs and grilled on skewers",240),
                new Dish("Chicken Seekh Kebab","Juicy minced chicken kebabs with Indian spices",300),
                new Dish("Tandoori Chicken","Classic tandoori chicken marinated in yogurt and spices",380),
                new Dish("Tandoori Prawns","Fresh prawns marinated and grilled in tandoor",420),
                new Dish("Malai Tikka","Creamy chicken tikka cooked with rich malai marinade",340),
                new Dish("Aloo Tikki","Crispy potato patties served with Indian spices",180),
                new Dish("Samosa","Deep fried pastry stuffed with spiced potatoes and peas",120),
                new Dish("Veg Pakora","Mixed vegetables dipped in gram flour and fried",160),
                new Dish("Onion Bhaji","Crispy fried onion fritters with mild spices",150),
                new Dish("Dahi Puri","Crispy puris filled with yogurt, chutneys and spices",190),
                new Dish("Pani Puri (Golgappa)","Crispy puris filled with spicy tangy water",160),
                new Dish("Sev Puri","Chaat made with puris, potatoes, chutneys and sev",180),
                new Dish("Bhel Puri","Puffed rice mixed with chutneys and vegetables",170),
                new Dish("Papdi Chaat","Papdi topped with potatoes, yogurt and chutneys",200),
                new Dish("Dahi Vada","Soft lentil dumplings soaked in creamy yogurt",190),
                new Dish("Chicken 65","Spicy deep-fried South Indian chicken starter",290),
                new Dish("Gobi Manchurian","Crispy cauliflower tossed in Indo-Chinese sauce",210),
        };

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);

        list_view_starters.setAdapter(dishesAdapter);

    }
}