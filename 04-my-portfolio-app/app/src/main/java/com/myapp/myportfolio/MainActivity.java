package com.myapp.myportfolio;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler_view_projects = findViewById(R.id.recycler_view_projects);

        Project[] projects = {
                new Project("Getting Started App", "My first Android project, where I learned the basics of app structure and development.", R.drawable.getting_started),
                new Project("Motivational Quote", "A simple app focused on layout customization, featuring a personal motivational quote.", R.drawable.quote),
                new Project("BMI Calculator", "A practical BMI calculator that helped me understand variables, methods, and conditional logic in Java.", R.drawable.calculator),
                new Project("Inches Converter", "A basic converter app to convert inches to meter, that strengthened my understanding of logic implementation and method usage.", R.drawable.tape),
                new Project("Always Hungry", "A fictional restaurant menu app where I learned about Activities, classes, objects, arrays, Intents, CardView, and ListView.", R.drawable.hungry_developer)
        };

        ProjectsAdapter adapter = new ProjectsAdapter(projects);
        recycler_view_projects.setAdapter(adapter);

    }
}