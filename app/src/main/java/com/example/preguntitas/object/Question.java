package com.example.preguntitas.object;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String Pregunta;
    private String Correcta;
    private String OpcionUno;
    private String OpcionDos;
    private int Puntucion;

    public Question(int id, String pregunta, String correcta, String opcionUno, String opcionDos, int puntucion) {
        this.id = id;
        Pregunta = pregunta;
        Correcta = correcta;
        OpcionUno = opcionUno;
        OpcionDos = opcionDos;
        Puntucion = puntucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String pregunta) {
        Pregunta = pregunta;
    }

    public String getCorrecta() {
        return Correcta;
    }

    public void setCorrecta(String correcta) {
        Correcta = correcta;
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

    public int getPuntucion() {
        return Puntucion;
    }

    public void setPuntucion(int puntucion) {
        Puntucion = puntucion;
    }
}
