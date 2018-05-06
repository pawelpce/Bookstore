package bookstore;

import java.util.List;

public class Book {

    private String title;
    private String isbn;
    private int year;
    private String kindOfCover;
    private List<Author> authorList;
    private Category category;


    public Book(String title, String isbn, int year, String kindOfCover, List<Author> authorList, Category category) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.kindOfCover = kindOfCover;
        this.authorList = authorList;
        this.category = category;
    }


    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getKindOfCover() {
        return kindOfCover;
    }

    public void setKindOfCover(String kindOfCover) {
        this.kindOfCover = kindOfCover;
    }

    @Override
    public String toString() {
        return "'" + title + "' ISBN: " + isbn +
                " YEAR: " + year +
                " AUTHOR: " + authorList +
                " COVER: " + kindOfCover +
                " CATEGORY: " + category;
    }
}
