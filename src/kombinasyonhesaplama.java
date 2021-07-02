package src;

import java.util.Scanner;

public class kombinasyonhesaplama {
    public static void main(String[] args) {
        int n,c;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("1.Sayıyı giriniz : ");
        n = scan.nextInt();
        System.out.println("2.Sayıyı giriniz : ");
        c = scan.nextInt();
        scan.close();
        int factorialN = 1;
        for(int i =1; i<=n; i++){
            factorialN = factorialN*i;
        }
        int factorialC = 1;
        for(int i =1; i<=c; i++){
            factorialC = factorialC*i;
        }

        int b = (n-c);
        int factorialB = 1;
        for(int i =1; i<=b; i++){
            factorialB = factorialB*i;
        }

        int com = factorialN/(factorialC*(factorialB));
        System.out.println(com);
    }
}
