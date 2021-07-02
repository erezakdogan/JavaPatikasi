package src;

import java.util.Scanner;

public class artikyil{
public static void main(String[] args) {
    int year;
    final boolean artikyil;
    Scanner scan = new Scanner(System.in);
    System.out.println("Bir yıl giriniz : ");
    year = scan.nextInt();
    scan.close();

    if(year%100 == 0){
        artikyil = (year%400 == 0);
        System.out.print(artikyil?year+" bir artık yıldır !" : year+" bir artık yıldır değildir !");
    } else if(year%4 == 0){
        System.out.print(year+" bir artık yıldır !" );
    } else{
        System.out.print( year+" bir artık yıldır değildir !");

    }
}
}