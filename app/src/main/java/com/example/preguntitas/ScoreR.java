package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.preguntitas.database.CRUDScore;
import com.example.preguntitas.object.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScoreR extends AppCompatActivity  {
    ListView LvRanking;
    ArrayList<Score> Puntos = new ArrayList<>();
    ArrayAdapter adapter;
    Button btnPMenu;
    CRUDScore objDB = new CRUDScore(this);

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
        Puntos = objDB.ReadScore();
        Collections.sort(Puntos, new Comparator<Score>() {
            @Override
            public int compare(Score S1, Score S2) {
                return new Integer(S2.getPoint()).compareTo(new Integer(S1.getPoint()));
            }
        });
        adapter = new ArrayAdapter<Score>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, Puntos);
        LvRanking.setAdapter(adapter);
    }
}