package com.example.preguntitas.files;

import android.content.Context;
import android.util.Log;

import com.example.preguntitas.object.Question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class archivoPlanitoQuestion {
    String Archivo = "Preguntas.txt";
    Context ctx;
    FileOutputStream fos;
    FileInputStream fis;

    public archivoPlanitoQuestion(Context ctx) {this.ctx =ctx;}

    public void EscribirPregunta(String textArchivo) throws IOException {
        try {
            fos = ctx.openFileOutput(Archivo, Context.MODE_APPEND);
            fos.write(textArchivo.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("", e.getMessage());
        } catch (IOException ex) {
            Log.e("", ex.getMessage());
        }
    }

    public String Leer(){
        String Lectura="";
        try {
            fis=ctx.openFileInput(Archivo);
            int i;
            char caracter ='a';
            do {
                i = fis.read();
                if(i != '\n'){
                    caracter = (char)i;
                    Lectura += caracter;
                }
                if(caracter == '.'){
                    Lectura += '\n';
                }
            }while (i>0);
            Lectura += '\n';
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Lectura;
    }

    public ArrayList<Question> GuardarArrayPregunta(){
        ArrayList<String> aux = new ArrayList();
        ArrayList<Question> End = new ArrayList();

        String Lectura="";

        try {
            fis=ctx.openFileInput(Archivo);
            int i;
            char caracter ='a';
            do {
                i = fis.read();
                if(i != '\n'){
                    caracter = (char)i;
                    Lectura += caracter;
                }
                if(caracter == '/'){
                    aux.add(Lectura.substring(0, Lectura.length()-1));
                    Lectura = "";
                }
                if(caracter == '.'){
                    aux.add(Lectura.substring(0, Lectura.length()-1));
                    End.add( new Question(aux.get(0), aux.get(1), aux.get(2), aux.get(3), aux.get(1), Integer.parseInt(aux.get(4))));
                    aux.clear();
                    Lectura = "";
                }
            }while (i>0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return End;
    }

    public void Borrar() throws IOException {
        try {
            String aux = "";
            fos = ctx.openFileOutput(Archivo, Context.MODE_PRIVATE);
            fos.write(aux.getBytes());  
            fos.close();
        } catch (IOException ex){
            ex.getMessage();
        }

    }
}


