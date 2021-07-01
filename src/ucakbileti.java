package src;

import java.util.Scanner;


public class ucakbileti {
    public static void main(String[] args) {
        int km, age, type;
        double kmU= 0.1, disC12 = 0.5, disC24 = 0.1, disC65 = 0.3, disCtype2=0.2, disP;
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Mesafeyi km türünden giriniz : ");
        km = scan.nextInt();
        System.out.println("Yaşınızı giriniz : ");
        age = scan.nextInt();
        System.out.println("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): ");
        type = scan.nextInt();
        scan.close();

        

        double price = km*kmU;

        if(km<0 || age<0|| (type<0 || type>2)){
            System.out.println("Hatalı Veri Girdiniz !");
        }else if(age<12){
             disP =price - price*disC12;
            if(type==2){
                double tot =disP - disP*disCtype2; 
                System.out.print("Toplam Tutar = "+ tot*2+ " TL");
            } else {
                System.out.print("Toplam Tutar = "+ disP+ " TL");                   
            } 
        }else if(12<=age && age <=24){
            disP = price - price*disC24;
            if(type==2){
                double tot =disP - disP*disCtype2; 
                System.out.print("Toplam Tutar = "+ tot*2+ " TL");
            } else {
                System.out.print("Toplam Tutar = "+ disP+ " TL");                   
            } 
         }else if(65<age ){
            disP = price - price*disC65;
            if(type==2){
                double tot =disP - disP*disCtype2; 
                System.out.print("Toplam Tutar = "+ tot*2+ " TL");
            } else {
                System.out.print("Toplam Tutar = "+ disP+ " TL");                   
            } 
         } else{
            if(type==2){
                double tot =price -  price*disCtype2; 
                System.out.print("Toplam Tutar = "+ tot*2+ " TL");
            } else {
                System.out.print("Toplam Tutar = "+ price+ " TL");                   
            } 
            
         }
    }
}
