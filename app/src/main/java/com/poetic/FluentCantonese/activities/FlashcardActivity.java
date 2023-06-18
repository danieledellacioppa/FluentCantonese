package com.poetic.FluentCantonese.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.poetic.FluentCantonese.R;
import com.poetic.FluentCantonese.tools.Flashcard;

import java.util.ArrayList;
import java.util.List;

public class FlashcardActivity extends AppCompatActivity
{
    private TextView textViewFront;
    private TextView textViewBack;
    private Button nextButton;
    private TextInputEditText textInputEditText;
    String userText = null;
    String correctAnswer = null;
    private int currentIndex = 0;
    private List<Flashcard> flashcards;
    private boolean flipCardClicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        textInputEditText = findViewById(R.id.textInputEditText);

        textViewFront = findViewById(R.id.textViewFront);
        textViewBack = findViewById(R.id.textViewBack);
        nextButton = findViewById(R.id.nextButton);

        flashcards = getFlashcards(); // Metodo per ottenere le flashcard dal database o da un vettore temporaneo

        showFlashcard(currentIndex);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                userText = textInputEditText.getText().toString();
                correctAnswer = flashcards.get(currentIndex).getBackText();
                if (!flipCardClicked && userText != null)
                {
                    if (correctAnswer.equals(userText))
                    {
                        Toast.makeText(FlashcardActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        textInputEditText.setText("");
                    }
                    else
                    {
                        Toast.makeText(FlashcardActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                        textInputEditText.setText("");
                    }
                    flipCard();
                    flipCardClicked = true;
                }
                else
                {
                    showNextFlashcard();
                    flipCardClicked = false;
                }
            }
        });

        textViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //display jutping
                Toast.makeText(FlashcardActivity.this, flashcards.get(currentIndex).getJutPing(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showNextFlashcard()
    {
        currentIndex++;
        if (currentIndex >= flashcards.size())
        {
            currentIndex = 0;
        }
        showFlashcard(currentIndex);
        flipCard();
    }

    private void flipCard()
    {
        ViewFlipper flipper = findViewById(R.id.flipper);

        if (flipper.getDisplayedChild() == 0)
        {
//            flipper.setInAnimation(this, R.anim.slide_in_right);
//            flipper.setOutAnimation(this, R.anim.slide_out_left);
            flipper.showNext();
        }
        else
        {
//            flipper.setInAnimation(this, R.anim.slide_in_right);
//            flipper.setOutAnimation(this, R.anim.slide_out_left);
            flipper.showPrevious();
        }
    }

    private void showFlashcard(int index)
    {
        Flashcard flashcard = flashcards.get(index);
        textViewFront.setText(flashcard.getFrontText());
        textViewBack.setText(flashcard.getBackText());
    }

    private List<Flashcard> getFlashcards()
    {
        // Esempio di creazione di un vettore temporaneo di flashcard
        List<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("Hello", "你好","nei5 hou2"));
        flashcards.add(new Flashcard("Goodbye", "再見","zoi3 gin3"));
        flashcards.add(new Flashcard("Sorry", "對唔住","deoi3 m4 zyu6"));
        flashcards.add(new Flashcard("Please", "唔該","m4 goi1"));
        flashcards.add(new Flashcard("I", "我","ngo5"));
        flashcards.add(new Flashcard("You", "你","nei5"));
        flashcards.add(new Flashcard("He", "佢","keoi5"));
        flashcards.add(new Flashcard("She", "佢","keoi5"));
        flashcards.add(new Flashcard("We", "我哋","ngo5 dei6"));
        flashcards.add(new Flashcard("They", "佢哋","keoi5 dei6"));
        flashcards.add(new Flashcard("This", "呢個","ni1 go3"));
        flashcards.add(new Flashcard("That", "嗰個","go2 go3"));
        flashcards.add(new Flashcard("Here", "呢度","ni1 dou6"));


        // Aggiungi altre flashcard qui

        return flashcards;
    }
}

