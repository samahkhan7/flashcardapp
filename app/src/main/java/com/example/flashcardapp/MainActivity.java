package com.example.flashcardapp;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // boolean for icon visibility
    boolean isShowingAnswer;

    // flashcard database variable declared
    FlashcardDatabase flashcardDatabase;
    // variable to hold a list of flashcards declared
    List<Flashcard> allFlashcards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declares flashcard question and answer sides as text views
        TextView cardQuestion = findViewById(R.id.flashcardQuestion);
        TextView cardAnswer = findViewById(R.id.flashcardAnswer);


        // initialize the flashcardDatabase variable
        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        // displays the first card at index 0
        Flashcard flashcard = flashcardDatabase.getAllCards().get(0);
        String question = flashcard.getQuestion();
        cardQuestion.setText(question);
        String answer = flashcard.getAnswer();
        cardAnswer.setText(answer);

        // access saved flashcards
        allFlashcards = flashcardDatabase.getAllCards();

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
                } else {
                    choiceOne.setVisibility(View.VISIBLE);
                    choiceTwo.setVisibility(View.VISIBLE);
                    choiceThree.setVisibility(View.VISIBLE);
                    toggleEye.setImageResource(R.drawable.hidden_eye);
                }
                isShowingAnswer = !isShowingAnswer;
            }
        });

        // the user is taken to AddCardActivity when the plus button is clicked
        findViewById(R.id.plusButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 1);

                cardQuestion.getText().toString();
                cardAnswer.getText().toString();
            }
        });
    }

    // data from AddCardActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            String question0 = data.getExtras().getString("userQuestion");
            String answer1 = data.getExtras().getString("userAnswer");

            TextView cardQ = findViewById(R.id.flashcardQuestion);
            TextView cardA = findViewById(R.id.flashcardAnswer);

            // changes what appears on the flashcard question and answer sides
            cardQ.setText(question0);
            cardA.setText(answer1);

            // saves the flashcard question and answer to database
            flashcardDatabase.insertCard(new Flashcard(question0, answer1));
            // update variable holding list of flashcards
            allFlashcards = flashcardDatabase.getAllCards();
        }
    }
}