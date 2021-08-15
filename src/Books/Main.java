package Books;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
    Map<String, String> titleAut = new TreeMap<String, String>();
    ArrayList<Book> bList = new ArrayList<>();
    // Calendar c1 = Calendar.getInstance();    
    Book book = new Book( "title1", "author1", 105, new Date());
    Book book2 = new Book("title2", "author2",15, new Date());
    Book book3 = new Book("title3", "author3", 25, new Date());
    Book book4 = new Book("title4", "author4", 135, new Date());
    Book book5 = new Book("title5", "author5", 45, new Date());
    Book book6 = new Book("title6", "author6", 155, new Date());
    Book book7 = new Book("title7", "author7", 65, new Date());
    Book book8 = new Book("title8", "author8", 175, new Date());
    Book book9 = new Book("title9", "author9", 85, new Date());
    Book book10 =new Book("title0", "author0",95, new Date());

    bList.add(book);
    bList.add(book2);
    bList.add(book3);
    bList.add(book4);
    bList.add(book5);
    bList.add(book6);
    bList.add(book7);
    bList.add(book8);
    bList.add(book9);
    bList.add(book10);


    System.out.println("Books that page number bigger than 100");
    bList.stream().filter((i -> i.getPageNum()>100)).forEach(i-> 
    {
        System.out.println(i.getTitle());
    });
    System.out.println("--------------------------------------");

    bList.stream().forEach(i -> titleAut.put(i.getTitle(), i.getAuthor()));
    titleAut.keySet().stream().forEach( i->System.out.println("Title: " + i + " Author: " + titleAut.get(i)));
    
    }
}
