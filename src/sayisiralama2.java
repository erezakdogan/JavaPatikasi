

import java.util.Scanner;


public class sayisiralama2 {
    public static void main(String[] args) {
   
   
      Scanner scanner = new Scanner(System.in);
      System.out.print("Kaç Sayı : ");
      int  n = scanner.nextInt();

   
   int large = 0;
   int small = 0;
   int i = 1;
   do{

      
      System.out.print(i+".Sayı : ");
      int a = scanner.nextInt();
      if( a <= small){        
      small = a;
      }
      else if(a >= large){
      large = a;
      }

            
               
            
      i++;
   }while(i<=n);

   
   System.out.println("En küçük sayı: " + small);
   System.out.print("En büyük sayı: "+ large);
   scanner.close();
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   


}}
