package com.bogdan;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
 
public class ReadFromFile {
	static Integer[][] Data = new Integer[5][16];
	static Integer[][] massaverage = new Integer[1][16];
	static int a=0;
    public static Integer[][] ReadFromFiles() {
        
        String path;
        Scanner input = null;
 
        for (int i=0; i<5;i++) {
            path="cashbox"+(i+1)+".txt";//Имя считываемого файла
            try {
                input = new Scanner(new FileReader(path));
            } catch (FileNotFoundException e) {
                System.out.println("Correct input file not found.");
            }
            for (int j=0; j<16; j++){
                Data[i][j]=input.nextInt();
            }
            input.close();
        }
        return Data;
    }

    public static void sum(){
        for(int j=0; j<16; j++){
            for(int i=0; i<5; i++){
            	a = a + Data[i][j];
            	massaverage[0][j] = a;
            }
        }
    }
    
    public static void max(){
    	int max;
    	max = massaverage[0][0];
    	for (int i=0;i<16;i++) {
    		if (massaverage[0][i]> max){
    			max=massaverage[0][i];
    		}
    	}	
    	for (int i=0;i<16;i++) {
    		if (massaverage[0][i]> max || massaverage[0][i]< max){
    		}else{
    			int interval = i+1;
    			System.out.println("Max buyers: " + massaverage[0][i] + " in " + interval + " interval");	
    		}
    	}	
        
    }
    
    public static void main(String[] argv) throws FileNotFoundException{
    	ReadFromFiles();
    	sum();
    	max();
	}
}