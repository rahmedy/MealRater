package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.fragment.app.DialogFragment;

public class MealRaterDialog extends DialogFragment {

    String rating;

    public interface SaveRating {
        void finishMealRaterDialog(String rating);
    }

    public MealRaterDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.meal_rater, container);

        Button save = view.findViewById(R.id.SaveButton);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                rating = String.valueOf(ratingBar.getRating());
                SaveItem(String.valueOf(rating));

            }
        });
        return view;
    }
    private void SaveItem(String rating) {

        MealRaterDialog.SaveRating activity = (MealRaterDialog.SaveRating) getActivity();
        activity.finishMealRaterDialog(rating);
        getDialog().dismiss();

    }

}
