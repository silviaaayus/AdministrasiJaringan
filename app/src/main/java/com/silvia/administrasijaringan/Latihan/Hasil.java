package com.silvia.administrasijaringan.Latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.silvia.administrasijaringan.API;
import com.silvia.administrasijaringan.MainActivity;
import com.silvia.administrasijaringan.PrefManager;
import com.silvia.administrasijaringan.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Hasil extends AppCompatActivity {

    TextView mtvHasilAkhir;
    Button mbtnMenu, btnReplay;
    String id, id_materi, skorPilGan;
    private API api;
    PrefManager prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        prefManager = new PrefManager(this);

        api = new API();

        Intent i = getIntent();
        id = i.getStringExtra("id_materi");


        btnReplay = findViewById(R.id.btnReplay);
        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Hasil.this, Latihan.class);
                j.putExtra("id_materi",id);

                /* Toast.makeText(HasilSkoring.this, "id"+id, Toast.LENGTH_SHORT).show();*/

                startActivity(j);
            }
        });

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        mbtnMenu = (Button) findViewById(R.id.btnMenu);

        setSkor();

        mbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Hasil.this, Latihan.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });


    }

    //method untuk mengatur skor yang akan ditampilkan pada textview
    public void setSkor(){
        //hasil lemparan (putExtra) dari activity sebelumnya ditampung dalam variabel lokal
        String activity = getIntent().getStringExtra("activity");
        skorPilGan = getIntent().getStringExtra("skorAkhir");


        if(activity.equals("PilihanGanda")){ //jika var activity bernilai PilihanGanda
            //dipastikan activity sebelumnya datang dari kelas KuisPilihanGanda
            //maka skornya diatur dari skorPilGan

            mtvHasilAkhir.setText("Skor : "+skorPilGan );
            inputNilai();
        }
    }

    private void inputNilai() {
        Log.d("id_siswa", "id :"+prefManager.getIdUser());
        AndroidNetworking.post(api.URL_NILAI)
                .addBodyParameter("id_siswa", prefManager.getIdUser())
                .addBodyParameter("skor", skorPilGan)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int stat = response.getInt("status");
                            String message = response.getString("message");
                            Log.d("sukses", "code"+response);
                            if (stat == 1){

                                Toast.makeText(Hasil.this, "Nilai Tersimpan", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                Toast.makeText(Hasil.this, message, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("eror", "code :"+anError);
                        Toast.makeText(Hasil.this, ""+anError, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void onBackPressed(){
        Toast.makeText(this, "Tekan Tombol Home ", Toast.LENGTH_SHORT).show();
        //jadi yang awalnya klik tombol back maka akan kembali ke activity sebelumnya
        //kali ini ketika tombol back diklik maka
        //hanya muncul Toast
    }


}