package com.example.preguntitas.object;

import java.io.Serializable;

public class Question implements Serializable {
    private String Pregunta;
    private String OpcionUno;
    private String OpcionDos;
    private String OpcionTres;
    private String Correcta;
    private int Puntucion;

    public Question(String pregunta, String opcionUno, String opcionDos, String opcionTres, String correcta, int puntucion) {
        Pregunta = pregunta;
        OpcionUno = opcionUno;
        OpcionDos = opcionDos;
        OpcionTres = opcionTres;
        Correcta = correcta;
        Puntucion = puntucion;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String pregunta) {
        Pregunta = pregunta;
    }

    public String getOpcionUno() {
        return OpcionUno;
    }

    public void setOpcionUno(String opcionUno) {
        OpcionUno = opcionUno;
    }

    public String getOpcionDos() {
        return OpcionDos;
    }

    public void setOpcionDos(String opcionDos) {
        OpcionDos = opcionDos;
    }

    public String getOpcionTres() {
        return OpcionTres;
    }

    public void setOpcionTres(String opcionTres) {
        OpcionTres = opcionTres;
    }

    public String getCorrecta() {
        return Correcta;
    }

    public void setCorrecta(String correcta) {
        Correcta = correcta;
    }

    public int getPuntucion() {
        return Puntucion;
    }

    public void setPuntucion(int puntucion) {
        Puntucion = puntucion;
    }

    @Override
    public String toString() {
        return  "Pregunta: " + Pregunta + '\n' +
                "Opciones: " + OpcionUno + " | " + OpcionDos + " | " + OpcionTres + '\n' +
                "Puntuacion: " + Puntucion;
    }
}
