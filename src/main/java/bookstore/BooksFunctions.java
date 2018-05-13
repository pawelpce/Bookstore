package bookstore;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BooksFunctions {

    private List<Book> books = BookData.getInstance().getAllBooks();

    public Book getBookByIsbn(String isbn) {

        List<Book> filteredBooks;
        Book bookWithGivenIsbn;

        filteredBooks = books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .collect(Collectors.toList());

        bookWithGivenIsbn = filteredBooks.get(0);

        return bookWithGivenIsbn;
    }

    public List<Book> sortBookListByYear() {

        return books.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .collect(Collectors.toList());

    }

    public List<Book> getLastTwoBooks() {

        List<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .collect(Collectors.toList());

        sortedBooks = sortedBooks.subList(sortedBooks.size() - 2, sortedBooks.size());
        return sortedBooks;
    }

    public List<Book> sortBookListByYearFromTheLatest() {

        return books.stream()
                .sorted(Comparator.comparing(Book::getYear).reversed())
                .collect(Collectors.toList());

    }

    public Optional<Book> returnTheFirstBook() {

        return books.stream().min(Comparator.comparing(Book::getYear));

    }

    public Optional<Book> returnTheLatestBook() {

        return books.stream().max(Comparator.comparing(Book::getYear));

    }

    public int sumOfYears() {
        return books.stream().mapToInt(Book::getYear).sum();
//        int sum = 0;
//
//        for (int i = 0; i < books.size(); i++){
//
//            sum = sum + books.get(i).getYear();
//
//        }
//        return sum;
    }

    public int numberOfBooksPublishedAfter2007() {

        List<Book> sortedList = books.stream()
                .filter(book -> book.getYear() > 2007)
                .collect(Collectors.toList());

        return sortedList.size();

    }

    public boolean doAllBooksPublishedAfter2000() {

        List<Book> filteredList = books.stream()
                .filter(book -> book.getYear() > 2000)
                .collect(Collectors.toList());

        return books.size() == filteredList.size();
    }

    public OptionalDouble averageYearOfPublishedBooks() {

        return books.stream()
                .mapToDouble(Book::getYear).average();
    }

    public boolean doAnyOfBooksPublishedBefore2000() {

        return books.stream().anyMatch(book -> book.getYear() < 2000);
//
//        List<Book> filteredList = books.stream()
//                .filter(book -> book.getYear() < 2000)
//                .collect(Collectors.toList());
//
//        return filteredList.size() > 0;
    }

    public List<Book> booksStartedWithTAndPublishedAfter2009() {

        return books.stream()
                .filter(book -> book.getTitle().startsWith("T"))
                .filter(book -> book.getYear() > 2009)
                .collect(Collectors.toList());

    }

    public List<Book> adding100YearsToAllBooks() {
        books.forEach(book -> book.setYear(book.getYear() + 100));
        return books;

        /*List<Book> modifiedBooks = books;

        for (int i = 0; i < books.size(); i++){
            modifiedBooks.get(i).setYear(books.get(i).getYear() + 100);
        }

        return modifiedBooks;*/

    }

    public List<Book> booksWithPublishedYearDivisibleBy2() {

        return books.stream()
                .filter(book -> book.getYear() % 2 == 0)
                .collect(Collectors.toList());

    }

    public List<Book> addToEveryTitleWordsFirstEdition() {

        books.forEach(book -> book.setTitle(book.getTitle() + " FIRST EDITION"));

        return books;
    }

    public List<Book> booksPublishedAfter2003() {

        return books.stream()
                .filter(book -> book.getYear() > 2003)
                .collect(Collectors.toList());

    }

    public static void deleteBook(String title, List<Book> bookList) {

        Optional<Book> optionalBook = bookList.stream().filter(book -> book.getTitle().equals(title)).findAny();
        if (optionalBook.isPresent()) {
            Book bookToDelete = optionalBook.get();
            bookList.remove(bookToDelete);
            System.out.println("Book is deleted.\n");
        } else {
            System.out.println("Bad argument");
        }

    }
}