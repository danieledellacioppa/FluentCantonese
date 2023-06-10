package com.poetic.FluentCantonese.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import com.poetic.FluentCantonese.R;

public class FlashcardActivity extends AppCompatActivity {

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
        View flashcardLayout = findViewById(R.id.flashcardLayout);

        // Esegue l'animazione di flip
        ObjectAnimator flipAnimator = ObjectAnimator.ofFloat(flashcardLayout, "rotationY", 0f, 180f);
        flipAnimator.setDuration(500);
        flipAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        flipAnimator.start();

        // Inverte la visibilità dei layout fronte e retro
        LinearLayout frontLayout = findViewById(R.id.frontLayout);
        LinearLayout backLayout = findViewById(R.id.backLayout);
        if (frontLayout.getVisibility() == View.VISIBLE) {
            frontLayout.setVisibility(View.GONE);
            backLayout.setVisibility(View.VISIBLE);
        } else {
            frontLayout.setVisibility(View.VISIBLE);
            backLayout.setVisibility(View.GONE);
        }
    }

}