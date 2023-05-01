package com.example.giftoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button loginbtn;
    EditText password2, username2;
    SharedPreferences sp;

    userDB DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username2=(EditText) findViewById(R.id.username2);
        password2=(EditText) findViewById(R.id.password2);
        loginbtn=(Button) findViewById(R.id.loginbtn);
        DB=new userDB(this);
        sp=getSharedPreferences("details", Context.MODE_PRIVATE);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username2.getText().toString();
                String pass= password2.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this, "Please enter all the fields :)", Toast.LENGTH_SHORT).show();


                }
                else{
                    Boolean checkUsersPassword = DB.checkUsersPassword(user,pass);
                    if(checkUsersPassword==true){
                        Toast.makeText(Login.this, "Login successfull, welcome back!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),HomePage.class);
                        startActivity(intent);
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putString("fname",username2.getText().toString());
                        editor.commit();
                    }else{
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}