package com.example.giftoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button, button2 ,test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2) ;
        test=(Button)findViewById(R.id.test) ;

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity3();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity2();
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity4();
            }

        });
    }
    public void openactivity2(){
        Intent intent=new Intent(this  ,Login.class);
        startActivity(intent);
    }
    public void openactivity3(){
        Intent intent=new Intent(this  ,Register.class);
        startActivity(intent);
    }
    public void openactivity4(){
        Intent intent=new Intent(this  , HomePage.class);
        startActivity(intent);
    }


}
