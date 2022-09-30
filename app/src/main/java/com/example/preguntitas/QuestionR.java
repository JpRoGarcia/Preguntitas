package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.preguntitas.files.archivoPlanitoQuestion;
import com.example.preguntitas.object.Question;

import java.util.ArrayList;

public class QuestionR extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView LvQuestion;
    ArrayList<Question> Preguntas = new ArrayList<>();
    ArrayAdapter adapter;
    Button btnQMenu, btnQAgregar;

    archivoPlanitoQuestion objAP = new archivoPlanitoQuestion(this);

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
        Preguntas = objAP.GuardarArrayPregunta();
        adapter = new ArrayAdapter<Question>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, Preguntas);
        LvQuestion.setAdapter(adapter);
    }

    private void conectar() {
        btnQMenu=findViewById(R.id.btnQMenu);
        btnQAgregar=findViewById(R.id.btnQAgregar);
        LvQuestion=findViewById(R.id.LvQuestion);
        LvQuestion.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        Intent I = new Intent(getApplicationContext(), QuestionUD.class);
        I.putExtra("Arreglo", Preguntas);
        I.putExtra("Posicion", posicion);
        startActivity(I);
    }
}