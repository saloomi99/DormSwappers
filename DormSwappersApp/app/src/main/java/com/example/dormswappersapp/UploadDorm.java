package com.example.dormswappersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UploadDorm extends AppCompatActivity {
    EditText location, address, roomtype, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_dorm);
        location = (EditText)findViewById(R.id.etLocation);
        address = (EditText)findViewById(R.id.etAddress);
        roomtype = (EditText)findViewById(R.id.etRoomtype);
        email = (EditText)findViewById(R.id.etEmail);
    }

    public void onUpload(View view) {
        String str_location = location.getText().toString();
        String str_address = address.getText().toString();
        String str_roomtype = roomtype.getText().toString();
        String str_email = email.getText().toString();
        String type = "registerdorm";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_location, str_address, str_roomtype, str_email);
    }
}
