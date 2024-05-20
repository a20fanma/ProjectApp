package com.example.projectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LakeAdapter extends RecyclerView.Adapter<LakeAdapter.LakeHolder> {
    private Context context;
    private ArrayList<Lake> lakes;

    public LakeAdapter(Context context, ArrayList<Lake> lakes){
        this.context = context;
        this.lakes = lakes;
    }

    @NonNull
    @Override
    public LakeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lake_layout_item,parent,false);
        return new LakeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LakeAdapter.LakeHolder holder, int position) {
        Lake lake = lakes.get(position);

    }

    @Override
    public int getItemCount() {
        return lakes.size();
    }

    class LakeHolder extends RecyclerView.ViewHolder{

        public LakeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
