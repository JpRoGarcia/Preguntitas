package com.example.preguntitas.object;

public class Score {
    int Id;
    String name;
    int Vida;
    int Point;

    public Score(int id, String name, int vida, int point) {
        Id = id;
        this.name = name;
        Vida = vida;
        Point = point;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    @Override
    public String toString() {
        return  "Nombre: " + name + '\n' +
                "Puntos: " + Point + '\n' +
                "Vidas: " + Vida;
    }
}
