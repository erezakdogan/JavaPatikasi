package src;

import java.util.Arrays;

public class freq {
    public static void main(String[] args) {
        int[] serial = {10, 20, 20,10, 10, 20, 5, 20,9,77,8};
        boolean[] bol = new boolean[serial.length];
        Arrays.fill(bol, false);






System.out.println("Tekrar Sayıları");
        for(int i = 0; i<serial.length;i++){ 
            if(bol[i]==true){
                continue;
            }
            int start = 0;
           
            for(int j=0; j<serial.length;j++){
                if(serial[i]==serial[j]){
                  start++;
                  bol[j]= true;
         
                }
            }
        System.out.println(serial[i]+" sayısı "+start+" kere tekrarladı.");
        }

        
        
        
    }
}
