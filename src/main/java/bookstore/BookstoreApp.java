package bookstore;

import java.util.*;
import java.util.stream.Collectors;

public class BookstoreApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BooksFunctions booksFunctions = new BooksFunctions();
        printMenu();

        int userInput = getPlayerInput(scanner);
        while (userInput >= 1 && userInput <= 6) {
            switch (userInput) {
                case 1:
                    System.out.println("Email: bookstore@gmail.com\n");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 2:
                    BookData.getInstance().printBooks();
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 3:
                    /*List<Book> bookList = BookData.getInstance().getAllBooks()
                            .stream()
                            .filter(year -> year.getYear() < 2000)
                            .collect(Collectors.toList());*/

                    List<Book> bookList = BookData.getInstance().getAllBooks();
                    List<Book> filteredBookList = new ArrayList<>();

                    for (int i = 0; i < bookList.size(); i++){

                        if (bookList.get(i).getYear() < 2000){
                            filteredBookList.add(bookList.get(i));
                        }
                    }

                    if (filteredBookList.isEmpty()){
                        System.out.println("No books with these parameters\n");
                    } else {
                        booksFunctions.printModifiedList(filteredBookList);
                    }
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 4:
                    List<Book> bookFromTheFirst = booksFunctions.sortBookListByYear();
                    booksFunctions.printModifiedList(bookFromTheFirst);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 5:
                    List<Book> bookFromTheLatest = booksFunctions.sortBookListByYearFromTheLatest();
                    booksFunctions.printModifiedList(bookFromTheLatest);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 6:
                    List<Book> booksAfter2003 = booksFunctions.booksPublishedAfter2003();
                    booksFunctions.printModifiedList(booksAfter2003);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;

            }
        }
        System.out.println("Thank you for using our application.");
    }


    private static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Show contact");
        System.out.println("2. Show available books");
        System.out.println("3. Show books published before 2000");
        System.out.println("4. Sort books from the first published");
        System.out.println("5. Sort books from the latest published");
        System.out.println("6. Show books published after 2003");
        System.out.println("7. End application");
    }

    private static int getPlayerInput(Scanner scanner) {
        int number = 0;
        boolean correctInput;
        do {
            try {
                correctInput = true;
                number = scanner.nextInt();
                while (number < 1 || number > 7) {
                    System.out.println("Bad argument. Try again.");
                    number = scanner.nextInt();
                }
            } catch (InputMismatchException e) {
                scanner.next();
                correctInput = false;
                System.out.println("Bad Argument. Try Again.");
            }
        } while (!correctInput);

        return number;
    }

}