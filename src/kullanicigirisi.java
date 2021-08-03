

import java.util.Scanner;

public class kullanicigirisi {
    public static void main(String[] args) {
        String userName,password,newPass;
        int decision;

        Scanner scan = new Scanner(System.in);
        System.out.print("Kullanıcı adınızı giriniz : ");
        userName = scan.nextLine();
        System.out.print("Şifrenizi giriniz : ");
        password = scan.nextLine();
        // System.out.println("İşlemi seçiniz \n1-Toplama \n2-Çıkarma \n3-Çarpma \n4-Bölme");
        // type = scan.nextInt();

        if(userName.equals("Patika")&&password.equals("password123")){
            System.out.print("Bilgiler doğrulandı giriş yapıldı ");

        }else if(!userName.equals("Patika") && !password.equals("password123")){
            System.out.println("Bilgiler doğrulanmadı giriş başarısız ");
        }
        else if(!userName.equals("Patika")){
            System.out.println("Bilgiler doğrulanmadı giriş başarısız \nKullanıcı adı yanlış ");
        }
        else{
            System.out.println("Bilgiler doğrulanmadı giriş başarısız \nŞifre yanlış\n Yeni şifre oluşturmak ister misiniz? \n1-Evet \n2-Hayır");
            decision = scan.nextInt();

            switch(decision){
                case 1:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Yeni şifrenizi giriniz : ");
            
                newPass = scanner.nextLine();
                if(newPass.equals("password123")){
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                } else{
                    System.out.println("Şifre oluşturuldu");           
                     } scanner.close();
                break;

                case 2:
                System.out.println("Şifre oluşturulmadı");
                break;
            }
            scan.close();

        }

    }
}
