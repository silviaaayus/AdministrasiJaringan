package com.silvia.administrasijaringan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.silvia.administrasijaringan.About.About;
import com.silvia.administrasijaringan.Jobsheet.Jobsheet;
import com.silvia.administrasijaringan.Latihan.Latihan;
import com.silvia.administrasijaringan.Materi.Materi;
import com.silvia.administrasijaringan.Silabus.Silabus;
import com.silvia.administrasijaringan.Video.Video;

public class MainActivity extends AppCompatActivity {
Button btnsilabus, btnmateri, btnjobsheet, btnvideo, btnlatihan, btnabout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsilabus = findViewById(R.id.btnsilabus);
        btnsilabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Silabus.class);
                startActivity(i);
            }
        });

        btnmateri = findViewById(R.id.btnmateri);
        btnmateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Materi.class);
                startActivity(i);

            }
        });

        btnjobsheet = findViewById(R.id.btnjobsheet);
        btnjobsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jobsheet.class);
                startActivity(i);
            }
        });

        btnvideo = findViewById(R.id.btnvideo);
        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Video.class);
                startActivity(i);
            }
        });
        btnlatihan= findViewById(R.id.btnlatihan);
        btnlatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Latihan.class);
                startActivity(i);
            }
        });
        btnabout = findViewById(R.id.btnabout);
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, About.class);
                startActivity(i);
            }
        });
    }
}