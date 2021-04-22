package com.silvia.administrasijaringan.Jobsheet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.silvia.administrasijaringan.Materi.AdapterMateri;
import com.silvia.administrasijaringan.Materi.IsiMateri;
;
import com.silvia.administrasijaringan.R;

import java.util.ArrayList;

public class AdapterJobsheet extends RecyclerView.Adapter<AdapterJobsheet.ListViewHolder> {

    private Context context;
    private ArrayList<ModelJobsheet> listHero;

    public AdapterJobsheet(Context context, ArrayList<ModelJobsheet> list) {
        this.context = context;
        this.listHero = list;
    }

    private AdapterJobsheet.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(AdapterJobsheet.OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(ModelJobsheet data);
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    /** Tempaat untuk masukkan sub layout / anak layout item */
    @NonNull
    @Override
    public AdapterJobsheet.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_jobsheet, viewGroup, false);
        return new ListViewHolder(view);
    }



    /** Tempat untuk memasukkan nilai dari model ke layout anak */
    @Override
    public void onBindViewHolder(@NonNull final AdapterJobsheet.ListViewHolder holder, int position) {
        ModelJobsheet dataModel = listHero.get(position);

        String id = dataModel.getId_rpp();
        String judul = dataModel.getJudul_rpp();
        String file = dataModel.getFile();





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
                Intent i = new Intent(context, Isi.class);
                i.putExtra("file",file);
                context.startActivity(i);
//                onItemClickCallBack.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });

    }

    /** Tempat untuk deklasi item di layout anak */
    public static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView txtjudul;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            txtjudul = itemView.findViewById(R.id.nama_jobsheet);




        }
    }
}
