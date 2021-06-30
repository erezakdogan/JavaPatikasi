package src;

import java.util.Scanner;

public class kdvtutari {
    public static void main(String[] args) {
        double paraDergeri;
        double kdvliDeger;
        double kdvOrani = 0.18, indKdv = 0.08;
        
        boolean bindenBuyuk ;
        Scanner inp = new Scanner(System.in);
    
        System.out.println("Para değeri giriniz: ");
        paraDergeri = inp.nextInt();
        bindenBuyuk=(paraDergeri>1000);
        inp.close();
        kdvliDeger = (bindenBuyuk?paraDergeri*indKdv+paraDergeri:paraDergeri*kdvOrani+paraDergeri); 
        System.out.println(kdvliDeger);
        
    }
}
