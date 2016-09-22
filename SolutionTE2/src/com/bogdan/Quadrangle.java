package com.bogdan;

public class Quadrangle {
    public static char[][] image;
    public static boolean PointReadyToDraw = false;
    Point A,B,C,D;

    protected Quadrangle(Point A, Point B, Point C, Point D){ //Четырёхугольник как объект
        this.A=A;
        this.B=B;
        this.C=C;
        this.D=D;
    }

    //----------Caution! Getters bellow this line!----------------------------------------

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public Point getC() {
        return C;
    }

    public Point getD() {
        return D;
    }
}
