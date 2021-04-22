package com.silvia.administrasijaringan.About;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.silvia.administrasijaringan.PrefManager;
import com.silvia.administrasijaringan.R;

public class About extends AppCompatActivity {
    Button btnlogout;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        btnlogout = findViewById(R.id.btnlogout);
        prefManager = new PrefManager(this);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefManager.logoutUser();
            }
        });

    }

}