package src;

import java.util.Scanner;


public class dairealan {
    public static void main(String[] args) {
        int r, mAcı;
        double pi = 3.14, alan;
        

        Scanner inp = new Scanner(System.in);
        System.out.print("Yarıçap giriniz(cm) : ");
        r = inp.nextInt();
        System.out.print("Merkez açı ölçüsü giriniz : ");
        mAcı = inp.nextInt();

        alan = (pi*r*r*mAcı)/360;
        System.out.print("Dairenin alanı : "+ alan+"cm");

        
    }
}
