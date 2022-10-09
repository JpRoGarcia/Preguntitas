package com.example.preguntitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNick;
    TextView tvWelcom;
    Button btnPuntaje, btnJugar, btnAdmin, btnStart;
    LinearLayout llUno, llDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), QuestionR.class);
                startActivity(I);
            }
        });

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llUno.setVisibility(view.GONE);
                llDos.setVisibility(view.VISIBLE);
            }
        });

        btnPuntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), ScoreR.class);
                startActivity(I);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String N = etNick.getText().toString();
                Intent I = new Intent(getApplicationContext(), Game.class);
                I.putExtra("Name", N);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnPuntaje = findViewById(R.id.btnPuntaje);
        btnJugar = findViewById(R.id.btnJugar);
        btnAdmin = findViewById(R.id.btnAdmin);
        tvWelcom = findViewById(R.id.tvWelcom);
        btnStart = findViewById(R.id.btnStart);
        etNick = findViewById(R.id.etNick);
        llUno = findViewById(R.id.llUno);
        llDos = findViewById(R.id.llDos);
    }
}