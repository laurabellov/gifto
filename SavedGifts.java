package com.example.giftoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SavedGifts extends AppCompatActivity {

    private ArrayList<FolderModal> foldereModalArrayList;
    private DBHandler dbHandler;
    private FolderRVAdapter folderRVAdapter;
    private RecyclerView folderRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_gifts);

        foldereModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(SavedGifts.this);
        foldereModalArrayList = dbHandler.readCourses();

        // on below line passing our array list to our adapter class.
        folderRVAdapter = new FolderRVAdapter(foldereModalArrayList, SavedGifts.this);
        folderRV = findViewById(R.id.idRVfolder);

        // setting our adapter to recycler view.
        folderRV.setAdapter(folderRVAdapter);

    }

}