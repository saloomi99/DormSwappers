package com.example.application;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Page4 extends AppCompatActivity {
    private Button button1; // button for Stuvi 1
    private Button button2; // button for Stuvi 2
    private Button button3; // button for Rich/Sleeper/Claflin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = findViewByID(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                openStuvi1(); // Go to Class Stuvi1 page
            }
        });

        button2 = findViewByID(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openStuvi2(); // Go to Class Stuvi2 page
            }
        });

        button3 = findViewByID(R.id.button4);
        buton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openWestDorms(); // Go to Class WestDorms page
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void openStuvi1(){
        Intent intent = new Intent(this, Stuvi1.class);
        startActivity(intent);
    }

    public void openStuvi2(){
        Intent intent = new Intent(this, Stuvi2.class);
        startActivity(intent);
    }

    public void openWestDorms(){
        Intent intent = new Intent(this, WestDorms.class);
        startActivity(intent);
    }

}
