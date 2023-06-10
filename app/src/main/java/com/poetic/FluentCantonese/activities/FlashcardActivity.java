package com.poetic.FluentCantonese.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.poetic.FluentCantonese.R;

public class FlashcardActivity extends AppCompatActivity {
    private boolean isFront = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        LinearLayout frontLayout = findViewById(R.id.frontLayout);
        LinearLayout backLayout = findViewById(R.id.backLayout);

        frontLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });

    }

    private void flipCard() {
        LinearLayout frontLayout = findViewById(R.id.frontLayout);
        LinearLayout backLayout = findViewById(R.id.backLayout);

        View frontTextView = findViewById(R.id.textViewFront);
        View backTextView = findViewById(R.id.textViewBack);

        // Effettua l'animazione di flip sulle viste dei layout frontali e posteriori
        frontLayout.animate().rotationY(90f).setDuration(500);
        backLayout.animate().rotationY(90f).setDuration(500);

        // Imposta il testo corretto sulla vista frontale
        if (isFront) {
            ((TextView) frontTextView).setText("Hello");
        } else {
            ((TextView) frontTextView).setText("你好");
        }

        // Imposta il testo corretto sulla vista posteriore
        if (isFront) {
            ((TextView) backTextView).setText("你好");
        } else {
            ((TextView) backTextView).setText("Hello");
        }

        // Effettua un'animazione di flip inversa dopo un ritardo di 250 ms per mostrare il nuovo testo
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                frontLayout.animate().rotationY(0f).setDuration(500);
                backLayout.animate().rotationY(0f).setDuration(500);
            }
        }, 250);

        // Inverte lo stato della flashcard
        isFront = !isFront;
    }


}