

import java.util.Scanner;


public class yildizileucgen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("N sayısını giriniz :");
        int n = input.nextInt();
        input.close();

        for(int i=0; i<=n ; i++){
            for(int j=0; j < (n-i); j++){
                System.out.print(" ");
            }
            for(int k=1; k<=(2*i+1); k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
        
        for(int i=1; i<=n ; i++){
            for(int j=0; j < i; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=2*(n-i)+1; k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
