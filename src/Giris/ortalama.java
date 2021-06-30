package src.Giris;

import java.util.Scanner;

public class ortalama {
public static void main(String[] args) {
    int mat, fiz, kim, biyo, tarih, turkce, muzik;
    Scanner input = new Scanner(System.in);

    System.out.print("Matematik Notunuzu Giriniz : ");
    mat = input.nextInt();

    System.out.print("Fizik Notunuzu Giriniz : ");
    fiz = input.nextInt();

    System.out.print("Kimya Notunuzu Giriniz : ");
    kim = input.nextInt();

    System.out.print("Biyoloji Notunuzu Giriniz : ");
    biyo = input.nextInt();

    System.out.print("Tarih Notunuzu Giriniz : ");
    tarih = input.nextInt();

    System.out.print("Türkçe Notunuzu Giriniz : ");
    turkce = input.nextInt();

    System.out.print("Müzik Notunuzu Giriniz : ");
    muzik = input.nextInt();
    input.close();
      double ortalama = (mat+ fiz+ kim+ biyo+ tarih+ turkce+ muzik)/6;
      boolean gectimi = (ortalama>=60);
      String durum =gectimi?" Sınıfı Geçti":" Sınıfta Kaldı";
      String sonuc = ("Ortalamanız: "+ ortalama + durum );
    System.out.println(sonuc);
}
}