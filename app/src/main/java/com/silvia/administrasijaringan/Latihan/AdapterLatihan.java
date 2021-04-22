package com.silvia.administrasijaringan.Latihan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.silvia.administrasijaringan.R;

import java.util.ArrayList;

public class AdapterLatihan extends RecyclerView.Adapter<AdapterLatihan.ListViewHolder> {

    private Context context;
    private ArrayList<ModelLatihan> listLatihan;

    public AdapterLatihan(Context context, ArrayList<ModelLatihan> listMateri) {
        this.context = context;
        this.listLatihan = listMateri;
    }


    private AdapterLatihan.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(AdapterLatihan.OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelLatihan data);
    }

    @Override
    public int getItemCount() {
        return listLatihan.size();
    }

    /** Tempaat untuk masukkan sub layout / anak layout item */
    @NonNull
    @Override
    public AdapterLatihan.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_latihan, viewGroup, false);
        return new ListViewHolder(view);
    }

    /** Tempat untuk memasukkan nilai dari model ke layout anak */
    @Override
    public void onBindViewHolder(@NonNull final AdapterLatihan.ListViewHolder holder, int position) {
        ModelLatihan dataModel = listLatihan.get(position);

        String id = dataModel.getId_materi();
        String judul = dataModel.getJudul_materi();

        holder.txtjudul.setText(judul);

        /** holder.btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Toast.makeText(context, "idnya : "+id, Toast.LENGTH_SHORT).show();
        }
        }); */

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*  Toast.makeText(context, "idnya : "+id, Toast.LENGTH_SHORT).show();*/
                Intent i = new Intent(context, Soal.class);
                i.putExtra("id_materi",id);
                context.startActivity(i);
//                onItemClickCallBack.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });

    }

    /** Tempat untuk deklasi item di layout anak */
    public static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView txtjudul,  txt_catatan, txt_tanggal;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            txtjudul = itemView.findViewById(R.id.nama_latihan);




        }
    }
}
