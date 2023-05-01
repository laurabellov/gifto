package com.example.giftoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

//import com.bumptech.glide.Glide;

public class SettingsPage extends AppCompatActivity {

    AirplaneModeChangeReceiver airplaneModeChangeReceiver = new AirplaneModeChangeReceiver();
    private ImageButton home, search ,profile;
    ImageView gif;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingspage);
        home = (ImageButton) findViewById(R.id.home);
        search = (ImageButton)  findViewById(R.id.search);
        profile = (ImageButton)  findViewById(R.id.profile);
        gif=(ImageView) findViewById(R.id.gif);

        Glide.with(this).load(R.drawable.catgif).into(gif);

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
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity5();
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
    public void openactivity5() {
        Intent intent = new Intent(this, UserPage.class);
        startActivity(intent);
    }
    public void play(View v){
        if (player==null){
            player=MediaPlayer.create(this,R.raw.flowers);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause(View v){
        if (player !=null){
            player.pause();
        }
    }
    public void stop(View v){
        stopPlayer();
    }
    private void stopPlayer(){
        if (player!=null){
            player.release();
            player=null;
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        stopPlayer();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeChangeReceiver, filter);
    }

    public void logoutbtn(View view) {
        SharedPreferences preferences=getSharedPreferences("details1", Context.MODE_PRIVATE);
        SharedPreferences. Editor editor= preferences.edit();
        editor.clear();
        editor.commit();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneModeChangeReceiver);
    }
}