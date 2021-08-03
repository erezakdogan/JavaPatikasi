 
import java.util.Scanner;


public class ucgenalan {
    public static void main(String[] args) {
        int a,b,c;
        double alan;
        Scanner kenar = new Scanner(System.in);
        System.out.print("1.Kenarı giriniz: ");
        a = kenar.nextInt();
        System.out.print("2.Kenarı giriniz: ");
        b = kenar.nextInt();
        System.out.print("3.Kenarı giriniz: ");
        c = kenar.nextInt();
        kenar.close();

        
        int u = (a+b+c)/2;
        alan = (u*(u-a)  *(u-b)*(u-c));
        System.out.print(Math.sqrt(alan));

    }
}
