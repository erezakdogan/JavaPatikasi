package book;
import java.text.SimpleDateFormat;

public class Book implements Comparable{

   private String bookName, authorName;
   private int pageNum;
   private int date;
    SimpleDateFormat publishYear = new SimpleDateFormat();
    

    public Book(String bookName, String authorName, int pageNum, int date) {
      
        this.bookName = bookName;
        this.authorName = authorName;
        this.pageNum = pageNum;
        this.date = date;
    }
    
    
    

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPublishYear() {
        return this.date;
    }

    public void setPublishYear(int publishYear) {
        this.date = publishYear;
    }




    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
