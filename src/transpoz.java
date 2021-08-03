 
import java.util.Scanner;

public class transpoz {
    public static void main(String[] args) {
      
    Scanner scan = new Scanner(System.in);
    int[][] original = new int[2][3];
    for(int k = 0; k<2;k++){
        for(int l = 0; l<3;l++){
             int obj = scan.nextInt();
             original[k][l]= obj;
        }
   
    }
    scan.close();
        

        System.out.println("Matris :");
        for(int i=0; i<original.length;i++){
            for(int j=0; j<original[i].length;j++){
                System.out.print(original[i][j]+" ");
            }
            System.out.println();
        }


        int[][] transpoz = new int[original[0].length][original.length];
       
        for(int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                transpoz[j][i] = original[i][j];
            }
        }

        System.out.println("Transpoz :");
        for(int i=0; i<transpoz.length;i++){
            for(int j=0; j<transpoz[i].length;j++){
                System.out.print(transpoz[i][j]+" ");

            }
            System.out.println();
        }
    }
}
