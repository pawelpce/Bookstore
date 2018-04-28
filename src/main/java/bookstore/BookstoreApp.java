package bookstore;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookstoreApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();

        int userInput = getPlayerInput(scanner);
        while (userInput >= 1 && userInput <= 3) {
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
                            .filter(year -> year.getYear() < 2010)
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
                        for (int i = 0; i < filteredBookList.size(); i++){
                            int id = i+1;
                            System.out.println(id + ". " + filteredBookList.get(i));
                        }
                        System.out.println("");
                    }
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
        System.out.println("4. End application");
    }

    private static int getPlayerInput(Scanner scanner) {
        int number = 0;
        boolean correctInput;
        do {
            try {
                correctInput = true;
                number = scanner.nextInt();
                while (number < 1 || number > 4) {
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