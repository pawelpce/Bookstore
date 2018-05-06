package bookstore;

import java.util.List;

public class YearTitleIsbnBooksPrintStrategy implements BooksPrintStrategy {

    @Override
    public void printAllBooks(List<Book> allBooks) {

        for (Book book : allBooks) {
            System.out.println("YEAR: " + book.getYear() + " '" + book.getTitle() +
                    "' ISBN: " + book.getIsbn() +
                    " AUTHOR: " + book.getAuthorList() +
                    " COVER: " + book.getKindOfCover() +
                    " CATEGORY: " + book.getCategory());
        }
        System.out.println("");
    }
}