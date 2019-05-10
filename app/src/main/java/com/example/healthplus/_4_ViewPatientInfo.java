package com.example.healthplus;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class _4_ViewPatientInfo extends AppCompatActivity {
    DataBaseHelper db;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__4__view_patient_info);

        db = new DataBaseHelper(_4_ViewPatientInfo.this,null,null);

        Cursor cursor = db.retrieve();
        cursor.moveToLast();
        TextView t1 = (TextView)findViewById(R.id.text1);
        t1.setText(cursor.getString(0));
        TextView t2 = (TextView)findViewById(R.id.text2);
        t2.setText(cursor.getString(1));
        TextView t3 = (TextView)findViewById(R.id.text3);
        t3.setText(cursor.getString(2));
        TextView t4 = (TextView)findViewById(R.id.text4);
        t4.setText(cursor.getString(3));
        TextView t5 = (TextView)findViewById(R.id.text5);
        t5.setText(cursor.getString(4));

    }

    public void click(View v)
    {
        intent = new Intent(this,_3a_FillingPatientInfoActivity.class);
        startActivity(intent);
    }
}

