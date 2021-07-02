package src;

import java.util.Scanner;

public class cinzodyagi{
    public static void main(String[] args) {
        int year;

        Scanner scan = new Scanner(System.in);
        System.out.println("Doğum Yılınızı Giriniz : ");
        year = scan.nextInt();
        scan.close();
        int zodiac = year%12;

        switch(zodiac){
            case 0:
            System.out.print("Çin Zodyağı Burcunuz : Maymun ");
            break;
            case 1:
            System.out.print("Çin Zodyağı Burcunuz : Horoz");
            break;
            case 2:
            System.out.print("Çin Zodyağı Burcunuz : Köpek ");
            break;
            case 3:
            System.out.print("Çin Zodyağı Burcunuz : Domuz");
            break;
            case 4:
            System.out.print("Çin Zodyağı Burcunuz : Fare");
            break;
            case 5:
            System.out.print("Çin Zodyağı Burcunuz : Öküz");
            break;
            case 6:
            System.out.print("Çin Zodyağı Burcunuz : Kaplan");
            break;
            case 7:
            System.out.print("Çin Zodyağı Burcunuz : Tavşan");
            break;
            case 8:
            System.out.print("Çin Zodyağı Burcunuz : Ejderha");
            break;
            case 9:
            System.out.print("Çin Zodyağı Burcunuz : Yılan");
            break;
            case 10:
            System.out.print("Çin Zodyağı Burcunuz : At");
            break;
            case 11:
            System.out.print("Çin Zodyağı Burcunuz : Koyun");
            break;
            default:
            System.out.print("Eksik veya hatalı değer girdiniz");

        }
    }
}