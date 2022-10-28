package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.preguntitas.ListAdapter.ListAdapterQuestion;
import com.example.preguntitas.database.CRUDQuestion;
import com.example.preguntitas.object.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuestionR extends AppCompatActivity {

    RecyclerView LvQuestion;
    ArrayList<Question> Preguntas = new ArrayList<>();
    ListAdapterQuestion adapter;
    Button btnQMenu, btnQAgregar;
    DatabaseReference miDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_r);
        conectar();
        miDB = FirebaseDatabase.getInstance().getReference();
        adaptar();


        btnQMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });

        btnQAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), QuestionC.class);
                startActivity(I);
            }
        });

    }

    private void adaptar() {
        miDB.child("Question").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Preguntas.clear();
                for (DataSnapshot objsnapshot : snapshot.getChildren()) {
                    Preguntas.add(new Question(objsnapshot.child("id").getValue().toString(),
                            objsnapshot.child("pregunta").getValue().toString(),
                            objsnapshot.child("correcta").getValue().toString(),
                            objsnapshot.child("opcionUno").getValue().toString(),
                            objsnapshot.child("opcionDos").getValue().toString(),
                            Integer.parseInt(objsnapshot.child("puntuacion").getValue().toString())));
                }
                adapter = new ListAdapterQuestion(Preguntas, getApplicationContext());
                LvQuestion.setHasFixedSize(true);
                LvQuestion.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                LvQuestion.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void conectar() {
        btnQMenu=findViewById(R.id.btnQMenu);
        btnQAgregar=findViewById(R.id.btnQAgregar);
        LvQuestion=findViewById(R.id.LvQuestion);

    }



}