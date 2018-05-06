package bookstore;

import java.util.ArrayList;
import java.util.List;

public class CategoryFunctions {

    public static int getCategoryNumberOfBooks(Category category) {

        List<Book> bookList = BookData.getInstance().getAllBooks();

        int numberOfBooks = 0;
        for (Book book : bookList) {
            if (book.getCategory().getId() == category.getId()) {
                numberOfBooks++;
            }
        }
        return numberOfBooks;
    }

    public static List<Book> getCategoryListOfBooks(int id) {

        List<Book> categoryListOfBooks = new ArrayList<>();
        List<Book> bookList = BookData.getInstance().getAllBooks();

        for (Book book : bookList) {
                if (book.getCategory().getId() == id) {
                    categoryListOfBooks.add(book);
                }
        }
        return categoryListOfBooks;

    }

}
