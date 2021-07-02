package src;

import java.util.Scanner;

public class sayibasamaktoplami
 {
 public static void main(String[] args) {
     int num ;
     Scanner scan = new Scanner(System.in);
     System.out.println("Bir sayı giriniz : ");
     num = scan.nextInt();
     scan.close();
     
     int toplam=0;
     while(num != 0)
     {
        toplam+=(num%10);
        num /= 10;
     }

     System.out.println("Basamak Toplamı: " + toplam);
 }    
}
