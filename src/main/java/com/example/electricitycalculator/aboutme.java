package com.example.electricitycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import java.util.Calendar;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class aboutme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("This electricity calculator is developed to calculate electricity" +
                        " bills for ICT602 Individual Assignment purpose.\n\nDEVELOPER DETAILS " +
                        "\n\nName: SITI SARAH BINTI MOHD ESHA'\n Student ID: 2021940563 \nGroup: RCS2405B" +
                        "\nProgramme code: CS240")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("CONNECT WITH ME!")
                .addEmail("ssarahesha26@gmail.com")
                .addWebsite("https://github.com/ssarahme/electricitycalc/")
                .addYoutube("UCkT_2VBxER6DiTcLyl4zPPw")
                .addPlayStore("com.example.electricitycalculator")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }
    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d by Sarah", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(aboutme.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}