package com.example.healthplus;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        //Initializing Active Android
        ActiveAndroid.initialize(this);
    }
}
