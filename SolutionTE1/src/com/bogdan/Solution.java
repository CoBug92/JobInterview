package com.bogdan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static Integer[] array;
	public static Integer[] timearray;
	public static int List;
	public static int size;
	public static int i = 0;
	public static double procent;
	public static void read() throws FileNotFoundException {     //Обработка ошибки, если файл не будет существовать
		        String pathToFile = "sequence.txt";
		        List<Integer> a1 = new ArrayList<Integer>();	//Создание списка элементов
		        Scanner input = new Scanner(new FileReader(pathToFile));	//Чтение из файла
		        while (input.hasNext()) {	//Добавление элементов в список
		            a1.add(input.nextInt());
		        }
		        array = new Integer[a1.size()];	//Создание массива чисел по длинне списка
		        for (int i=0;i<a1.size();i++) {
		            array[i]=Integer.parseInt(a1.get(i).toString());	//Заполнение массива и вывод на экран
		            //System.out.println(array[i]);	//вывод всего массива
		        }
		        size = a1.size();
		        input.close();
		    }
		    
			public static void min(){
				int min;
				min = array[0];
				for (int i=0;i<size;i++) {
					if (array[i]<min){
						min=array[i];
					}
		        }	
		        System.out.println("min " + min);	
		    }
		    
		    public static void max(){
		    	int max;
		    	max = array[0];
		    	for (int i=0;i<size;i++) {
		    		if (array[i]> max){
		    			max=array[i];
		    		}
		    	}	
		        System.out.println("max " + max);	
		    }

		    public static void average(){
		    	double average = 0;
		    	if (size > 0)
		    	{
		    	    double sum = 0;
		    	    for (int i = 0; i < size; i++) {
		    	         sum += array[i];
		    	    }
		    	    average = sum / size;
		    	}
		        System.out.println("average " + average);		
		    }
		    
		    public static void median(){
		    	Arrays.sort(array);	//Сортировка массива
		    	if((size%2)==0){//проверка на четность
		    		System.out.println("median "+array[size/2-1] + " " + array[size/2]);
		    	}else{
		    		System.out.println("median "+array[size/2]);
		    	}
		    }
	
		    public static void percentile(){
		    	Arrays.sort(array);	//Сортировка массива
		    	int a;
		    	int min = array[size-1];
		    	for(int i=size-1; i>=0; i--){
		    		procent = i*100/size;
		    		if(procent>=90){
		    			a = array[i];
		    			List = a;
		    		}
		    	}
		    	for (int i=0;i<size;i++) {
					if (List<min){
						min=List;
					}
		        }	
		        System.out.println("percentil " + min);	
		    }
		    
		    public static void main(String[] argv) throws FileNotFoundException{
				read();
				percentile();
				median();
				average();
				max();
				min();
			}
}
