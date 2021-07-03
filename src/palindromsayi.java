package src;

public class palindromsayi {
    public static void main(String[] args) {
        System.out.println(isPalindrom(404));
    }

     static boolean isPalindrom(int i) {
         int temp = i, reverseNum=0, lastNum;
         for(int j=0; j<=i; j++){
             lastNum = temp%10;
             reverseNum = (reverseNum*10) + lastNum;
             temp/=10;

        if(reverseNum == i){
             return true;
         } 
       

    } return false;
}}

