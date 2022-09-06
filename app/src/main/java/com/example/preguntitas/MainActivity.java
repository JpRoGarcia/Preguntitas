package com.example.preguntitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Printer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    TextView tvScore, tvQuiz;
    Button btnOp1, btnOp2, btnOp3, btnNext;
    Button btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnDiez;
    Button btnOnce, btnDoce, btnTrece, btnCatorce, btnQuince, btnDieciseis, btnDiecisiete, btnODieciocho, btnDieciNueve, btnVeinte;
    int Score = 0;
    ArrayList<Question> NPreguntas = new ArrayList();
    public String Correcta;
    public int Puntucion;
    public Button btnAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        CrearPreguntas();

        btnOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(btnOp1);
                Activar(false);
            }
        });

        btnOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(btnOp2);
                Activar(false);
            }
        });

        btnOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comprobar(btnOp3);
                Activar(false);
            }
        });

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnUno);
            }
        });

        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDos);
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnTres);
            }
        });

        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnCuatro);
            }
        });

        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnCinco);
            }
        });

        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnSeis);
            }
        });

        btnSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnSiete);
            }
        });

        btnOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnOcho);
            }
        });

        btnNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnNueve);
            }
        });

        btnDiez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDiez);
            }
        });

        btnOnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnOnce);
            }
        });

        btnDoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDoce);
            }
        });

        btnTrece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnTrece);
            }
        });

        btnCatorce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnCatorce);
            }
        });

        btnQuince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnQuince);
            }
        });

        btnDieciseis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDieciseis);
            }
        });

        btnDiecisiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDiecisiete);
            }
        });

        btnODieciocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnODieciocho);
            }
        });

        btnDieciNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDieciNueve);
            }
        });

        btnVeinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnVeinte);
            }
        });

    }

    private void conectar() {
        tvScore = findViewById(R.id.tvScore);
        tvQuiz = findViewById(R.id.tvQuiz);
        btnOp1 = findViewById(R.id.btnOp1);
        btnOp2 = findViewById(R.id.btnOp2);
        btnOp3 = findViewById(R.id.btnOp3);

        btnUno = findViewById(R.id.btnUno);
        btnDos = findViewById(R.id.btnDos);
        btnTres = findViewById(R.id.btnTres);
        btnCuatro = findViewById(R.id.btnCuatro);
        btnCinco = findViewById(R.id.btnCinco);
        btnSeis = findViewById(R.id.btnSeis);
        btnSiete = findViewById(R.id.btnSiete);
        btnOcho = findViewById(R.id.btnOcho);
        btnNueve = findViewById(R.id.btnNueve);
        btnDiez = findViewById(R.id.btnDiez);
        btnOnce = findViewById(R.id.btnOnce);
        btnDoce = findViewById(R.id.btnDoce);
        btnTrece = findViewById(R.id.btnTrece);
        btnCatorce = findViewById(R.id.btnCatorce);
        btnQuince = findViewById(R.id.btnQuince);
        btnDieciseis = findViewById(R.id.btnDieciseis);
        btnDiecisiete = findViewById(R.id.btnDiecisiete);
        btnODieciocho = findViewById(R.id.btnODieciocho);
        btnDieciNueve = findViewById(R.id.btnDieciNueve);
        btnVeinte = findViewById(R.id.btnVeinte);
    }

    public void MostrarPregunta(Button NQuiz){
        btnAux = NQuiz;
        int intRandom = random.nextInt(NPreguntas.size());
        tvQuiz.setText(NPreguntas.get(intRandom).getPregunta());
        btnOp1.setText(NPreguntas.get(intRandom).getOpcionUno());
        btnOp2.setText(NPreguntas.get(intRandom).getOpcionDos());
        btnOp3.setText(NPreguntas.get(intRandom).getOpcionTres());
        Correcta = NPreguntas.get(intRandom).getCorrecta();
        Puntucion = NPreguntas.get(intRandom).getPuntucion();
        NPreguntas.remove(intRandom);
    }

    public void CrearPreguntas(){
        NPreguntas.add( new Question("1+1", "2", "3", "1", "2", 5));
        NPreguntas.add( new Question("2+2", "3", "4", "2", "4", 5));
        NPreguntas.add( new Question("3+3", "6", "9", "12", "6", 5));
        NPreguntas.add( new Question("4+4", "4", "7", "8", "8", 5));
        NPreguntas.add( new Question("5+5", "10", "6", "2", "10", 5));
        NPreguntas.add( new Question("6+6", "6", "12", "0", "12", 5));
        NPreguntas.add( new Question("7+7", "7", "14", "21", "14", 5));
        NPreguntas.add( new Question("8+8", "9", "16", "45", "16", 5));
        NPreguntas.add( new Question("9+9", "10", "4", "18", "18", 5));
        NPreguntas.add( new Question("10+10", "20", "21", "36", "20", 5));
        NPreguntas.add( new Question("11+11", "11", "22", "32", "22", 5));
    }

    public void Comprobar(Button Seleccion){
        if(Seleccion.getText() == Correcta){
            Score += Puntucion;
            tvScore.setText(Score+"");
            Seleccion.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            Toast.makeText(this, "Pregunta Correcta", Toast.LENGTH_LONG).show();
            btnAux.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            btnAux.setEnabled(false);
        } else {
            Seleccion.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            btnAux.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(this, "Pregunta Incorrecta", Toast.LENGTH_LONG).show();
        }
    }

    public void Activar(Boolean Desabilitar){
        btnOp1.setEnabled(Desabilitar);
        btnOp2.setEnabled(Desabilitar);
        btnOp3.setEnabled(Desabilitar);
    }

    public void ReiniciarColor(){
        btnOp1.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btnOp2.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btnOp3.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
    }

    public void PintarPreguntas(Button NQuiz){
        MostrarPregunta(NQuiz);
        Activar(true);
        ReiniciarColor();


        //if(NPreguntas.size() == 0){
        //    Intent I = new Intent(getApplicationContext(), Win.class);
        //    I.putExtra("Win", Score+"");
        //    startActivity(I);
        //}


    }


}