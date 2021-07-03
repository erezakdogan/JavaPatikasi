package src;

import java.util.Scanner;

public class recursiveus{
    static int power(int a,int b) {
    //    int result = 1;
       if(b !=0){
           return a*(power(a,b-1));
       }
        return 1;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("1.Sayıyı giriniz : ");
      int  num1 = scan.nextInt();
        System.out.print("2.Sayıyı giriniz : ");
      int  num2 = scan.nextInt();
        System.out.println(power(num1,num2));
        scan.close();
    }
}
