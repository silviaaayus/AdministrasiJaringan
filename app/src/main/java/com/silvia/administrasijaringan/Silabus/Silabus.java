package com.silvia.administrasijaringan.Silabus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.silvia.administrasijaringan.R;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

public class Silabus extends AppCompatActivity implements DownloadFile.Listener {
    Context context;

    PDFPagerAdapter adapter;
    RemotePDFViewPager remotePDFViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silabus);

        remotePDFViewPager = new RemotePDFViewPager(this, "https://mediapembelajaran.mantagi.com/asset/silabus/C3.3%20SILABUS%20ADMINISTRASI%20SISTEM%20JARINGAN%20XI.pdf", this);

    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter);

        LinearLayout silabus = (LinearLayout) findViewById(R.id.silabus);
        silabus.addView(remotePDFViewPager, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(context, "PDF tidak bisa ditampilkan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

}