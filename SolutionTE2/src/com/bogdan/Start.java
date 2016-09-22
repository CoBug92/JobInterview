package com.bogdan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {

    static Point A;                             //Рёбра 4-х угольника
    static Point B;
    static Point C;
    static Point D;

    public static Point X = new Point(0,0);     //Проверяемая точка

    static Quadrangle Z;                             //Четырёхугольник в виде отдельного объекта
    

    public static void main(String[] args){
        ReadFromFile.ReadFromFileStart();         //Чтение файла coordinates.txt
        A = new Point(ReadFromFile.data[0][0],ReadFromFile.data[1][0]);  //Присваивание точкам координат из файла
        B = new Point(ReadFromFile.data[0][1],ReadFromFile.data[1][1]);
        C = new Point(ReadFromFile.data[0][2],ReadFromFile.data[1][2]);
        D = new Point(ReadFromFile.data[0][3],ReadFromFile.data[1][3]);
        Z = new Quadrangle(A,B,C,D);                                         //Объявление четырёхугольника
        
        Scanner s = new Scanner(System.in);                             //Чтение координат проверяемой точки с клавиатуры
            System.out.println("Enter coords of point \"O\": ");
            System.out.print("x: ");
            try {
                X.setX(s.nextInt());
                System.out.print("y: ");
                X.setY(s.nextInt());
            } catch (InputMismatchException e){
                System.out.println("Please enter integer values next time.");
                System.exit(0);
            }
        System.out.println();
        s.close();                                                          //Высвобождение Scanner'a
        
        System.out.println("Point \"O\" lies inside figure = "+X.LiesInside(Z)+";");  //Отображение решения задачи
        System.out.println("Point \"O\" lies on one of the lines = "+(X.OnLine(A,B)||X.OnLine(B,C)||X.OnLine(C,D)||X.OnLine(D,A))+";");
        System.out.println("Point \"O\" lies on one of the points of square = "+(X.OnPoint(A)||X.OnPoint(B)||X.OnPoint(C)||X.OnPoint(D))+";");
        if (X.LiesInside(Z) && (!(!X.OnLine(A,B)||!X.OnLine(B,C)||!X.OnLine(C,D)||!X.OnLine(D,A)) && !(X.OnPoint(A)||X.OnPoint(B)||X.OnPoint(C)||X.OnPoint(D)))){ 
        	System.out.println("Point \"O\" lies outside figure = "+"true"+";");  
        }else{
        	System.out.println("Point \"O\" lies outside figure = "+"false"+";"); 
        }
    }
}
