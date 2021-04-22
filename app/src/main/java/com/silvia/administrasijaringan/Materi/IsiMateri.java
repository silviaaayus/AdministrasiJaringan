package com.silvia.administrasijaringan.Materi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.silvia.administrasijaringan.API;
import com.silvia.administrasijaringan.R;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class IsiMateri extends AppCompatActivity implements DownloadFile.Listener  {
    Context context;
    String file, url;
    private API api;
    PDFPagerAdapter adapter;
    RemotePDFViewPager remotePDFViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_materi);
//        http://192.168.43.160/androidsj/pdf/249244-none-837c3dfb.pdf
        api = new API();
        Intent i = getIntent();
        file = i.getStringExtra("file");
        file = api.URL_IsiMateri + file;

        Log.e("salah",file);


        remotePDFViewPager = new RemotePDFViewPager(this, file, this);


    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter);

        LinearLayout pdfmateri = (LinearLayout) findViewById(R.id.pdfmateri);
        pdfmateri.addView(remotePDFViewPager, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(context, "PDF tidak bisa ditampilkan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

}
