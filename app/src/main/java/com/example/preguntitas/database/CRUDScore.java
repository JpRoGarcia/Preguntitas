package com.example.preguntitas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.preguntitas.object.Score;

import java.util.ArrayList;

public class CRUDScore {
    public Context ctx;

    public CRUDScore(Context ctx) {this.ctx =ctx;}

    public void CreateScores(String Name, int Live, int Point){
        DbHelper helper = new DbHelper(ctx, "Scores", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre", Name);
        cv.put("vida", Live);
        cv.put("punto", Point);
        db.insert("Scores", null, cv);
        db.close();
    }

    public ArrayList<Score> ReadScore(String Name){
        ArrayList<Score> aux = new ArrayList<>();
        DbHelper helper = new DbHelper(ctx, "Scores", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select * from Scores where nombre = '" + Name +"'";
        Cursor C = db.rawQuery(SQL, null);

        if(C.moveToFirst()){
            do {
                aux.add( new Score(C.getInt(0), C.getString(1), C.getInt(2), C.getInt(3)));
            } while (C.moveToNext());
        }
        db.close();
        return aux;
    }

    public ArrayList<Score> ReadScore(){
        ArrayList<Score> aux = new ArrayList<>();
        DbHelper helper = new DbHelper(ctx, "Scores", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select * from Scores";
        Cursor C = db.rawQuery(SQL, null);
        if(C.moveToFirst()){
            do {
                aux.add( new Score(C.getInt(0), C.getString(1), C.getInt(2), C.getInt(3)));
            } while (C.moveToNext());
        }
        db.close();
        return aux;
    }

    public void UpdateScore(String Name,  int Live, int Point){
        DbHelper helper = new DbHelper(ctx, "Scores", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "UPDATE Scores " +
                "set vida = '" + Live +"'" +
                ", punto = '" + Point +"' " +
                "where nombre = '" + Name +"'";
        db.execSQL(SQL);
        db.close();
    }
}
