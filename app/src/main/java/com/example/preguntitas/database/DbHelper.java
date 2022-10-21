package com.example.preguntitas.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    String TablaQuestion = "CREATE table Questions (Id Integer primary key autoincrement," +
            "pregunta text not null," +
            "Correcta text not null," +
            "opcionUno text not null," +
            "opcionDos text not null," +
            "puntaje text not null)";

    String TablaScore = "CREATE table Scores (Id Integer primary key autoincrement," +
                                            "nombre text not null," +
                                            "vida integer not null," +
                                            "punto integer not null)";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TablaQuestion);
        db.execSQL(TablaScore);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table Questions");
        db.execSQL("Drop table Scores");
        db.execSQL(TablaQuestion);
        db.execSQL(TablaScore);
    }
}
