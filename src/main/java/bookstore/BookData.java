package bookstore;

import java.util.List;

public class BookData {

    private static BookData bookData = null;
    private List<Book> bookList = ImportData.getInstance().importBooks();

    private BookData(){

    }

    public static BookData getInstance() {

        if (bookData == null) {
            bookData = new BookData();
        }
        return bookData;
    }


    public List<Book> getAllBooks() {
        return bookList;
    }

    public void setBooks(List<Book> bookList) {
        this.bookList = bookList;
    }
}