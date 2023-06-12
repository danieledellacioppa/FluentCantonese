package com.poetic.FluentCantonese.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.poetic.FluentCantonese.R;

public class FlashcardActivity extends AppCompatActivity {

    private ViewFlipper flipper;

    private boolean isFront = true;

    private TextView recordedText;

    private Button recordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        flipper = findViewById(R.id.flipper);
        LinearLayout frontLayout = findViewById(R.id.frontLayout);
        LinearLayout backLayout = findViewById(R.id.backLayout);
        recordButton = findViewById(R.id.recordButton);
        recordedText = findViewById(R.id.recordingView);

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
        ViewFlipper flipper = findViewById(R.id.flipper);

        if (flipper.getDisplayedChild() == 0) {
            flipper.setInAnimation(this, R.anim.slide_in_right);
            flipper.setOutAnimation(this, R.anim.slide_out_left);
            flipper.showNext();
        } else {
            flipper.setInAnimation(this, R.anim.slide_in_right);
            flipper.setOutAnimation(this, R.anim.slide_out_left);
            flipper.showPrevious();
        }
    }



}