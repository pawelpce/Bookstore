package bookstore;

import java.util.ArrayList;
import java.util.List;

public class AuthorFunctions {

    public static Author getAuthorById(int id) {
        return AuthorData.getInstance().getAllAuthors().stream().filter(author -> author.getId() == id).findFirst().get();
    }

    public static int getAuthorsNumberOfBooks(Author author) {

        List<Author> authorsNumberOfBooks = new ArrayList<>();
        List<Book> bookList = BookData.getInstance().getAllBooks();

        int numberOfBooks = 0;
        for (Book book : bookList) {
            for (Author author1 : book.getAuthorList()) {
                if (author1.getId() == author.getId()) {
                    numberOfBooks++;
                }
            }
        }
        return numberOfBooks;

//
//        for (int i = 0; i < bookList.size(); i++) {
//            for (int y = 0; y < bookList.get(i).getAuthorList().size(); y++) {
//                if (bookList.get(i).getAuthorList().get(y).getName().equals(author.getName())) {
//                    authorsNumberOfBooks.add(author);
//                }
//            }
//        }
//        return authorsNumberOfBooks.size();
    }

    public static List<Book> getAuthorsListOfBooks(int id) {

        List<Book> authorsListOfBooks = new ArrayList<>();
        List<Book> bookList = BookData.getInstance().getAllBooks();

        for (Book book : bookList) {
            for (Author author1 : book.getAuthorList()) {
                if (author1.getId() == id) {
                    authorsListOfBooks.add(book);
                }
            }
        }
        return authorsListOfBooks;

    }
}
