package com.example.preguntitas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.preguntitas.object.Question;

import java.util.ArrayList;

public class CRUDQuestion {
    public Context ctx;

    public CRUDQuestion(Context ctx) {this.ctx =ctx;}

    public void CreateQuestion(String Pregunta,  String Correcta, String OpcionUno, String OpcionDos, String Puntos){
        DbHelper helper = new DbHelper(ctx, "Questions", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("pregunta", Pregunta);
        cv.put("opcionUno", OpcionUno);
        cv.put("opcionDos", OpcionDos);
        cv.put("Correcta", Correcta);
        cv.put("puntaje", Puntos);
        db.insert("Questions", null, cv);
        db.close();
    }

    public ArrayList<Question> ReadQuestion(int id){
        ArrayList<Question> aux = new ArrayList<>();
        DbHelper helper = new DbHelper(ctx, "Questions", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select * from Questions where Id = '" + id +"'";
        Cursor C = db.rawQuery(SQL, null);

        if(C.moveToFirst()){
            do {
                aux.add( new Question(C.getInt(0), C.getString(1), C.getString(2), C.getString(3), C.getString(4), C.getInt(5)));
            } while (C.moveToNext());
        }
        db.close();
        return aux;
    }

    public ArrayList<Question> ReadQuestions(){
        ArrayList<Question> aux = new ArrayList<>();
        DbHelper helper = new DbHelper(ctx, "Questions", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select * from Questions";
        Cursor C = db.rawQuery(SQL, null);
        if(C.moveToFirst()){
            do {
                aux.add(new Question(C.getInt(0), C.getString(1), C.getString(2), C.getString(3), C.getString(4), C.getInt(5)));
            } while (C.moveToNext());
        }
        db.close();
        return aux;
    }

    public void UpdateQuestion(int id, String Pregunta,  String Correcta, String OpcionUno, String OpcionDos, String Puntos){
        DbHelper helper = new DbHelper(ctx, "Questions", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "UPDATE Questions " +
                "set pregunta = '" + Pregunta +"'" +
                ", Correcta = '" + Correcta +"' " +
                ", opcionUno = '" + OpcionUno +"' " +
                ", opcionDos = '" + OpcionDos +"' " +
                ", puntaje = '" + Puntos +"' " +
                "where Id = '" + id +"'";
        db.execSQL(SQL);
        db.close();
    }

    public void DeleteQuestion(int id){
        DbHelper helper = new DbHelper(ctx, "Questions", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Delete from Questions where Id = '" + id +"'";
        db.execSQL(SQL);
        db.close();
    }
}
