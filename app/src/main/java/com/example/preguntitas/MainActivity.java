package com.example.preguntitas;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Question> NPreguntas = new ArrayList();
    Random random = new Random();
    TextView tvScore, tvQuiz;
    Button btnOp1, btnOp2, btnOp3, btnNext;
    Button btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnDiez;
    Button btnOnce, btnDoce, btnTrece, btnCatorce, btnQuince, btnDieciseis, btnDiecisiete, btnODieciocho, btnDieciNueve, btnVeinte;
    int Score, PreguntasBuenas, Puntucion;
    String Correcta;
    Button btnAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        CrearPreguntas();
        Score = 0;
        PreguntasBuenas = 0;

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
        ArrayList<String> OpcionR = new ArrayList();
        int intRandom = random.nextInt(NPreguntas.size());

        OpcionR.add(NPreguntas.get(intRandom).getOpcionUno());
        OpcionR.add(NPreguntas.get(intRandom).getOpcionDos());
        OpcionR.add(NPreguntas.get(intRandom).getOpcionTres());

        tvQuiz.setText(NPreguntas.get(intRandom).getPregunta());
        btnOp1.setText(OpcionRandom(OpcionR));
        btnOp2.setText(OpcionRandom(OpcionR));
        btnOp3.setText(OpcionRandom(OpcionR));
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
        NPreguntas.add( new Question("6+6", "6", "12", "10", "12", 5));
        NPreguntas.add( new Question("7+7", "7", "14", "21", "14", 5));
        NPreguntas.add( new Question("8+8", "9", "16", "45", "16", 5));
        NPreguntas.add( new Question("9+9", "10", "4", "18", "18", 5));
        NPreguntas.add( new Question("10+10", "20", "21", "36", "20", 5));
        NPreguntas.add( new Question("11+11", "53", "22", "42", "22", 5));
        NPreguntas.add( new Question("12+12", "20", "24", "36", "24", 5));
        NPreguntas.add( new Question("1*1", "1", "2", "3", "1", 5));
        NPreguntas.add( new Question("2*2", "5", "4", "3", "4", 5));
        NPreguntas.add( new Question("3*3", "9", "10", "11", "9", 5));
        NPreguntas.add( new Question("4*4", "71", "12", "16", "16", 5));
        NPreguntas.add( new Question("5*5", "20", "52", "53", "20", 5));
        NPreguntas.add( new Question("6*6", "41", "55", "36", "36", 5));
        NPreguntas.add( new Question("7*7", "71", "22", "49", "49", 5));
        NPreguntas.add( new Question("8*8", "61", "25", "64", "64", 5));
        NPreguntas.add( new Question("9*9", "51", "81", "32", "81", 5));
        NPreguntas.add( new Question("10*10", "100", "200", "300", "100", 5));
        NPreguntas.add( new Question("11*11", "164", "122", "121", "121", 5));
        NPreguntas.add( new Question("12*12", "113", "144", "123", "144", 5));
        NPreguntas.add( new Question("Cuanto Saque?", "5", "4.5", "4", "5", 5));
    }

    public void Comprobar(Button Seleccion){
        if(Seleccion.getText() == Correcta){
            Score += Puntucion;
            PreguntasBuenas += 1;
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

        if((NPreguntas.size() + PreguntasBuenas) < 20) {
            Intent I = new Intent(getApplicationContext(), GameOver.class);
            I.putExtra("Over", Score + "");
            startActivity(I);
        } else if(PreguntasBuenas == 20){
            Intent I = new Intent(getApplicationContext(), Win.class);
            I.putExtra("Win", Score+"");
            startActivity(I);
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
    }

    public String OpcionRandom(ArrayList<String> Opcion){
        String Aux;
        int intRandom = random.nextInt(Opcion.size());
        Aux = (Opcion.get(intRandom));
        Opcion.remove(intRandom);
        return Aux;
    }
}
