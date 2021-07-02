package src;

import java.util.Scanner;

public class mukemmelsayi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m =scan.nextInt();
        scan.close();

        int sum = 0;
        for(int i =1; i<=m-1; i++){
            if(m%i==0){
                sum += i; 
            } 

        }
        if(sum==m){
            System.out.print(m+" Mükemmel sayıdır");
        }else{
            System.out.print(m+" Mükemmel sayı değildir");
        }
    }
}
