package com.example.healthplus;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Locale;

public class _1_SplashScreen extends AppCompatActivity {
    public  String lan="null";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//this peace of code is to remove the task bar from the screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity__1__splash_screen);

//this peace of code is creating an object from the user defined LogoLauncher class starting it.
        LogoLauncher logoLauncher = new LogoLauncher();
        startService(new Intent(this, _1_SoundService.class));
        logoLauncher.start();


//this peace of code is to start the sound service that is in SoundService java class.

    }


    //this user defined method is to set a 4500 millis of sleeping and then move to the next activity using Intent,
// and finishing this one so when press on the back button it won't come back to this activity.
    private class LogoLauncher extends Thread {
        public void run() {
            try {
                sleep(4500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(_1_SplashScreen.this, _0_Language.class);
            stopService(new Intent(_1_SplashScreen.this, _1_SoundService.class));
            startActivity(intent);
            _1_SplashScreen.this.finish();
        }
    }
}