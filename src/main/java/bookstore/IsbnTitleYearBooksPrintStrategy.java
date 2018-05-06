package bookstore;

import java.util.List;

public class IsbnTitleYearBooksPrintStrategy implements BooksPrintStrategy {

    @Override
    public void printAllBooks(List<Book> allBooks) {

        for (Book book : allBooks) {
            System.out.println("ISBN: " + book.getIsbn() + " '" + book.getTitle() +
                    "' YEAR: " + book.getYear() +
                    " AUTHOR: " + book.getAuthorList() +
                    " COVER: " + book.getKindOfCover() +
                    " CATEGORY: " + book.getCategory());
        }
        System.out.println("");
    }
}
