package src;

public class fibonaccidizisi {
    public static void main(String[] args) {
        int n = 0;
       int  n2 = 1;
       int  t = 1;
        for(int i=2 ; i<=10; i++){
            System.out.println(n+"+"+n2 +"="+(t));
          n = n2;
          n2 = t;
          t = n+n2;
    }
}
}