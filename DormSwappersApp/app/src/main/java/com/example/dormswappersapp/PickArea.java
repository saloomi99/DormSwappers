package com.example.dormswappersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PickArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_area);
    }

    public void OpenEast(View view) {
        startActivity(new Intent(this, EastBuildings.class));
    }
    public void OpenCentral(View view) {
        startActivity(new Intent(this, CentralBuildings.class));
    }
    public void OpenWest(View view) {
        startActivity(new Intent(this, WestBuildings.class));
    }
    public void OpenSouth(View view) {
        startActivity(new Intent(this, SouthBuildings.class));
    }
}
