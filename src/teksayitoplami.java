package src;

import java.util.Scanner;

public class teksayitoplami {
    public static void main(String[] args) {
        int num;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        num = scanner.nextInt();


        int sum = 0;
        while(num%2 == 0){
            if(num%4 == 0){
                sum += num;  
                num = scanner.nextInt();
            } 
        } System.out.println(sum); 
        scanner.close();
    }
}
