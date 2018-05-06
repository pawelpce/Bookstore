package bookstore;

import java.util.Comparator;
import java.util.List;
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

        List<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .collect(Collectors.toList());

        return sortedBooks;

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

    public Book returnTheFirstBook() {

        Book theFirst = books.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .findFirst()
                .get();

        return theFirst;

    }

    public Book returnTheLatestBook() {

        Book theLatest = books.stream()
                .sorted(Comparator.comparing(Book::getYear).reversed())
                .findFirst()
                .get();

        return theLatest;

    }

    public int sumOfYears() {
        return books.stream().mapToInt(value -> value.getYear()).sum();
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

    public double averageYearOfPublishedBooks() {

        double average = books.stream()
                .mapToDouble(Book::getYear).average().getAsDouble();

        return average;
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

        List<Book> filteredBookList = books.stream()
                .filter(book -> book.getTitle().startsWith("T"))
                .filter(book -> book.getYear() > 2009)
                .collect(Collectors.toList());

        return filteredBookList;
    }

    public List<Book> adding100YearsToAllBooks() {
        books.stream().forEach(book -> book.setYear(book.getYear() + 100));
        return books;

        /*List<Book> modifiedBooks = books;

        for (int i = 0; i < books.size(); i++){
            modifiedBooks.get(i).setYear(books.get(i).getYear() + 100);
        }

        return modifiedBooks;*/

    }

    public List<Book> booksWithPublishedYearDivisibleBy2() {

        List<Book> modifiedList = books.stream()
                .filter(book -> book.getYear() % 2 == 0)
                .collect(Collectors.toList());

        return modifiedList;

    }

    public List<Book> addToEveryTitleWordsFirstEdition() {

        books.stream().forEach(book -> book.setTitle(book.getTitle() + " FIRST EDITION"));

        return books;
    }

    public List<Book> booksPublishedAfter2003() {

        List<Book> filteredList = books.stream()
                .filter(book -> book.getYear() > 2003)
                .collect(Collectors.toList());

        return filteredList;

    }


    public void printModifiedList(List<Book> modifiedList, int userToStringFormat) {

        if (userToStringFormat == 0) {
            for (int i = 0; i < modifiedList.size(); i++) {
                int id = i + 1;
                System.out.println(id + ". " + modifiedList.get(i));
            }
            System.out.println("");
        } else if (userToStringFormat == 1) {
            for (int i = 0; i < modifiedList.size(); i++) {
                int id = i + 1;
                System.out.println(id + ". YEAR: " + modifiedList.get(i).getYear()
                                    + " '" + modifiedList.get(i).getTitle() +
                                     "' ISBN: " + modifiedList.get(i).getIsbn());
            }
            System.out.println("");
        } else if (userToStringFormat == 2) {
            for (int i = 0; i < modifiedList.size(); i++) {
                int id = i + 1;
                System.out.println(id + ". '" + modifiedList.get(i).getTitle()
                        + "' YEAR: " + modifiedList.get(i).getYear() +
                        " ISBN: " + modifiedList.get(i).getIsbn());
            }
            System.out.println("");
        } else {
            for (int i = 0; i < modifiedList.size(); i++) {
                int id = i + 1;
                System.out.println(id + ". ISBN: " + modifiedList.get(i).getIsbn()
                        + " '" + modifiedList.get(i).getTitle() +
                        "' YEAR: " + modifiedList.get(i).getYear());
            }
            System.out.println("");
        }
    }

}
