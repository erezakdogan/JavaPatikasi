
import java.util.Scanner;


public class vucutkitleindeksi {
    public static void main(String[] args) {
        double boy, kilo;
        
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz : ");
        boy = iScanner.nextDouble();
        System.out.print("Lütfen kilonuzu giriniz : ");
        kilo = iScanner.nextDouble();
        iScanner.close();
        double vki = kilo/(boy*boy);
        System.out.print("Vücut Kitle İndeksiniz : "+ vki);
        

    }
}
