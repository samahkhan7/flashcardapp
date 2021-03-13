package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        // EditText declared
        EditText enterQ = findViewById(R.id.enterQuestion);
        EditText enterA = findViewById(R.id.enterAnswer);

        // saves the data entered by the user when they click the save icon
        // exits AddCardActivity after doing so
        findViewById((R.id.saveButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get data from EditTexts
                String userQ = enterQ.getText().toString();
                String userA = enterA.getText().toString();

                // activity intent
                Intent data = new Intent();
                data.putExtra("userQuestion", userQ);
                data.putExtra("userAnswer", userA);
                setResult(RESULT_OK, data);
                finish();
            }
        });

        // exits AddCardActivity if the cancel button is clicked
        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}