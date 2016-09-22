package com.bogdan;
import static java.lang.Math.sqrt;

public class Point {
    int x,y;

    protected Point(int x,int y) { //Точка, задаётся координатами X,Y
        this.x=x;
        this.y=y;
    }

    protected boolean OnPoint(Point X) { //Совпадает ли точка с указанной в скобках
        return (this.x == X.x) && (this.y == X.y);
    }

    protected boolean OnLine(Point A, Point B) { //Лежит ли точка на отрезке
        try {
        	if (this.OnPoint(A) || this.OnPoint(B)){
        		return false;
        	}else{
            return (((this.x - A.x) * (B.y - A.y)) == ((this.y - A.y) * (B.x - A.x))) && (this.HowMuchTo(A) + this.HowMuchTo(B) == A.HowMuchTo(B));
        	}
        } catch (ArithmeticException e) {
            System.out.println("Devision by zero happened here!");
        }
        return false;
    }

    protected int HowMuchTo(Point X) { //Расстояние между точками
        return (int)(sqrt(Math.pow((X.x-this.x),2)+Math.pow((X.y-this.y),2)));
    }

    protected  boolean LiesInside (Quadrangle X) { //Находится ли точка внутри 4-х угольника

        Point A=X.getA();
        Point B=X.getB();
        Point C=X.getC();
        Point D=X.getD();

        boolean IsIn = false;
        Integer[] x = new Integer[5];
        Integer[] y = new Integer[5];
        x[1]=A.x;
        x[2]=B.x;
        x[3]=C.x;
        x[4]=D.x;

        y[1]=A.y;
        y[2]=B.y;
        y[3]=C.y;
        y[4]=D.y;

        int n = 4;
        x[0]=x[n];              
        y[0]=y[n];              // Формула найдена в интернете, и может сильно повредить психику, если вдумываться в смысл
        for (int i=0; i<n;i++) {
            if ((this.y > y[i] == this.y <= y[i + 1])&&(this.x-x[i]<(this.y-y[i])*(x[i+1]-x[i])/(y[i+1]-y[i]))) {
                    IsIn=!IsIn; //инвертирует свое значение
            }
        }

        if (this.OnPoint(A)||this.OnPoint(B)||this.OnPoint(C)||this.OnPoint(D)||
                this.OnLine(A,B)||this.OnLine(B,C)||this.OnLine(C,D)||this.OnLine(D,A)) { 
            IsIn=false;
        }

        return IsIn;
    }
   
    
//----------Caution! Getters & Setters bellow this line!----------------------------------------
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
		return y;
	}

	public void setY(int y) {
        this.y = y;
    }
}
