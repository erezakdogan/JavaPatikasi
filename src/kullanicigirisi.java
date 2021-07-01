package src;

import java.util.Scanner;

public class kullanicigirisi {
    public static void main(String[] args) {
        String userName,password;

        Scanner scan = new Scanner(System.in);
        System.out.print("Kullanıcı adınızı giriniz : ");
        userName = scan.nextLine();
        System.out.print("Şifrenizi giriniz : ");
        password = scan.nextLine();
        // System.out.println("İşlemi seçiniz \n1-Toplama \n2-Çıkarma \n3-Çarpma \n4-Bölme");
        // type = scan.nextInt();
        scan.close();

        if(userName.equals("Patika")&&password.equals("password123")){
            System.out.print("Bilgiler doğrulandı giriş yapıldı ");

        }else if(!userName.equals("Patika") && !password.equals("password123")){
            System.out.println("Bilgiler doğrulanmadı giriş başarısız ");
        }
        else if(!userName.equals("Patika")){
            System.out.println("Bilgiler doğrulanmadı giriş başarısız \nKullanıcı adı yanlış ");
        }
        else{
            System.out.println("Bilgiler doğrulanmadı giriş başarısız \nŞifre adı yanlış ");

        }

    }
}
