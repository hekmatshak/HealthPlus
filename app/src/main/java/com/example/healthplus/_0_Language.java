package com.example.healthplus;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class _0_Language extends AppCompatActivity {
    public  String lan="null";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__0__language);

        loadLocale();
        intent = new Intent(_0_Language.this, _2_MainMenu.class);

    }

    public void click(View v)
    {
        selectyourlanguage();
    }
    public void selectyourlanguage()
    {
        final String [] listitem={"Arabic","English"};
        AlertDialog.Builder alert=new AlertDialog.Builder(_0_Language.this);
        alert.setTitle("Chose Language ...");
        alert.setSingleChoiceItems(listitem, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0)
                {
                    setLocale("ar");
                    recreate();
                }
                else if (i==1)
                {
                    setLocale("en");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog=alert.create();
        alert.show();
        startActivity(intent);
    }
    private void setLocale(String lang)
    {
        Locale locale =new Locale(lang);
        Locale.setDefault(locale);
        Configuration conf=new Configuration();
        conf.locale=locale;
        getBaseContext().getResources().updateConfiguration(conf,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor pref=getSharedPreferences("settings",MODE_PRIVATE).edit();
        pref.putString("my_lang",lang);
        pref.apply();

    }
    public void loadLocale()
    {
        SharedPreferences pref=  getSharedPreferences("settings",MODE_PRIVATE);
        String lang= pref.getString("my_lang","en");
        if(lang.equals("ar"))
        {
            lan="ar";
        }
        else
        {lan="en";}
        setLocale(lang);

    }
}
