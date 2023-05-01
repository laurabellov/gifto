package com.example.giftoo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class userDB extends SQLiteOpenHelper {
    private static final String DATABASENAME = "User.DB";
    private static final String TABLE_NAME = "Users";



    public userDB(Context context)
    {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create table users(username TEXT primary key,  password TEXT, image IMAGE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop table if exists users");
        onCreate(myDB);
    }

    public Boolean insertData (String username,String password) {
        SQLiteDatabase myDB =  getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Username", username);
        contentvalues.put("Password", password);
//        contentvalues.put("picture", image);
        long result = myDB.insert("Users", null, contentvalues);
        if (result == -1) return false;
        else return true;
    }

    public Boolean checkIfUsername (String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        // myDB.execSQL("ALTER TABLE Users ADD COLUMN phone TEXT");
        Cursor cursor = myDB.rawQuery("Select * from Users where username = ?" , new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

  public Boolean checkUsersPassword (String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from Users where Username = ? and password = ?", new String[] {username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

   // @SuppressLint("Range")
   // public User getUser(String username, String password){
        //User user  = null;
       // Cursor cursor = readUserData(username,password);
       // cursor.moveToFirst();
       // if (cursor.getCount() != 0)
       // {
         //   user =   new User(
         //           cursor.getString(cursor.getColumnIndex("username")),
         //           cursor.getString(cursor.getColumnIndex("password")),
         //           cursor.getString(cursor.getColumnIndex("phone")));
      //  }
      //  return user;
   // }

   // private Cursor readUserData(String username, String password){
    //    String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ?  and password = ?";
     //   SQLiteDatabase db = this.getReadableDatabase();
     //   Cursor cursor = null;
     //   if (db != null)
     //   {
      //      cursor = db.rawQuery(query, new String[] {username,password});
      //  }
     //   return cursor;
   // }
}
