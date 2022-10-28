package com.example.preguntitas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.lights.LightsManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.preguntitas.object.Question;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CRUDQuestion {
    public Context ctx;
    DatabaseReference miDB;


    public CRUDQuestion(Context ctx) {this.ctx =ctx;}

    public void CreateQuestion(String Pregunta,  String Correcta, String OpcionUno, String OpcionDos, int Puntos){
        miDB = FirebaseDatabase.getInstance().getReference();
        String Id = miDB.push().getKey();
        Question Q = new Question(Id, Pregunta, Correcta, OpcionUno, OpcionDos, Puntos);
        miDB.child("Question").child(Id).setValue(Q);
    }

    public void UpdateQuestion(String Id, String Pregunta,  String Correcta, String OpcionUno, String OpcionDos, int Puntos){
        miDB = FirebaseDatabase.getInstance().getReference();
        Question Q = new Question(Id, Pregunta, Correcta, OpcionUno, OpcionDos, Puntos);
        miDB.child("Question").child(Id).setValue(Q);
    }

    public void DeleteQuestion(String Id){
        miDB = FirebaseDatabase.getInstance().getReference();
        miDB.child("Question").child(Id).removeValue();
    }
/**
    public void ReadQuestions(ArrayList<Question> Preguntas){
        miDB = FirebaseDatabase.getInstance().getReference();
        miDB.child("Question").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objsnapshot : snapshot.getChildren()) {
                    Preguntas.add(new Question(objsnapshot.child("id").getValue().toString(),
                            objsnapshot.child("pregunta").getValue().toString(),
                            objsnapshot.child("correcta").getValue().toString(),
                            objsnapshot.child("opcionUno").getValue().toString(),
                            objsnapshot.child("opcionDos").getValue().toString(),
                            Integer.parseInt(objsnapshot.child("puntuacion").getValue().toString())));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
 */
}
