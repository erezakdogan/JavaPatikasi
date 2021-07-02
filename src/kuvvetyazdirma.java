package src;

import java.util.Scanner;

public class kuvvetyazdirma {
   public static void main(String[] args) {
       int num;
       Scanner scanner =new Scanner(System.in);
       System.out.print("Sayı giriniz : ");
       num = scanner.nextInt();
       scanner.close();

       System.out.println("Dördün Katları");
for(int i = 1; i<=num; i*=4){
        System.out.println(i);
}

    System.out.println("Beşin Katları");
for(int i = 1; i<=num; i*=5){
    System.out.println(i);

   
   

        }        
    }
                      
  }
   
