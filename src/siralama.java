

import java.util.Arrays;
import java.util.Scanner;

public class siralama {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Dizinin boyutu n : ");
        int vol = scan.nextInt();
        System.out.println("Dizinin elemanlarını giriniz : ");
       
        int[] sort= new int[vol];
        for(int i = 0; i<vol; i++){
         System.out.print((i+1)+". Elemanı : ");  
         int obj = scan.nextInt();
         sort[i]=obj;
        }
        scan.close();
        Arrays.sort(sort);

        System.out.print("Sıralama : ");
        for(int i : sort){
            System.out.print(i+" ");
        }
      
    }
}
