
import java.util.Scanner;

public class manavkasa {
    public static void main(String[] args) {
        double armut = 2.14, armutK, 
        elma = 3.67, elmaK, 
        domates = 1.11, domatesK, 
        muz = 0.95, muzK, 
        patlıcan = 5.0, patlıcanK;

        Scanner iScanner = new Scanner(System.in);

        System.out.print("Armut Kaç Kilo ? :");
        armutK = iScanner.nextDouble();
        System.out.print("Elma Kaç Kilo ? :");
        elmaK = iScanner.nextDouble();
        System.out.print("Domates Kaç Kilo ? :");
        domatesK = iScanner.nextDouble();
        System.out.print("Muz Kaç Kilo ? :");
        muzK = iScanner.nextDouble();
        System.out.print("Patlıcan Kaç Kilo ? :");
        patlıcanK = iScanner.nextDouble();
        iScanner.close();
        double toplam = elma*elmaK+ armut*armutK+ domatesK*domates+ muz*muzK+patlıcan*patlıcanK;
        System.out.print("Toplam Tutar : "+ toplam+" TL");

    }
}
