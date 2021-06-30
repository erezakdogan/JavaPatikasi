package src;

import java.util.Scanner;

public class taksimetre{
    public static void main(String[] args) {
        double kmU= 2.20, mesafe, ucret;
        int acılısU = 10;
        boolean min;
        
        Scanner olcer= new Scanner(System.in);
        System.out.print("Kaç km?"); 
        mesafe = olcer.nextDouble();
        olcer.close();

        
        min = (mesafe*kmU+acılısU<20);
        ucret =min?20:mesafe*kmU+acılısU;
        System.out.print("Tutar : "+ucret); 
    }
}