package com.example.flashcardapp;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // boolean for icon visibility
    boolean isShowingAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView cardQuestion = findViewById(R.id.flashcardQuestion);
        TextView cardAnswer = findViewById(R.id.flashcardAnswer);

        // user can toggle between the front and back of the question card by clicking on it
        cardQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardQuestion.setVisibility(View.INVISIBLE);
                cardAnswer.setVisibility(View.VISIBLE);
            }
        });
        cardAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardAnswer.setVisibility(View.INVISIBLE);
                cardQuestion.setVisibility(View.VISIBLE);
            }
        });

        TextView choiceOne = findViewById(R.id.multiplechoiceOne);
        TextView choiceTwo = findViewById(R.id.multiplechoiceTwo);
        TextView choiceThree = findViewById(R.id.multiplechoiceThree);

        // if the user clicks the wrong answer, their choice changes to red and the correct answer is shown in green
        choiceOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceOne.setBackgroundColor(getResources().getColor(R.color.barnred, null));
                choiceTwo.setBackgroundColor(getResources().getColor(R.color.forestgreen, null));
            }
        });

        // if the user clicks the right answer, the color changes to green
        choiceTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceTwo.setBackgroundColor(getResources().getColor(R.color.forestgreen, null));
            }
        });

        // if the user clicks the wrong answer, their choice changes to red and the correct answer is shown in green
        choiceThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceThree.setBackgroundColor(getResources().getColor(R.color.barnred, null));
                choiceTwo.setBackgroundColor(getResources().getColor(R.color.forestgreen, null));
            }
        });

        // User can tap on the background view to reset all views to default settings.
        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceOne.setBackgroundColor(getResources().getColor(R.color.bluesapphire, null));
                choiceTwo.setBackgroundColor(getResources().getColor(R.color.bluesapphire, null));
                choiceThree.setBackgroundColor(getResources().getColor(R.color.bluesapphire, null));
            }
        });

        // the user can toggle between the multiple choice options being visible or invisible
        ImageView toggleEye = findViewById(R.id.toggle_choices_visibility);
        toggleEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowingAnswer) {
                    choiceOne.setVisibility(View.INVISIBLE);
                    choiceTwo.setVisibility(View.INVISIBLE);
                    choiceThree.setVisibility(View.INVISIBLE);
                    toggleEye.setImageResource(R.drawable.visible_eye);
                }
                else {
                    choiceOne.setVisibility(View.VISIBLE);
                    choiceTwo.setVisibility(View.VISIBLE);
                    choiceThree.setVisibility(View.VISIBLE);
                    toggleEye.setImageResource(R.drawable.hidden_eye);
                }
               isShowingAnswer = !isShowingAnswer;
            }
        });
    }
}