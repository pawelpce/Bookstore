package bookstore;

import java.util.List;

import static bookstore.Book.importBooks;

public class BookData {

    private static BookData bookData = null;
    private List<Book> books = importBooks();

    private BookData(){

    }

    public static BookData getInstance() {

        if (bookData == null) {
            bookData = new BookData();
        }
        return bookData;
    }

    public void printBooks() {

        for (int i = 0; i < books.size(); i++) {

            int id = i+1;

            System.out.println(id + ". " + books.get(i));
        }
        System.out.println("");
    }

}