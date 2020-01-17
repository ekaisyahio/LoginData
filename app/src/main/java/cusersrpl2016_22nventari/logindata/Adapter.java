package com.example.logindata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import cusersrpl2016_22nventari.logindata.R;
import cusersrpl2016_22nventari.logindata.Siswa;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<Siswa> rvData;

    public Adapter(ArrayList<Siswa> rvData) {
        this.rvData = rvData;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.menetapkanSiswa(rvData.get(position));
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvnama;
        public TextView tvkelas;
        public TextView tvalamat;

        public ViewHolder(View itemView) {
            super(itemView);
            tvnama = (TextView) itemView.findViewById(R.id.nama);
            tvkelas = (TextView) itemView.findViewById(R.id.kelas);
            tvalamat = (TextView) itemView.findViewById(R.id.alamat);
        }

        public void menetapkanSiswa(Siswa siswa) {
            tvnama.setText(siswa.getNama());
            tvkelas.setText(siswa.getKelas());
            tvalamat.setText(siswa.getAlamat());
        }

    }
}