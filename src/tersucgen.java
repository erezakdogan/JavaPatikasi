
import java.util.Scanner;

public class tersucgen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bas =scanner.nextInt();
        scanner.close();

        for(int i = 1; i<=bas; i++){

            for(int j=1; j <= i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k<=2*(bas-i); k++){
                System.out.print("*");

            }
            System.out.println(" ");
        }
    }
}
