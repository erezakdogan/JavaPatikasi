package src;

import java.util.Scanner;

public class gecmedurumu {
public static void main(String[] args) {
    int mat, fiz, kim, turkce, muzik;
    Scanner input = new Scanner(System.in);

    System.out.print("Matematik Notunuzu Giriniz : ");
    mat = input.nextInt();

    System.out.print("Fizik Notunuzu Giriniz : ");
    fiz = input.nextInt();

    System.out.print("Kimya Notunuzu Giriniz : ");
    kim = input.nextInt();

    System.out.print("Türkçe Notunuzu Giriniz : ");
    turkce = input.nextInt();

    System.out.print("Müzik Notunuzu Giriniz : ");
    muzik = input.nextInt();
    input.close();

      double ortalama = (mat+ fiz+ kim+  turkce+ muzik)/5;

      if(0<= ortalama && ortalama < 55){    
        System.out.println(" Sınıfta Kaldı");
        System.out.println("Ortalamanız: "+ ortalama );

      } else if (55<= ortalama && ortalama <=100){
        System.out.println("Sınıfı Geçti");
        System.out.println("Ortalamanız: "+ ortalama );
      } else if ( ortalama < 0 || ortalama > 100){
        System.out.print("Ortalamanız 0-100 aralığı dışında değer alamaz" );
      }
}
}