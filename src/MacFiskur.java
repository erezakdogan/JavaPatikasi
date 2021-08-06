import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MacFiskur {
    public static void main(String[] args) {
        System.out.println("Takim sayısı giriniz:");
       int sayi;
        Scanner scan = new Scanner(System.in);
       
        sayi = scan.nextInt();
       
         

        ArrayList<String> takim= new ArrayList<>();
        ArrayList<String> fiskur = new ArrayList<>();
       
      
      
        while(sayi>0){
        String tk= scan.next();
        takim.add(tk);
        sayi--;
        }

        if(takim.size()%2==1){
            takim.add("Bay");
        }
       
        
        Random random = new Random();
        ArrayList<Integer> checked = new ArrayList<>();
        
        
        for(int j=0; j<takim.size();j++){
            // int c = random.nextInt(takim.size());
            checked.add(j);
            for(int i = 0; i<takim.size();i++){
               String str = "";
               if(j==i){
                   continue;
               }else{
                   str += takim.get(j).toString()+" vs "+takim.get(i).toString();
                   fiskur.add(str);
               }
              
        }
        }
       
        for(int i= 0; i<(takim.size()-1)*2;i++){
            System.out.println("Raund "+(i+1));
            for(int j=0; j<(takim.size())/2;j++){
                int k = random.nextInt(fiskur.size());
                
               
                     System.out.println(fiskur.get(k));
                
            }
            System.out.println();
        }
        
       

        scan.close();
        
        
    }













}
