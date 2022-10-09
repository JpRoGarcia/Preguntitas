package com.example.preguntitas.object;

public class Score {
    String name;
    int Point;

    public Score(String name, int point) {
        this.name = name;
        Point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "Puntos: " + Point;
    }
}
