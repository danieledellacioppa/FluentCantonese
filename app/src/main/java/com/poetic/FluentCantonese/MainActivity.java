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
        iconList.add(new IconItem(R.drawable.lesson_1, 1));
        iconList.add(new IconItem(R.drawable.lesson_2, 2));
//        iconList.add(new IconItem(R.drawable.lesson_3, 3));
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