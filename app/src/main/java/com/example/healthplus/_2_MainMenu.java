package com.example.healthplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class _2_MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);



    }

    public void goToFillingInfoPage(View view) {

        Intent intent = new Intent(_2_MainMenu.this, _3_FillingPatientInfoActivity.class);
        startActivity(intent);
    }
}
