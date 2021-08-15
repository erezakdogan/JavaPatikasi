package Books;

import java.util.Date;

public class Book {
    private String title,author;
    private int pageNum;
    private Date publish;

    public Book(String title, String author, int pageNum, Date publish) {
        this.title = title;
        this.author = author;
        this.pageNum = pageNum;
        this.publish = publish;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Date getPublish() {
        return this.publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }

}
