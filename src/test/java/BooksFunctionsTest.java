import bookstore.Book;
import bookstore.BooksFunctions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BooksFunctionsTest {

    private BooksFunctions booksFunctions = new BooksFunctions();

    private List<Book> books = new ArrayList<>();

    @Before
/*    public void init() {
        books.add(new Book("Clean Code", "0132350882", 2008));
        books.add(new Book("Effective Java (3rd Edition)", "0134685997", 2018));
        books.add(new Book("Test Driven Development", "0321146530", 2003));
        books.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
        books.add(new Book("Head First Design Patterns", "0596007124", 2004));
        books.add(new Book("Clean Architecture", "0134494164", 2017));
    }*/

    @Test
    public void getBookByIsbn() {

        assertEquals("Head First Design Patterns", booksFunctions.getBookByIsbn("596007124").getTitle());

    }

    @Test
    public void sortBooksByYear() {


        assertEquals(2002, booksFunctions.sortBookListByYear().get(0).getYear());
        assertEquals(2003, booksFunctions.sortBookListByYear().get(1).getYear());
        assertEquals(2004, booksFunctions.sortBookListByYear().get(2).getYear());
        assertEquals(2008, booksFunctions.sortBookListByYear().get(3).getYear());
        assertEquals(2017, booksFunctions.sortBookListByYear().get(4).getYear());
        assertEquals(2018, booksFunctions.sortBookListByYear().get(5).getYear());

    }

    @Test
    public void sortBooksByYearFromTheLatest() {


        assertEquals(2002, booksFunctions.sortBookListByYearFromTheLatest().get(5).getYear());
        assertEquals(2003, booksFunctions.sortBookListByYearFromTheLatest().get(4).getYear());
        assertEquals(2004, booksFunctions.sortBookListByYearFromTheLatest().get(3).getYear());
        assertEquals(2008, booksFunctions.sortBookListByYearFromTheLatest().get(2).getYear());
        assertEquals(2017, booksFunctions.sortBookListByYearFromTheLatest().get(1).getYear());
        assertEquals(2018, booksFunctions.sortBookListByYearFromTheLatest().get(0).getYear());

    }

    @Test
    public void getLastTwoBooks() {

        assertEquals("Effective Java (3rd Edition)", booksFunctions.getLastTwoBooks().get(1).getTitle());
        assertEquals("Clean Architecture", booksFunctions.getLastTwoBooks().get(0).getTitle());

    }

    @Test
    public void getTheLatestBook() {

        assertEquals("Effective Java (3rd Edition)", booksFunctions.returnTheLatestBook().get().getTitle());

    }

    @Test
    public void getTheFirstBook() {

        assertEquals("Patterns of Enterprise Application Architecture", booksFunctions.returnTheFirstBook().get().getTitle());

    }

    @Test
    public void getTheSumOfPublishedYears() {

        assertEquals(12052, booksFunctions.sumOfYears());

    }

    @Test
    public void getNumberOfBooksPublishedAfter2007() {

        assertEquals(3, booksFunctions.numberOfBooksPublishedAfter2007());

    }

    @Test
    public void getInformationIfAllBooksWerePublishedAfter2000() {

        assertEquals(true, booksFunctions.doAllBooksPublishedAfter2000());

    }

    @Test
    public void findAverageOfEveryPublishedYear() {

        assertEquals(12052 / 6, booksFunctions.averageYearOfPublishedBooks().getAsDouble(), 0.7);

    }

    @Test
    public void getInformationIfAnyOfBooksWerePublishedBefore2000() {

        assertEquals(false, booksFunctions.doAnyOfBooksPublishedBefore2000());

    }

    @Test
    public void getBooksPublishedAfter2009AndStartedWithT() {

        assertEquals(0, booksFunctions.booksStartedWithTAndPublishedAfter2009().size());

    }

    @Test
    public void adding100YearsToAllBooks() {

        List<Book> list = booksFunctions.adding100YearsToAllBooks();

        assertEquals(2108, list.get(0).getYear());
        assertEquals(2118, list.get(1).getYear());
        assertEquals(2103, list.get(2).getYear());
        assertEquals(2102, list.get(3).getYear());
        assertEquals(2104, list.get(4).getYear());
        assertEquals(2117, list.get(5).getYear());

    }

    @Test
    public void checkBooksWithPublishedYearDivisibleBy2() {

        assertEquals(4, booksFunctions.booksWithPublishedYearDivisibleBy2().size());

    }

    @Test
    public void checkAddingWords() {

        assertEquals("Clean Code FIRST EDITION", booksFunctions.addToEveryTitleWordsFirstEdition().get(0).getTitle());

    }

}