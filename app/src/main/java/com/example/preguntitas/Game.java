package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.preguntitas.database.CRUDQuestion;
import com.example.preguntitas.database.CRUDScore;
import com.example.preguntitas.object.Question;
import com.example.preguntitas.object.Score;

import java.util.ArrayList;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView tvScore, tvQuiz, tvGName, tvVida;
    Button btnOp1, btnOp2, btnOp3;
    Button btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnDiez;
    Button btnOnce, btnDoce, btnTrece, btnCatorce, btnQuince, btnDieciseis, btnDiecisiete, btnODieciocho, btnDieciNueve, btnVeinte;
    int Score, PreguntasBuenas, Puntucion, vidas;
    String Correcta;
    Button btnAux;

    Random random = new Random();
    ArrayList<Question> NPreguntas = new ArrayList();
    CRUDQuestion objDB = new CRUDQuestion(this);
    CRUDScore objDBs = new CRUDScore(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        conectar();
        NPreguntas = objDB.ReadQuestions();
        Score = 0;
        PreguntasBuenas = 0;
        tvGName.setText(Nombre());
        vidas = NPreguntas.size() + PreguntasBuenas;
        tvVida.setText((vidas-19)+"");

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
        tvGName = findViewById(R.id.tvGName);
        tvQuiz = findViewById(R.id.tvQuiz);
        tvVida = findViewById(R.id.tvVida);
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

        OpcionR.add(NPreguntas.get(intRandom).getCorrecta());
        OpcionR.add(NPreguntas.get(intRandom).getOpcionUno());
        OpcionR.add(NPreguntas.get(intRandom).getOpcionDos());

        tvQuiz.setText(NPreguntas.get(intRandom).getPregunta());
        btnOp1.setText(OpcionRandom(OpcionR));
        btnOp2.setText(OpcionRandom(OpcionR));
        btnOp3.setText(OpcionRandom(OpcionR));
        Correcta = NPreguntas.get(intRandom).getCorrecta();
        Puntucion = NPreguntas.get(intRandom).getPuntucion();
        NPreguntas.remove(intRandom);
    }

    public void Comprobar(Button Seleccion){
        if(Seleccion.getText() == Correcta){
            Score += Puntucion;
            PreguntasBuenas += 1;
            tvScore.setText(Score+"");
            Seleccion.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Bueno));
            btnAux.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Bueno));
            btnAux.setEnabled(false);
        } else {
            vidas = NPreguntas.size() + PreguntasBuenas;
            tvVida.setText((vidas-19)+"");
            Seleccion.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Malo));
            btnAux.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Malo));
        }

        if(vidas < 20) {
            CrearPuntaje(Nombre(), (vidas-19), Score);
            Intent I = new Intent(getApplicationContext(), GameOver.class);
            I.putExtra("Over", Score + "");
            I.putExtra("Name", Nombre());
            startActivity(I);
        } else if(PreguntasBuenas == 20){
            CrearPuntaje(Nombre(), (vidas-19), Score);
            Intent I = new Intent(getApplicationContext(), GameWin.class);
            I.putExtra("GameWin", Score+"");
            I.putExtra("Name", Nombre());
            startActivity(I);
        }
    }

    public void Activar(Boolean Desabilitar){
        btnOp1.setEnabled(Desabilitar);
        btnOp2.setEnabled(Desabilitar);
        btnOp3.setEnabled(Desabilitar);
    }

    public void ReiniciarColor(){
        btnOp1.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.P));
        btnOp2.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.P));
        btnOp3.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.P));
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

    public void CrearPuntaje(String Name, int Vidas, int Puntos){
        ArrayList<Score> aux = objDBs.ReadScore(Name);
        if(aux.size() == 0){
            objDBs.CreateScores(Name, Vidas, Puntos);
        } else {
            if(aux.get(0).getPoint() < Puntos){
                objDBs.UpdateScore(Name, Vidas, Puntos);
            }
            if(aux.get(0).getPoint() == Puntos &&  aux.get(0).getVida() < Vidas){
                objDBs.UpdateScore(Name, Vidas, Puntos);
            }
        }
    }

    public String Nombre(){
        String Aux;
        Bundle pInfo = getIntent().getExtras();
        if(pInfo != null){
            Aux = pInfo.getString("Name");
        } else {
            Aux = "Anonymous";
        }
        return  Aux;
    }
}