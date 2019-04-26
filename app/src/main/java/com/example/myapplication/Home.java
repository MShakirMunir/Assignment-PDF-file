package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Recipes");
    }

    public void addRecipe(View view) {
        Intent addRecipe = new Intent(Home.this, AddRecipe.class);
        startActivity(addRecipe);
    }

    public void viewRecipe(View view) {
        Intent viewRecipes = new Intent(Home.this, ViewRecipes.class);
        startActivity(viewRecipes);
    }
}
