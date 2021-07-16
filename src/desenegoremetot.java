package src;

public class desenegoremetot {
    public static void main(String[] args) {
        desen(15);
    }

    static int desen(int a){
    while(a>0){
            System.out.print(" desen 2 "+a);
            a-=5;
            while(a<=0){
            System.out.print(" desen 1 "+a);
         desen(a+5);
       }
        }
       
       return a;
         
    }


}

