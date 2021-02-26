package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView cardQuestion = findViewById(R.id.flashcardQuestion);
        TextView cardAnswer = findViewById(R.id.flashcardAnswer);
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
    }
}