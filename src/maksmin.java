package src;

import java.util.Arrays;
import java.util.Scanner;

public class maksmin {
    public static void main(String[] args) {
        int[] list = {15,12,788,1,-1,-778,2,0};
        Scanner scan = new Scanner(System.in);
        int giris = scan.nextInt();
        scan.close();

        Arrays.sort(list);
        int min = list[0];
        int max = list[list.length-1];

        for(int i : list){
            if(i<giris && i>min){
                min = i;
            }
            if(i>giris && i<max){
                max= i;
            }

        } 
        System.out.print(min+" ");
        System.out.print(max+" ");

    }
}
