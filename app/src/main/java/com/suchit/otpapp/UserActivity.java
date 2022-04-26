package com.suchit.otpapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    DatabaseReference databaseReference;
    UserAdpter userAdpter;
    ArrayList<UserModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView1 = findViewById(R.id.recyclerview1);
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Log.d("msg","#########");
                    UserModel userModel = dataSnapshot.getValue(UserModel.class);
                    list.add(userModel);
                }

                userAdpter = new UserAdpter(UserActivity.this,list);
                recyclerView1.setAdapter(userAdpter);

                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
