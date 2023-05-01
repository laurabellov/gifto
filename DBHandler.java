package com.example.giftoo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME="folderDB";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME ="mySavedGifts";
    private static final String ID_COL = "id";

    private static final String NAME_COL = "name";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT)";
       db.execSQL(query);
    }

    public void addNewFolder(String folderName){
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
       ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, folderName);

        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public ArrayList<FolderModal> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<FolderModal> folderModalArrayList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + "; ", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(ID_COL));
                @SuppressLint("Range") String courseName = cursor.getString(cursor.getColumnIndex(NAME_COL));

                FolderModal courseModal = new FolderModal(id, courseName);
                folderModalArrayList.add(courseModal);
            } while (cursor.moveToNext());
            cursor.close();
        }

        // returning the folder modal array list.
        return folderModalArrayList;
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
