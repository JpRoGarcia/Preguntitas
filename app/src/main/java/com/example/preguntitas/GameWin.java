package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameWin extends AppCompatActivity {

    TextView tvWScore;
    Button btnWReiniciar, btnWMenu, btnWPodio;
    String Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);
        conectar();

        Bundle pInfo = getIntent().getExtras();
        if(pInfo != null){
            Score = pInfo.getString("GameWin");
            tvWScore.setText(Score);
        }

        btnWReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), Game.class);
                I.putExtra("Name", Nombre());
                startActivity(I);
            }
        });

        btnWMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });

        btnWPodio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), ScoreR.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        tvWScore = findViewById(R.id.tvWScore);
        btnWReiniciar = findViewById(R.id.btnWReiniciar);
        btnWPodio = findViewById(R.id.btnWPodio);
        btnWMenu = findViewById(R.id.btnWMenu);
    }

    public String Nombre(){
        Bundle pInfo = getIntent().getExtras();
        return  pInfo.getString("Name");
    }
}