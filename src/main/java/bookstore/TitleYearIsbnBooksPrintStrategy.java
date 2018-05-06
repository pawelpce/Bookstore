package bookstore;

import java.util.List;

public class TitleYearIsbnBooksPrintStrategy implements BooksPrintStrategy {
    @Override
    public void printAllBooks(List<Book> allBooks) {

        for (Book book : allBooks) {
            System.out.println("'" + book.getTitle() + "' YEAR: " + book.getYear() +
                    " ISBN: " + book.getIsbn() +
                    " AUTHOR: " + book.getAuthorList() +
                    " COVER: " + book.getKindOfCover() +
                    " CATEGORY: " + book.getCategory());
        }
        System.out.println("");
    }
}