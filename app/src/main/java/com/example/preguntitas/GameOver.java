package com.example.preguntitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    TextView tvGScore;
    Button btnGReiniciar;
    String Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        conectar();

        Bundle pInfo = getIntent().getExtras();
        if(pInfo != null){
            Score = pInfo.getString("Over");
            tvGScore.setText(Score);
        }

        btnGReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });

    }

    private void conectar() {
        tvGScore = findViewById(R.id.tvGScore);
        btnGReiniciar = findViewById(R.id.btnGReiniciar);
    }
}