package com.myapp.alwayshungry;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DessertsActivity extends AppCompatActivity {

    ListView dessertsList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        dessertsList = findViewById(R.id.list_view_desserts);
        Dish[] desserts = {
                new Dish("Chocolate Cake", "Rich chocolate sponge cake", 180),
                new Dish("Ice Cream", "Vanilla ice cream scoop", 120),
                new Dish("Brownie", "Hot chocolate brownie", 150),
                new Dish("Cheesecake", "Creamy baked cheesecake", 200),
                new Dish("Cupcake", "Soft cupcake with frosting", 90),
                new Dish("Donut", "Glazed sugar donut", 70),
                new Dish("Waffle", "Crispy waffle with honey", 160),
                new Dish("Pancake", "Fluffy pancakes with syrup", 140),
                new Dish("Apple Pie", "Classic apple cinnamon pie", 170),
                new Dish("Tiramisu", "Coffee-flavoured Italian dessert", 220),
                new Dish("Gulab Jamun", "Milk-based Indian sweet in syrup", 130),
                new Dish("Rasgulla", "Soft cheese balls in sugar syrup", 120),
                new Dish("Fruit Salad", "Fresh seasonal fruits mix", 110),
                new Dish("Chocolate Mousse", "Smooth and creamy chocolate mousse", 190),
                new Dish("Custard", "Vanilla flavoured milk custard", 100),
                new Dish("Red Velvet Cake", "Red velvet cake with cream cheese", 210),
                new Dish("Cookies", "Fresh baked chocolate chip cookies", 80),
                new Dish("Banana Split", "Banana with ice cream scoops", 180),
                new Dish("Pudding", "Soft caramel pudding", 130),
                new Dish("Crème Brûlée", "French vanilla custard with caramel top", 240)
        };

        ArrayAdapter <Dish> dessertsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,desserts);
        dessertsList.setAdapter(dessertsAdapter);
    }
}