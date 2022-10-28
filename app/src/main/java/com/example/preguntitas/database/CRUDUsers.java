package com.example.preguntitas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.preguntitas.object.Question;
import com.example.preguntitas.object.Score;
import com.example.preguntitas.object.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CRUDUsers {
    public Context ctx;
    DatabaseReference miDB;

    public CRUDUsers(Context ctx) {this.ctx =ctx;}

    public void CreateUsers( String Id, String Name, String Email, String Password, Boolean TypeS){
        miDB = FirebaseDatabase.getInstance().getReference();
        Users Q = new Users(Id, Name, Email, Password, TypeS);
        miDB.child("Users").child(Id).setValue(Q);
    }
}
