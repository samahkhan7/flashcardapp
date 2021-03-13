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

        // TEST? Data from main activity
        // String data = getIntent().getStringExtra("key");

        findViewById((R.id.saveButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((EditText) findViewById(R.id.enterQuestion)).getText().toString();

                Intent data = new Intent();
                data.putExtra("userQuestion", "some string");
                data.putExtra("userAnswer", "another string here");
                setResult(RESULT_OK, data);
                finish();
            }
        });

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}