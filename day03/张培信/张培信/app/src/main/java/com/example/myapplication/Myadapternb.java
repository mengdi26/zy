package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Myadapternb extends RecyclerView.Adapter<Myadapternb.ViewHolder> {
    ArrayList<TextJava.DataBeanX.DataBean> list;
    Context context;

    public Myadapternb(ArrayList<TextJava.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(context).inflate(R.layout.kkk,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tv1.setText(list.get(position).getAuthor().getName());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(requestOptions).into(holder.im);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView tv1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
}
