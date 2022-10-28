package com.example.preguntitas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.preguntitas.database.CRUDUsers;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UsersR extends AppCompatActivity {

    EditText edRName, edRCorreo, edRPassword, edROP;
    Button btnCrear, btnRVolver;
    String id, nombre, correo, pass;
    Boolean Rol;
    RadioGroup opType;
    RadioButton radio_Jugador, radio_Admin;
    CRUDUsers objDB = new CRUDUsers(this);

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_r);
        conectar();
        mAuth = FirebaseAuth.getInstance();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = edRName.getText().toString();
                correo = edRCorreo.getText().toString();
                pass = edRPassword.getText().toString();

                if(radio_Jugador.isChecked() == true){
                    Rol = false;
                }

                if(radio_Admin.isChecked() == true){
                    Rol = true;
                }

                CrearCuenta(correo, pass);
                Toast.makeText(getApplicationContext(), "Usuario Creado", Toast.LENGTH_SHORT).show();

                edRName.setText("");
                edRCorreo.setText("");
                edRPassword.setText("");
            }
        });

        btnRVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), UsersS.class);
                startActivity(I);
            }
        });

    }

    private void conectar() {
        edRName = findViewById(R.id.edRName);
        edRCorreo = findViewById(R.id.edRCorreo);
        edRPassword = findViewById(R.id.edRPassword);
        opType = findViewById(R.id.opType);
        radio_Admin = findViewById(R.id.radio_Admin);
        radio_Jugador = findViewById(R.id.radio_Jugador);
        btnCrear = findViewById(R.id.btnCrear);
        btnRVolver = findViewById(R.id.btnRVolver);
    }

    public void CrearCuenta(String email,  String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    id = mAuth.getCurrentUser().getUid();
                    objDB.CreateUsers(id, nombre, correo, pass, Rol);
                } else {
                    Toast.makeText(getApplicationContext(), "Error Al Crear Cuenta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}