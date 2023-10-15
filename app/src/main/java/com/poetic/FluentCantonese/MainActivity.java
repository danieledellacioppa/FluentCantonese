package com.poetic.FluentCantonese;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.poetic.FluentCantonese.activities.FlashcardActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setButtons();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<IconItem> iconList = createIconList(); // Metodo per creare la lista delle icone

        IconAdapter adapter = new IconAdapter(this, iconList);
        recyclerView.setAdapter(adapter);


    }

    private List<IconItem> createIconList() {
        List<IconItem> iconList = new ArrayList<>();
        iconList.add(new IconItem(R.drawable.lesson_1, "Lesson 1"));
        iconList.add(new IconItem(R.drawable.lesson_2, "Lesson 2"));
//        iconList.add(new IconItem(R.drawable.lesson_3, "Lesson 3"));
//        iconList.add(new IconItem(R.drawable.lesson_4, "Lesson 4"));
//        iconList.add(new IconItem(R.drawable.lesson_5, "Lesson 5"));
//        iconList.add(new IconItem(R.drawable.lesson_6, "Lesson 6"));
//        iconList.add(new IconItem(R.drawable.lesson_7, "Lesson 7"));
//        iconList.add(new IconItem(R.drawable.lesson_8, "Lesson 8"));
//        iconList.add(new IconItem(R.drawable.lesson_9, "Lesson 9"));
//        iconList.add(new IconItem(R.drawable.lesson_10, "Lesson 10"));
        return iconList;
    }


//    void setButtons()
//    {
//        button = (ImageView) findViewById(R.id.lesson_1);
//        button.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent = new Intent(MainActivity.this, FlashcardActivity.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });
//    }
}