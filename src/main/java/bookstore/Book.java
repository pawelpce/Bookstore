package bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Book {

    private String title;
    private int isbn;
    private int year;


    public Book(String title, int isbn, int year) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

    public static List<Book> importBooks() {
        BufferedReader br;
        List<Book> books = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(
                    ClassLoader.getSystemResourceAsStream("books.csv")));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                Book book = createBook(attributes);
                books.add(book);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private static Book createBook(String[] attributes) {
        return new Book(attributes[0], Integer.parseInt(attributes[1]), Integer.parseInt(attributes[2]));
    }


    public String getTitle() {
        return title;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return title + "'" + " ISBN: " + isbn + " YEAR: " + year;
    }
}
