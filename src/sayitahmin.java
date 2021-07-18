package src;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class sayitahmin {
    
      public static void main(String[] args) {
          Random random = new Random();
          int number = random.nextInt(100);

          Scanner scanner = new Scanner(System.in);
          
          int right =0;
          int trues =0;
          while(right<5){
            double selected = scanner.nextInt();
              if(selected<0||selected>99){
                  System.out.println("Tahmin aralığını aştınız 0-100 arasında bir rakam giriniz.");
                  right++;
                  System.out.println("Kalan Hakkınız : "+ (5-right));
                  continue;
              }
              if(selected==number){
                System.out.println("Tebrikler, doğru tahmin ! Tahmin ettiğini sayı : " + number);
                trues++;
                right++;
                
              }else {
                 System.out.println("Hatalı bir sayı girdiniz !");
                 if (selected > number) {
                     System.out.println(selected + " sayısı, gizli sayıdan büyüktür.");
                 } else {
                     System.out.println(selected + " sayısı, gizli sayıdan küçüktür.");
                }  
                right++;
                System.out.println("Kalan hak : " + (5 - right));
          }
        
        }
        scanner.close();

        if(trues==5){
            System.out.println("Tebrikler, Kazandınız");
        }else{
             System.out.println("Deneme hakkınız tükenmiştir. Kaybettiniz!");
        }

    }
}
