package com.example.preguntitas.object;

import java.io.Serializable;

public class Question implements Serializable {
    private String id;
    private String Pregunta;
    private String Correcta;
    private String OpcionUno;
    private String OpcionDos;
    private int Puntuacion;

    public Question(String id, String pregunta, String correcta, String opcionUno, String opcionDos, int puntuacion) {
        this.id = id;
        Pregunta = pregunta;
        Correcta = correcta;
        OpcionUno = opcionUno;
        OpcionDos = opcionDos;
        Puntuacion = puntuacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        Puntuacion = puntuacion;
    }
}
