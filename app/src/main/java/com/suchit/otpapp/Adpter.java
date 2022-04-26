package com.suchit.otpapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adpter extends RecyclerView.Adapter<Adpter.myholder> {
    public Adpter(String[] myMember) {
        this.myMember = myMember;
    }

    String myMember[];




    class myholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text;

        public myholder(View itemView){
            super(itemView);
            image =(ImageView)itemView.findViewById(R.id.image);
            text =(TextView)itemView.findViewById(R.id.text);
        }
    }

    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layoutdata,parent,false);
        return new myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myholder holder, int position) {
        holder.text.setText(myMember[position]);

    }

    @Override
    public int getItemCount() {
        return myMember.length;
    }
}
