package com.example.giftoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserPage extends AppCompatActivity {
    private ImageButton home, search ,settings;
    private Button ADDnewfolder, seeGiftsBtn;
    private EditText folderName;
    private DBHandler dbHandler;
     TextView tv;
    String fname;
    private ArrayList<String> giftList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userpage);

        tv = findViewById(R.id.usernameTv);
        home = (ImageButton) findViewById(R.id.home);
        search = (ImageButton) findViewById(R.id.search);
        settings = (ImageButton) findViewById(R.id.settings);
        giftList = new ArrayList<>();

        folderName=findViewById(R.id.EdtFolderName);
        ADDnewfolder=findViewById(R.id.BtnNewFolder);
        dbHandler= new DBHandler(UserPage.this);
        seeGiftsBtn=findViewById(R.id.seeGifts);


        ADDnewfolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String folder = folderName.getText().toString();

                if (folder.isEmpty()) {
                    Toast.makeText(UserPage.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
               dbHandler.addNewFolder(folder);

                // after adding the data we are displaying a toast message.
                Toast.makeText(UserPage.this, "Folder has been added.", Toast.LENGTH_SHORT).show();
                folderName.setText("");
            }
        });
        seeGiftsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(UserPage.this, SavedGifts.class);
                startActivity(i);
            }
        });



        SharedPreferences sp = getApplicationContext().getSharedPreferences("details", Context.MODE_PRIVATE);
        fname = sp.getString("fname", "");
        tv.setText(fname);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity4();
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

    public void openactivity4() {
        Intent intent = new Intent(this, HomePage.class);
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


