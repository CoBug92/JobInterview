package com.bogdan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFromFile {
    static int Rows = 4;    //Кол-во строк в coordinates.txt
    static int Col = 2;     //Кол-во столбцов в coordinates.txt

    static Integer[][] data = new Integer[Col][Rows];  //Массив для данных из файла

    public static void ReadFromFileStart() {
        String pathToFile = "coordinates.txt";   //Имя считываемого файла
        Scanner input = null;
        try {
            input = new Scanner(new FileReader(pathToFile));
        } catch (FileNotFoundException e) {
            System.out.println("Correct input file not found.");
            System.exit(0);
        }
        for (int y = 0; y < Rows; y++) {
            for (int x = 0; x < Col; x++) {
                data[x][y] = input.nextInt();
            }
        }
        input.close();
    }
}
