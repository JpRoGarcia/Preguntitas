package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.preguntitas.database.CRUDScore;
import com.example.preguntitas.object.Score;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreR extends AppCompatActivity  {
    ListView LvRanking;
    ArrayList<Score> Puntos = new ArrayList<>();
    ArrayAdapter adapter;
    Button btnPMenu;
    DatabaseReference miDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_r);
        conectar();
        adaptar();

        btnPMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnPMenu=findViewById(R.id.btnPMenu);
        LvRanking=findViewById(R.id.LvRanking);
    }

    public void adaptar(){
        miDB = FirebaseDatabase.getInstance().getReference();
        miDB.child("Score").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objsnapshot : snapshot.getChildren()) {
                    Puntos.add(new Score(objsnapshot.child("id").getValue().toString(),
                            objsnapshot.child("name").getValue().toString(),
                            Integer.parseInt(objsnapshot.child("vida").getValue().toString()),
                            Integer.parseInt(objsnapshot.child("point").getValue().toString())));
                }

                Collections.sort(Puntos, new Comparator<Score>() {
                    @Override
                    public int compare(Score S1, Score S2) {
                        return new Integer(S2.getPoint()).compareTo(new Integer(S1.getPoint()));
                    }
                });
                adapter = new ArrayAdapter<Score>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, Puntos);
                LvRanking.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}