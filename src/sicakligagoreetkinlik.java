

import java.util.Scanner;


public class sicakligagoreetkinlik {
    public static void main(String[] args) {
        int heat;

        Scanner scan = new Scanner(System.in);
        System.out.println("Sıcaklık giriniz : ");
        heat = scan.nextInt();
        scan.close();
        if(heat<5){
            System.out.println("Kayak yapabilirsiniz");

        } else if(5<=heat && heat <=25){
          
            if(heat<=15){
            System.out.println("Sinemaya gidebilirsiniz");
            }
             if(10<=heat){
            System.out.println("Pikniğe gidebilirsiniz");
         }
        }
            else if(25<heat){
            System.out.print("Yüzmeye gidebilirsiniz");
        }
    }
}
