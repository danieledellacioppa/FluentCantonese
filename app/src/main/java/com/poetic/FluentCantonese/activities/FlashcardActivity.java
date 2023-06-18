package com.poetic.FluentCantonese.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.poetic.FluentCantonese.R;
import com.poetic.FluentCantonese.tools.Flashcard;

import java.util.ArrayList;
import java.util.List;

public class FlashcardActivity extends AppCompatActivity {

    private TextView textViewFront;
    private TextView textViewBack;
    private Button nextButton;

    private int currentIndex = 0;
    private List<Flashcard> flashcards;
    private boolean flipCardClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        textViewFront = findViewById(R.id.textViewFront);
        textViewBack = findViewById(R.id.textViewBack);
        nextButton = findViewById(R.id.nextButton);

        flashcards = getFlashcards(); // Metodo per ottenere le flashcard dal database o da un vettore temporaneo

        showFlashcard(currentIndex);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flipCardClicked) {
                    flipCard();
                    flipCardClicked = true;
                } else {
                    showNextFlashcard();
                    flipCardClicked = false;
                }
            }
        });
    }

    private void showNextFlashcard() {
        currentIndex++;
        if (currentIndex >= flashcards.size()) {
            currentIndex = 0;
        }
        showFlashcard(currentIndex);
        flipCard();
    }

    private void flipCard() {
        ViewFlipper flipper = findViewById(R.id.flipper);

        if (flipper.getDisplayedChild() == 0) {
//            flipper.setInAnimation(this, R.anim.slide_in_right);
//            flipper.setOutAnimation(this, R.anim.slide_out_left);
            flipper.showNext();
        } else {
//            flipper.setInAnimation(this, R.anim.slide_in_right);
//            flipper.setOutAnimation(this, R.anim.slide_out_left);
            flipper.showPrevious();
        }
    }

    private void showFlashcard(int index) {
        Flashcard flashcard = flashcards.get(index);
        textViewFront.setText(flashcard.getFrontText());
        textViewBack.setText(flashcard.getBackText());
    }

    private List<Flashcard> getFlashcards() {
        // Esempio di creazione di un vettore temporaneo di flashcard
        List<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("Hello", "你好\nnei5 hou2"));
        flashcards.add(new Flashcard("Goodbye", "再見\nzoi3 gin3"));
        flashcards.add(new Flashcard("Sorry", "對唔住\ndeoi3 m4 zyu6"));
        flashcards.add(new Flashcard("Please", "唔該\nm4 goi1"));
        flashcards.add(new Flashcard("I", "我\nngo5"));
        flashcards.add(new Flashcard("You", "你\nnei5"));
        flashcards.add(new Flashcard("He", "佢\nkeoi5"));
        flashcards.add(new Flashcard("She", "佢\nkeoi5"));
        flashcards.add(new Flashcard("We", "我哋\nngo5 dei6"));
        flashcards.add(new Flashcard("They", "佢哋\nkeoi5 dei6"));
        flashcards.add(new Flashcard("This", "呢個\nni1 go3"));

        // Aggiungi altre flashcard qui

        return flashcards;
    }
}

