package src;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class mayintarlasi{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Satır Giriniz : ");
        int r= scanner.nextInt();
        System.out.print("Sütun Giriniz : ");
        int c=scanner.nextInt();

        String[][] base = new String[r][c];
        String[][] bomb= new String[r][c];


        for(String [] arr:base){
        Arrays.fill(arr," - ");
        }
        for(String [] arr:bomb){
        Arrays.fill(arr, " - ");
         }

        for(String[]b:base){
            for(String s:b){
                System.out.print(s);
            }
            System.out.println();
        }


        int bombNum= (r*c)/4;
       
        Random ran = new Random();
        for(int i =0;i<bombNum;i++){
          
            int d = ran.nextInt(r);
            int d2 = ran.nextInt(c);
            
            bomb[d][d2]=" * ";
        }

    
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("\n=================================\n");

        while(!bomb[a][b].equals(" * ")){
           
            int numofbombs = 0;
        for(int i = a-1; i<=a+1;i++){
            for(int j=b-1; j<=b+1;j++){
                boolean situ1 = i<0||i>r-1;
                boolean situ2 = j<0||j>r-1;
                if(situ1||situ2){
                    continue;
                }else if(bomb[i][j]==" * "){
                    numofbombs++;
                } 
               
            }
      
      
        }  
        String dd = Integer.toString(numofbombs); 
        base[a][b]=" "+dd+" ";
        for(String[]u: base){
            for(String s:u){
                System.out.print(s);
            }
            System.out.println();
        }
            int a2 = scanner.nextInt();
            int b2 = scanner.nextInt();
            a = a2;
            b=b2;
            System.out.println("\n=================================\n");

           
    }
    System.out.println("Mayına bastınız.");
    base[a][b]=" * "; 
    for(String[]u: base){
        for(String s:u){
            System.out.print(s);
        }
        System.out.println();
    }

        
    }
}