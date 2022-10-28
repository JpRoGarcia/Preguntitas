package com.example.preguntitas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UsersS extends AppCompatActivity {

    Button btnInicio, btnCrear;
    EditText edCorreo, edPassword;
    String email, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_s);
        conectar();
        mAuth = FirebaseAuth.getInstance();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), UsersR.class);
                startActivity(I);
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edCorreo.getText().toString();
                password = edPassword.getText().toString();
                Cargar(email, password);
            }
        });
    }

    public void Cargar(String email,  String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent I = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(I);
                } else {
                    Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void conectar() {
        edCorreo = findViewById(R.id.edCorreo);
        edPassword = findViewById(R.id.edPassword);
        btnInicio = findViewById(R.id.btnInicio);
        btnCrear = findViewById(R.id.btnCrear);
    }
}