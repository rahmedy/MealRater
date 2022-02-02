package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MealRaterDialog.SaveRating {

    public EditText restaurant, dish;
    public TextView ratingDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurant = findViewById(R.id.editRestaurant);
        dish = findViewById(R.id.editDish);

        RateMealButton();

    }

    @Override
    public void finishMealRaterDialog(String rating) {
        ratingDisplay = findViewById(R.id.textView2);
        ratingDisplay.setText(rating);
    }

    private void RateMealButton() {

        Button rate = findViewById(R.id.buttonRateMeal);
        rate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
                MealRaterDialog mealRaterDialog = new MealRaterDialog();
                mealRaterDialog.show(fm, "RateMeal");

            }
        });
    }
}