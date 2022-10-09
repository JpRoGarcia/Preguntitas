package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.preguntitas.files.archivoPlanitoQuestion;
import com.example.preguntitas.object.Question;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionUD extends AppCompatActivity {

    ArrayList<Question> Preguntas = new ArrayList();
    int Posicion;
    Button btnEVolver, btnEDelete, btnEGuardar;
    EditText etEPregunta, etECorrecta, etEOpcionUno, etEOpcionDos, etEPuntos;
    archivoPlanitoQuestion objAP = new archivoPlanitoQuestion(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_ud);
        conectar();
        Llamar();

        etEPregunta.setText(Preguntas.get(Posicion).getPregunta());
        etECorrecta.setText(Preguntas.get(Posicion).getCorrecta());
        etEOpcionUno.setText(Preguntas.get(Posicion).getOpcionDos());
        etEOpcionDos.setText(Preguntas.get(Posicion).getOpcionTres());
        etEPuntos.setText((Preguntas.get(Posicion).getPuntucion())+"");

        btnEGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    ArrayList<Question> aux = new ArrayList();
                    String P = etEPregunta.getText().toString();
                    String Correcta = etECorrecta.getText().toString();
                    String OpUno = etEOpcionUno.getText().toString();
                    String OpDos = etEOpcionDos.getText().toString();
                    int Puntos = Integer.parseInt(etEPuntos.getText().toString());
                    aux.add(new Question(P, Correcta, OpUno, OpDos, Correcta, Puntos));
                    Preguntas.set(Posicion, aux.get(0));
                    objAP.Borrar();
                    Escribir();
                    Toast.makeText(QuestionUD.this, "Pregunta Modificada", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(getApplicationContext(), QuestionR.class);
                    startActivity(I);
                } catch (IOException ex){
                    ex.getMessage();
                }

            }
        });

        btnEDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    objAP.Borrar();
                    Preguntas.remove(Posicion);
                    Escribir();
                    Toast.makeText(QuestionUD.this, "Pregunta Eliminada", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(getApplicationContext(), QuestionR.class);
                    startActivity(I);
                } catch (IOException ex){
                    ex.getMessage();
                }

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
        btnEDelete = findViewById(R.id.btnEDelete);
        btnEGuardar = findViewById(R.id.btnEGuardar);

        etEPregunta = findViewById(R.id.etEPregunta);
        etECorrecta = findViewById(R.id.etECorrecta);
        etEOpcionUno = findViewById(R.id.etEOpcionUno);
        etEOpcionDos = findViewById(R.id.etEOpcionDos);
        etEPuntos = findViewById(R.id.etEPuntos);
    }

    public void Llamar() {
        Bundle pInfo = getIntent().getExtras();
        Posicion = pInfo.getInt("Posicion");
        Preguntas = (ArrayList<Question>) getIntent().getSerializableExtra("Arreglo");
    }

    public void Escribir(){
        try{
            for (int i = 0; i < Preguntas.size(); i++){
                objAP.EscribirPregunta(Preguntas.get(i).getPregunta() + '/');
                objAP.EscribirPregunta(Preguntas.get(i).getCorrecta() + '/');
                objAP.EscribirPregunta(Preguntas.get(i).getOpcionDos() + '/');
                objAP.EscribirPregunta(Preguntas.get(i).getOpcionTres() + '/');
                objAP.EscribirPregunta(Preguntas.get(i).getPuntucion() + ".");
            }
        }
        catch (IOException ex){
            ex.getMessage();
        }
    }
}