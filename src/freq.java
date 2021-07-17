package src;


public class freq {
    public static void main(String[] args) {
        int[] serial = {10, 20, 20,10, 10, 20, 5, 20,9,77,8};
        int[] rep = new int[serial.length];
        
        for(int i = 0; i<serial.length;i++){        
            int start = 1;
           
            for(int j=0; j<serial.length;j++){
                if(serial[i]==serial[j]){
                  rep[i] = start++;
         
                }
            }
 
        }

        
        for(int k : rep){
            System.out.print(k+" ");
        }
    }
}
