package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.preguntitas.files.archivoPlanitoQuestion;

import java.io.IOException;

public class QuestionC extends AppCompatActivity {

    Button btnGuardar, btnPcVolver;
    EditText etPregunta, etOpcionUno, etOpcionDos, etCorrecta, etPuntos;
    String Pregunta, OpOK, OpUno, OpDos, OpPoint;
    archivoPlanitoQuestion objAP = new archivoPlanitoQuestion(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_c);
        conectar();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pregunta = etPregunta.getText().toString();
                OpOK = etCorrecta.getText().toString();
                OpUno = etOpcionUno.getText().toString();
                OpDos = etOpcionDos.getText().toString();
                OpPoint = etPuntos.getText().toString();
                try{
                    etPregunta.setText("");
                    etOpcionUno.setText("");
                    etOpcionDos.setText("");
                    etCorrecta.setText("");
                    etPuntos.setText("");

                    objAP.EscribirPregunta(Pregunta + '/');
                    objAP.EscribirPregunta(OpOK + '/');
                    objAP.EscribirPregunta(OpUno + '/');
                    objAP.EscribirPregunta(OpDos + '/');
                    objAP.EscribirPregunta(OpPoint + '.');

                    Toast.makeText(QuestionC.this, "Pregunta Creada", Toast.LENGTH_SHORT).show();
                }
                catch (IOException ex){
                    ex.getMessage();
                }
            }
        });

        btnPcVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), QuestionR.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnGuardar = findViewById(R.id.btnGuardar);
        btnPcVolver = findViewById(R.id.btnPcVolver);
        etPregunta = findViewById(R.id.etPregunta);
        etOpcionUno = findViewById(R.id.etOpcionUno);
        etOpcionDos = findViewById(R.id.etOpcionDos);
        etCorrecta = findViewById(R.id.etCorrecta);
        etPuntos = findViewById(R.id.etPuntos);
    }
}