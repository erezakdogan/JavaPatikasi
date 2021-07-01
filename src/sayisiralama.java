package src;

import java.util.Scanner;

public class sayisiralama {
    public static void main(String[] args) {
     int a,b,c;
     Scanner scanner = new Scanner(System.in);

     System.out.print("1.Sayı : ");
     a = scanner.nextInt();
     System.out.print("2.Sayı : ");
     b = scanner.nextInt();
     System.out.print("3.Sayı : ");
     c = scanner.nextInt();
     scanner.close();

     
     if(a<c && a<b){
         if(b<c){
            System.out.print("a<b<c");
         }else{
            System.out.print("a<c<b");
         }
     }else if(b<a && b<c){
         if(a<c){
            System.out.print("b<a<c");
         }else{
            System.out.print("b<c<a");
         }
     }else if(c<a && c<b){
        if(b<a){
           System.out.print("c<b<a");
        }else{
           System.out.print("c<a<b");
        }
    }
}}
