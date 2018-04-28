package bookstore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookstoreApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();

        int userInput = getPlayerInput(scanner);
        while (userInput == 1 || userInput == 2) {
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
            }
        }
        System.out.println("Thank you for using our application.");
    }


    private static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Show contact");
        System.out.println("2. Show available books");
        System.out.println("3. End application");
    }

    private static int getPlayerInput(Scanner scanner) {
        int number = 0;
        boolean correctInput;
        do {
            try {
                correctInput = true;
                number = scanner.nextInt();
                while (number < 1 || number > 3) {
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