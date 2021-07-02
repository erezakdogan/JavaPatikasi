package src;

import java.util.Scanner;

public class harmoniktoplam{
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("N sayısını giriniz :");
    double n = input.nextInt();
    input.close();
    double result = 0;
   for(int i=1; i<= n ; i++){
       result += (1.0/i);
   }
    System.out.print(result);
}
}