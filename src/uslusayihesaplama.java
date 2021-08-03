

import java.util.Scanner;

public class uslusayihesaplama {
    public static void main(String[] args) {
        int n,c;
        
         Scanner scan = new Scanner(System.in);
         System.out.println("Sayıyı giriniz : ");
         n = scan.nextInt();
        System.out.println("Üssü giriniz : ");
         c = scan.nextInt();
         scan.close();

     if(c==0){
        System.out.print("1");
     } else{
        int a= 1;
         for(int i=1; i<=c; i++){
             a *=n;
        }
        System.out.println(a);

     }

        
    
    }
}
