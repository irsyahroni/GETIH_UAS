package com.arbaini.getih.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arbaini.getih.Model.Users;
import com.arbaini.getih.R;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<Users> recordsList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView rv_nama, rv_alamat,rv_nohp,rv_darah;

        ViewHolder(View view){
            super(view);
            rv_nama = (TextView) view.findViewById(R.id.tv_rvitem_nama1);
            rv_darah = (TextView) view.findViewById(R.id.tv_rvitem_darah);
            rv_nohp = (TextView) view.findViewById(R.id.tv_rvitem_phone1);
            rv_alamat = (TextView) view.findViewById(R.id.tv_rvitem_lokasi1);
        }
    }

    public RVAdapter(List<Users> recordsList){
        this.recordsList = recordsList;
    }

    @Override
    public ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Users users = recordsList.get(position);
        holder.rv_nama.setText(users.getAlamat());
        holder.rv_alamat.setText(users.getNama());
        holder.rv_darah.setText(users.getGolDar());
        holder.rv_nohp.setText(users.getNoHp());
        //holder.rv_detail.setText(users.getNoHp());
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

}
