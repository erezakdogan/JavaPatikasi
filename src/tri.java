package src;
public class tri{
    public static void main(String[] args) {
        String str ="Hello     World";
        int a=3,b=9;
        String str1 = str.substring(0, str.length()).replaceAll(" ", "");
        String str2 = str1.substring(a, b);
        System.out.println(str2);
    }
}