package book;

import java.util.Set;
import java.util.TreeSet;


public class bookmain {
   static Set<String> name = new TreeSet<>(); 
   static Set<Integer> page = new TreeSet<>(); 

    public static void main(String[] args) {
    Book book1= new Book("bookName1", "authorName1", 199 , 1993 );
    Book book2 = new Book("cookName2", "authorName2", 299 , 2000 );
    Book book3 = new Book("dookName3", "authorName3", 399 , 1870 );
    Book book4 = new Book("fookName4", "authorName4", 499 , 370 );
    Book book5 = new Book("gookName5", "authorName5", 599 , 1560 );

    
        name.add(book1.getBookName());
        name.add(book2.getBookName());
        name.add(book3.getBookName());
        name.add(book4.getBookName());
        name.add(book5.getBookName());
        
        

        page.add(book1.getPageNum());
        page.add(book2.getPageNum());
        page.add(book3.getPageNum());
        page.add(book4.getPageNum());
        page.add(book5.getPageNum());
        
      
print();
    }
  public static void print(){
        for(String s : name){
            System.out.println(s);
        }
        
        for(int s : page){ 
            System.out.println(s);
        }
    }
}
