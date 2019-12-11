package com.example.application;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Page5 extends AppCompatActivity {
    private Button button1; // button for Warren
    private Button button2; // button for Brownstone
    private Button button3; // button for Whitestone
    private Button button4; // button for South

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = findViewByID(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                openWarren(); // Go to Class Warren page
            }
        });

        button2 = findViewByID(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                openBrownstone(); // Go to Class Brownstone page
            }
        });

        button3 = findViewByID(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                openWhitestone(); // Go to Class Whitestone page
            }
        });

        button4 = findViewByID(R.id.button5);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openSouth(); // Go to Class South page
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

    public void openWarren(){
        Intent intent = new Intent(this, Warren.class);
        startActivity(intent);
    }

    public void openBrownstone(){
        Intent intent = new Intent(this, Brownstone.class);
        startActivity(intent);
    }

    public void openWhitestone(){
        Intent intent = new Intent(this, Whiteston.class);
        startActivity(intent);
    }

    public void openSouth(){
        Intent intent = new Intent(this, South.class);
        startActivity(intent);
    }

}
