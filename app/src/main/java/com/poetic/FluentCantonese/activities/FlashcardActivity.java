package com.poetic.FluentCantonese.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
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

public class FlashcardActivity extends AppCompatActivity {
    private TextView textViewFront;
    private TextView textViewBack;
    private Button nextButton;
    private TextInputEditText textInputEditText;
    String userText = null;
    String correctAnswer = null;
    private int currentIndex = 0;
    private List<Flashcard> flashcards;
    private boolean flipCardClicked = false;

    private FlashcardDeck flashcardDeck;

    private int lessonNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        //get intent extra from the previous activity
        lessonNumber = getIntent().getIntExtra("lessonNumber", 0);


        textInputEditText = findViewById(R.id.textInputEditText);

        textViewFront = findViewById(R.id.textViewFront);
        textViewBack = findViewById(R.id.textViewBack);
        nextButton = findViewById(R.id.nextButton);

        flashcards = getFlashcards(); // Metodo per ottenere le flashcard dal database o da un vettore temporaneo

        showFlashcard(currentIndex);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText = textInputEditText.getText().toString();
                correctAnswer = flashcards.get(currentIndex).getBackText();
                if (!flipCardClicked && userText != null) {
                    if (correctAnswer.equals(userText)) {
                        Toast.makeText(FlashcardActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        textInputEditText.setText("");
                    } else {
                        Toast.makeText(FlashcardActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                        textInputEditText.setText("");
                    }
                    flipCard();
                    textInputEditText.setVisibility(View.INVISIBLE);
                    nextButton.setText("Next");
                    flipCardClicked = true;
                } else {
                    showNextFlashcard();
                    textInputEditText.setVisibility(View.VISIBLE);
                    nextButton.setText("Check");
                    flipCardClicked = false;
                }
            }
        });

        textViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display jutping
                Toast.makeText(FlashcardActivity.this, flashcards.get(currentIndex).getJutPing(), Toast.LENGTH_SHORT).show();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.correct)  // R.drawable.ic_notification è il nome dell'immagine PNG nella cartella res/drawable
                .setContentTitle("Titolo della notifica")
                .setContentText("Testo della notifica")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here we are requesting the permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);

            return;
        }
        notificationManager.notify(R.drawable.correct, builder.build());


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
        flashcardDeck = new FlashcardDeck(lessonNumber);

        return flashcardDeck.getFlashcards();
    }
}

