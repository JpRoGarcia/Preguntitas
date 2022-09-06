package com.example.preguntitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    TextView tvWScore;
    Button btnWReiniciar;
    String Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        conectar();

        Bundle pInfo = getIntent().getExtras();
        if(pInfo != null){
            Score = pInfo.getString("Win");
            tvWScore.setText(Score);
        }

        btnWReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        tvWScore = findViewById(R.id.tvWScore);
        btnWReiniciar = findViewById(R.id.btnWReiniciar);
    }
}