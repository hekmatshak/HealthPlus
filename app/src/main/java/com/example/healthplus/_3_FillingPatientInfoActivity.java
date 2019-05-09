package com.example.healthplus;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class _3_FillingPatientInfoActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    EditText labeledET;
    EditText FName, LName, Age, treatment, diagnosis;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filling_patient_info);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);


                    labeledET.setText(result.get(0));

                }
                break;
            }
        }
    }

    public void record(View view) {
        int myid = view.getId();
        switch (myid) {
            case R.id.voiceBtn1: {
                labeledET = findViewById(R.id.fname);
                speak();
                break;
            }
            case R.id.voiceBtn2: {
                labeledET = findViewById(R.id.lname);
                speak();
                break;
            }
            case R.id.voiceBtn3: {
                labeledET = findViewById(R.id.age);
                speak();
                break;
            }
            case R.id.voiceBtn4: {
                labeledET = findViewById(R.id.diagnosis);
                speak();
                break;
            }
            case R.id.voiceBtn5: {
                labeledET = findViewById(R.id.treatment);
                speak();
                break;
            }

            default:
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();

        }
    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "hi say Something");


        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void Next(View view) {
        FName = findViewById(R.id.fname);
        LName = findViewById(R.id.lname);
        Age = findViewById(R.id.age);
        treatment = findViewById(R.id.treatment);
        diagnosis = findViewById(R.id.diagnosis);

        if (FName.getText().toString().isEmpty() || LName.getText().toString().isEmpty() || Age.getText().toString().isEmpty()
                || treatment.getText().toString().isEmpty() || diagnosis.getText().toString().isEmpty()) {
            Toast.makeText(this, "All fields are Required", Toast.LENGTH_LONG).show();
        }
        else
        {
            db = new DataBaseHelper(_3_FillingPatientInfoActivity.this, null, null);

            db.Insert(FName.getText().toString(), LName.getText().toString(), Age.getText().toString(), treatment.getText().toString(), diagnosis.getText().toString());
            db.close();

            Intent intent = new Intent(this, _4_ViewPatientInfo.class);

            startActivity(intent);
        }

    }
}
