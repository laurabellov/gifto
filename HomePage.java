package com.example.giftoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
    private ImageButton profile, search ,settings;

    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        profile = (ImageButton) findViewById(R.id.UserProfile);
        search = (ImageButton)  findViewById(R.id.search);
        settings = (ImageButton)  findViewById(R.id.settings);
        button5 = (Button) findViewById(R.id.button5);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetUserProfile();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity6();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity6();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity7();
            }
        });
    }

    public void GetUserProfile() {
        Intent intent = new Intent(this, UserPage.class);
        startActivity(intent);

    }
    public void openactivity6() {
        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
    }
    public void openactivity7() {
        Intent intent = new Intent(this, SettingsPage.class);
        startActivity(intent);
    }






}