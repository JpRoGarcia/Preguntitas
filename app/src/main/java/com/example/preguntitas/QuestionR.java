package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.preguntitas.ListAdapter.ListAdapterQuestion;
import com.example.preguntitas.database.CRUDQuestion;
import com.example.preguntitas.object.Question;

import java.util.ArrayList;

public class QuestionR extends AppCompatActivity {

    RecyclerView LvQuestion;
    ArrayList<Question> Preguntas = new ArrayList<>();
    ListAdapterQuestion adapter;
    Button btnQMenu, btnQAgregar;
    CRUDQuestion objDB = new CRUDQuestion(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_r);
        conectar();
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
        Preguntas = objDB.ReadQuestions();
        adapter = new ListAdapterQuestion(Preguntas, this);
        LvQuestion.setHasFixedSize(true);
        LvQuestion.setLayoutManager(new LinearLayoutManager(this));
        LvQuestion.setAdapter(adapter);
    }

    private void conectar() {
        btnQMenu=findViewById(R.id.btnQMenu);
        btnQAgregar=findViewById(R.id.btnQAgregar);
        LvQuestion=findViewById(R.id.LvQuestion);

    }

}