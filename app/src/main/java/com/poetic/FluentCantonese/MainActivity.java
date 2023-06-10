package com.poetic.FluentCantonese;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poetic.FluentCantonese.activities.FlashcardActivity;

public class MainActivity extends AppCompatActivity {

    Button button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtons();
    }

    void setButtons()
    {
        button = (Button) findViewById(R.id.buttonFlashcard);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, FlashcardActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}