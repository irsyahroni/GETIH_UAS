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
        public TextView rv_nama, rv_detail;

        ViewHolder(View view){
            super(view);
            rv_nama = (TextView) view.findViewById(R.id.tv_rv_name);
            rv_detail = (TextView) view.findViewById(R.id.tv_rv_detail);
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
        holder.rv_nama.setText(users.getEmail());
        //holder.rv_detail.setText(users.getNoHp());
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

}
