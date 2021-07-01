package src;

import java.util.Scanner;


public class ciftsayibulma {
    public static void main(String[] args) {
        int k;
        Scanner inp = new Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        k = inp.nextInt();
                
        int sum = 0;
        for(int i=1; i<=k; i++){
            if((i%3 == 0) && (i%4 == 0)){
             sum+=i;
}
        }
        System.out.println(sum);
        inp.close();
    }
}
