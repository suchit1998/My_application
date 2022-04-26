package com.suchit.otpapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdpter extends RecyclerView.Adapter<UserAdpter.myviewHolder> {
    Context context;
    ArrayList<UserModel> list;

    public UserAdpter(Context context, ArrayList<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_avtivity,parent,false);
        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        UserModel userModel = list.get(position);
        holder.name.setText(userModel.getName());
        holder.mobile_no.setText(userModel.getMobile_no()+"");
        holder.email.setText(userModel.getEmail());
        holder.password.setText(userModel.getPassword());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myviewHolder extends RecyclerView.ViewHolder{
        TextView name,mobile_no,email,password;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            mobile_no = itemView.findViewById(R.id.mobileno1);
            email = itemView.findViewById(R.id.email1);
            password = itemView.findViewById(R.id.password1);
        }
    }


}
