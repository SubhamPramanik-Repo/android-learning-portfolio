package com.myapp.alwayshungry;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainCoursesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_courses);

        ListView mainCoursesList = findViewById(R.id.list_view_main_courses);

        Dish[] mainCourses={
                new Dish("Paneer Butter Masala", "Soft paneer cubes cooked in rich buttery tomato gravy with mild Indian spices", 320),
                new Dish("Kadhai Paneer", "Paneer cubes tossed with capsicum, onion, tomato and freshly ground kadhai masala", 300),
                new Dish("Palak Paneer", "Cottage cheese cubes simmered in creamy spinach gravy with garlic and spices", 290),
                new Dish("Paneer Lababdar", "Paneer cooked in a rich tomato-onion gravy finished with cream and aromatic spices", 340),
                new Dish("Shahi Paneer", "Soft paneer pieces cooked in royal creamy cashew-based gravy with mild spices", 350),

                new Dish("Dal Makhani", "Black lentils slow cooked with butter, cream and traditional Punjabi spices", 280),
                new Dish("Dal Tadka", "Yellow lentils tempered with ghee, garlic, cumin and red chilli", 220),
                new Dish("Chole Masala", "Chickpeas cooked in spicy onion-tomato gravy with North Indian masala", 240),
                new Dish("Rajma Masala", "Red kidney beans cooked in thick tomato gravy with homestyle spices", 250),
                new Dish("Veg Kolhapuri", "Mixed vegetables cooked in spicy Kolhapuri-style coconut and chilli gravy", 270),

                new Dish("Mix Veg Curry", "Fresh seasonal vegetables cooked in medium spicy onion-tomato gravy", 260),
                new Dish("Malai Kofta", "Soft vegetable and paneer koftas served in creamy cashew-tomato gravy", 340),
                new Dish("Mushroom Masala", "Button mushrooms cooked with onion, tomato and aromatic Indian spices", 300),
                new Dish("Aloo Gobi Masala", "Potato and cauliflower cooked with turmeric, cumin and traditional spices", 230),
                new Dish("Veg Handi", "Mixed vegetables cooked in a clay-pot style rich and flavorful gravy", 290),

                new Dish("Butter Chicken", "Tender chicken pieces cooked in creamy buttery tomato gravy with mild spices", 420),
                new Dish("Chicken Tikka Masala", "Grilled chicken tikka pieces cooked in rich spicy onion-tomato gravy", 430),
                new Dish("Chicken Curry", "Classic homestyle chicken cooked in onion-tomato gravy with Indian spices", 380),
                new Dish("Mutton Rogan Josh", "Tender mutton pieces slow cooked in Kashmiri-style aromatic red gravy", 520),
                new Dish("Chicken Biryani", "Fragrant basmati rice layered with marinated chicken, herbs and biryani spices", 360)
        };

        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mainCourses);
        mainCoursesList.setAdapter(dishesAdapter);
    }


}
