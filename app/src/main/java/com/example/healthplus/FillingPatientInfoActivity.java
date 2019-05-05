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

public class FillingPatientInfoActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    EditText labeledET;

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






//    public void Next(View view) {
//        Intent intent = new Intent(this, Main2Activity.class);
//
//        startActivity(intent);
//    }
}
