package com.example.dormswappersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    public void onSearch(View view) {
        startActivity(new Intent(this,PickArea.class));
    }
    public void OpenList(View view) {
        startActivity(new Intent(this,UploadDorm.class));
    }

}
