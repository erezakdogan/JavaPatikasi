import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class hesapmakinesi {
    public static void main(String[] args) {
        int num1,num2,type,sonuc;

        Scanner scan = new Scanner(System.in);
        System.out.print("1.Sayıyı giriniz : ");
        num1 = scan.nextInt();
        System.out.print("2.Sayıyı giriniz : ");
        num2 = scan.nextInt();
        System.out.println("İşlemi seçiniz \n1-Toplama \n2-Çıkarma \n3-Çarpma \n4-Bölme");
        type = scan.nextInt();
        scan.close();

        switch(type){
            
            case 1:
            sonuc = num1+num2;
            System.out.print(sonuc);
             break;

            case 2:
            sonuc = num1-num2;
            System.out.print(sonuc);
             break;

            case 3:
            sonuc= num1*num2;
            System.out.print(sonuc);
             break;

            case 4:
            if(num2==0){
                System.out.print("Bir sayı sıfıra bölünemez");
            }else{
                sonuc = num1/num2;
                System.out.print(sonuc);
            }
             break;

            default: 
            System.out.print("HATALI DEĞER GİRDİNİZ");
        }
    }
}