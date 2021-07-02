package src;

import java.util.Scanner;

public class ebobekok {
    public static void main(String[] args) {
        int n1,n2;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Sayıyı giriniz : ");
        n1 = scan.nextInt();
        System.out.println("2.Sayıyı giriniz : ");
        n2 = scan.nextInt();
        scan.close();


        int i = n1;
        while(1<=i){
         if(n1 % i == 0 && n2 % i == 0){
        int ek = (n1*n2)/i;
          System.out.println(i+" "+ek);
          break;
            }
            i--;
        }

    }
}
