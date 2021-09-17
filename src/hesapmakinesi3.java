
import java.util.Scanner;

public class hesapmakinesi3 {
    static Scanner scan = new Scanner(System.in);

    static void plus() {
        System.out.print("Kaç sayı toplayacaksınız :");
        int i = scan.nextInt();
        int number, result = 0;
        for (int j = 1; j <= i; j++) {
            System.out.print(j + ". sayı :");
            number = scan.nextInt();
            result += number;
        }
        System.out.println("Sonuç : " + result);
    }

    static void minus() {
        System.out.print("1.Sayı :");
        int sayı1 = scan.nextInt();
        System.out.print("2.Sayı :");
        int sayı2 = scan.nextInt();
        int number = 0;

        for (int i = 0; i < 2; i++) {
            number = sayı1 - sayı2;
        }

        System.out.println("Sonuç : " + number);
    }

    static void times() {
        System.out.print("Kaç sayı çarpacaksınız :");
        int i = scan.nextInt();
        int number, result = 1;
        for (int j = 1; j <= i; j++) {
            System.out.print(j + ". sayı :");
            number = scan.nextInt();
            result *= number;
        }
        System.out.println("Sonuç : " + result);
    }

    static void divided() {
        double result=0.0;
        System.out.print(1 + ". sayı :");
        double first = scan.nextDouble();
        System.out.print(2 + ". sayı :");
        double second = scan.nextDouble();
        if(second==0){
            System.out.println("Bir sayı sıfıra bölünemez");
        }else{
            result=first/second;
            System.out.println("Sonuç : " + result);

        }
    }

    static void power() {
        System.out.print("Taban değeri giriniz :");
        int base = scan.nextInt();
        System.out.print("Üs değeri giriniz :");
        int exponent = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println("Sonuç : " + result);
    }

    static void factorial() {
        System.out.print("Sayı giriniz :");
        int n = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        System.out.println("Sonuç : " + result);
    }

    static void mod() {
        System.out.print("1.Sayı giriniz :");
        int n = scan.nextInt();
        System.out.print("2.Sayı giriniz :");
        int n2 = scan.nextInt();

        System.out.println("Sonuç : " + (n % n2));
    }

    static void square() {
        System.out.print("1.Sayı giriniz :");
        int n = scan.nextInt();

        double square = Math.sqrt(n);
        System.out.println("Cevap : " + square);
    }

    private static void derivation() {
        System.out.print("1.Sayı giriniz :");
        int n = scan.nextInt();
        System.out.print("2.Sayı giriniz :");
        int n2 = scan.nextInt();
        if ((n2 - 1) == 0) {
            System.out.println("Sonuç : " + (n * n2));
        } else {
            System.out.println("Sonuç : " + (n * n2) + "x^" + (n2 - 1));
        }
    }

    private static void Integral() {
        System.out.print("Alt Sayı giriniz :");
        double a = scan.nextInt();
        System.out.print("Üst Sayı giriniz :");
        double b = scan.nextInt();
        double result = ((b - a) / 6) * (a + 4 * ((a + b) / 2) + b);
        System.out.println("Sonuç : " + result);
    }

    private static void mutlak() {
        System.out.print("1.Sayı giriniz :");
        int n = scan.nextInt();
        if (n < 0) {
            n = Math.abs(n);
        }
        System.out.println("Cevap" + n);
    }

    public static void main(String[] args) {
        calculate();

    }

    private static void calculate() {
        int select = -1;
        String menu = "1- Toplama İşlemi\n" + "2- Çıkarma İşlemi\n" + "3- Çarpma İşlemi\n" + "4- Bölme işlemi\n"
                + "5- Üslü Sayı Hesaplama\n" + "6- Faktoriyel Hesaplama\n" + "7- Mod Alma\n" + "8- Karekök Alma\n"
                + "9- Türev Alma\n" + "10- İntegral Alma\n" + "11- Mutlak Değer Hesaplama\n" + "0- Çıkış Yap";

        while (select != 0) {
            System.out.println(menu);
            System.out.print("Lütfen bir işlem seçiniz : ");
            select = scan.nextInt();
            switch (select) {
                case 1:
                    plus();
                    break;
                case 2:
                    minus();
                    break;
                case 3:
                    times();
                    break;
                case 4:
                    divided();
                    break;
                case 5:
                    power();
                    break;
                case 6:
                    factorial();
                    break;
                case 7:
                    mod();
                    break;
                case 8:
                    square();
                    break;
                case 9:
                    derivation();
                    break;
                case 10:
                    Integral();
                    break;
                case 11:
                    mutlak();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");
                    break;
            }
        }

    }

}
