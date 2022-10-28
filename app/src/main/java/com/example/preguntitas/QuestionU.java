package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.preguntitas.database.CRUDQuestion;
import com.example.preguntitas.object.Question;

import java.util.ArrayList;

public class QuestionU extends AppCompatActivity {

    ArrayList<Question> Preguntas = new ArrayList();
    Button btnEVolver, btnEGuardar;
    EditText etEPregunta, etECorrecta, etEOpcionUno, etEOpcionDos, etEPuntos;
    CRUDQuestion objDB = new CRUDQuestion(this);
    String id, P, Correcta, OpUno, OpDos;
    int Puntos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_u);
        conectar();
        Preguntas = Llamar();

        etEPregunta.setText(Preguntas.get(0).getPregunta());
        etECorrecta.setText(Preguntas.get(0).getCorrecta());
        etEOpcionUno.setText(Preguntas.get(0).getOpcionUno());
        etEOpcionDos.setText(Preguntas.get(0).getOpcionDos());
        etEPuntos.setText((Preguntas.get(0).getPuntuacion())+"");

        btnEGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = Preguntas.get(0).getId();
                P = etEPregunta.getText().toString();
                Correcta = etECorrecta.getText().toString();
                OpUno = etEOpcionUno.getText().toString();
                OpDos = etEOpcionDos.getText().toString();
                Puntos = Integer.parseInt(etEPuntos.getText().toString());

                objDB.UpdateQuestion(id, P, Correcta, OpUno, OpDos, Puntos);

                Toast.makeText(QuestionU.this, "Pregunta Modificada", Toast.LENGTH_SHORT).show();
                Intent I = new Intent(getApplicationContext(), QuestionR.class);
                startActivity(I);
            }
        });

        btnEVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), QuestionR.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnEVolver = findViewById(R.id.btnEVolver);
        btnEGuardar = findViewById(R.id.btnEGuardar);

        etEPregunta = findViewById(R.id.etEPregunta);
        etECorrecta = findViewById(R.id.etECorrecta);
        etEOpcionUno = findViewById(R.id.etEOpcionUno);
        etEOpcionDos = findViewById(R.id.etEOpcionDos);
        etEPuntos = findViewById(R.id.etEPuntos);
    }

    public ArrayList<Question> Llamar() {
        ArrayList<Question> aux = new ArrayList<>();
        Bundle pInfo = getIntent().getExtras();
        id = pInfo.getString("id");
        P = pInfo.getString("Q");
        Correcta = pInfo.getString("C");
        OpUno = pInfo.getString("Opc1");
        OpDos = pInfo.getString("Opc2");
        Puntos = pInfo.getInt("P");
        aux.add(new Question(id, P, Correcta, OpUno, OpDos, Puntos));
        return aux;
    }




}