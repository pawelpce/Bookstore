package bookstore;

import java.util.*;
import java.util.stream.Collectors;

public class BookstoreApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        BooksFunctions booksFunctions = new BooksFunctions();
        BooksPrintStrategy booksPrintStrategy = new TitleYearIsbnBooksPrintStrategy();
        List<Author> authorsList = AuthorData.getInstance().getAllAuthors();
        List<Book> bookList = BookData.getInstance().getAllBooks();
        List<Category> categoryList = CategoryData.getInstance().getAllCategories();

        printMenu();

        int userInput = getPlayerInput(scanner);
        int userToStringFormat;

        while (userInput >= 1 && userInput <= 24) {
            switch (userInput) {
                case 1:
                    System.out.println("Email: bookstore@gmail.com\n");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 2:
                    booksPrintStrategy.printAllBooks(bookList);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 3:
                    /*List<Book> bookList = BookData.getInstance().getAllBooks()
                            .stream()
                            .filter(year -> year.getYear() < 2000)
                            .collect(Collectors.toList());*/

                    List<Book> filteredBookList = new ArrayList<>();

                    for (int i = 0; i < bookList.size(); i++) {

                        if (bookList.get(i).getYear() < 2000) {
                            filteredBookList.add(bookList.get(i));
                        }
                    }

                    if (filteredBookList.isEmpty()) {
                        System.out.println("No books with these parameters\n");
                    } else {
                        booksPrintStrategy.printAllBooks(filteredBookList);
                    }
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 4:
                    List<Book> bookFromTheFirst = booksFunctions.sortBookListByYear();
                    booksPrintStrategy.printAllBooks(bookFromTheFirst);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 5:
                    List<Book> bookFromTheLatest = booksFunctions.sortBookListByYearFromTheLatest();
                    booksPrintStrategy.printAllBooks(bookFromTheLatest);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 6:
                    List<Book> booksAfter2003 = booksFunctions.booksPublishedAfter2003();
                    booksPrintStrategy.printAllBooks(booksAfter2003);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 7:
                    printPrintingWaysMenu();
                    userToStringFormat = scanner.nextInt();

                    switch (userToStringFormat) {
                        case 1:
                            booksPrintStrategy = new YearTitleIsbnBooksPrintStrategy();
                            break;
                        case 2:
                            booksPrintStrategy = new TitleYearIsbnBooksPrintStrategy();
                            break;
                        case 3:
                            booksPrintStrategy = new IsbnTitleYearBooksPrintStrategy();
                            break;
                        default:
                            booksPrintStrategy = new TitleYearIsbnBooksPrintStrategy();
                            break;
                    }

                    System.out.println("The way of printing books list has been changed\n");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 8:
                    categoryList.stream().forEach(category -> System.out.println(category));
                    System.out.println("");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 9:
                    List<Book> filteredBooks = bookList.stream()
                            .filter(book -> book.getCategory().getName().equals("Wzorce projektowe")).collect(Collectors.toList());
                    filteredBooks.stream().forEach(book -> System.out.println(book));
                    System.out.println("");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 10:
                    AuthorFunctions.addNewAuthor(scanner, scanner1, authorsList);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 11:
                    authorsList.stream().forEach(author -> System.out.println(author + " No. of books: "
                            + AuthorFunctions.getAuthorsNumberOfBooks(author)));
                    System.out.println("");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 12:
                    System.out.println("Type the title you would like to edit\n");
                    booksPrintStrategy.printAllBooks(bookList);
                    String userTitleToEdit = scanner1.nextLine();
                    Book bookToEdit;
                    try {
                        bookToEdit = bookList.stream().filter(book -> book.getTitle().equals(userTitleToEdit)).findFirst().get();
                        System.out.println("Edit the title: '" + bookToEdit.getTitle() + "'");
                        String booksNewTitle = scanner1.nextLine();
                        bookToEdit.setTitle(booksNewTitle);
                        System.out.println("You edited book title to: " + booksNewTitle + "\n");
                    } catch (NoSuchElementException e) {
                        System.out.println("No value present\n");
                    }
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 13:
                    ExportData.getInstance().saveAuthorsToFile(authorsList);
                    System.out.println("New list of authors has been saved to file\n");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 14:
                    ExportData.getInstance().saveBooksToFile(bookList);
                    System.out.println("New list of books has been saved to file\n");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 15:
                    ExportData.getInstance().saveCategoriesToFile(categoryList);
                    System.out.println("New list of books has been saved to file\n");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 16:
                    System.out.println("Type the id of the author you would like to edit:\n");
                    authorsList.stream().forEach(author -> System.out.println(author.getId() + ". " + author));
                    System.out.println("");
                    int userAuthorsAgeToEdit = scanner.nextInt();
                    Author authorsAgeToEdit;
                    try {
                        authorsAgeToEdit = authorsList.stream().filter(author -> author.getId() == userAuthorsAgeToEdit).findFirst().get();
                        System.out.println("Edit the age of author: " + authorsAgeToEdit.getName());
                        int authorsNewAge = scanner.nextInt();
                        authorsAgeToEdit.setAge(authorsNewAge);
                        System.out.println("You edited age of author " + authorsAgeToEdit.getName() + " to: " + authorsNewAge + "\n");
                    } catch (NoSuchElementException e) {
                        System.out.println("No value present\n");
                    }
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 17:
                    System.out.println("Type the id of the author:\n");
                    authorsList.stream().forEach(author -> System.out.println(author.getId() + ". " + author + " No. of books: " +
                            AuthorFunctions.getAuthorsNumberOfBooks(author)));
                    System.out.println("");
                    int userAuthorBooks = scanner.nextInt();
                    List<Book> filteredAuthorBooks = AuthorFunctions.getAuthorsListOfBooks(userAuthorBooks);
                    booksPrintStrategy.printAllBooks(filteredAuthorBooks);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 18:
                    CategoryFunctions.addNewCategory(scanner, scanner1, categoryList);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 19:
                    System.out.println("Type the id of the category:\n");
                    categoryList.stream().forEach(category -> System.out.println(category.getId() + ". " + category + " No. of books: " +
                            CategoryFunctions.getCategoryNumberOfBooks(category)));
                    System.out.println("");
                    int userCategoryBooks = scanner.nextInt();
                    List<Book> filteredCategoryBooks = CategoryFunctions.getCategoryListOfBooks(userCategoryBooks);
                    booksPrintStrategy.printAllBooks(filteredCategoryBooks);
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 20:
                    System.out.println("Type the id of the category you would like to edit:\n");
                    categoryList.stream().forEach(category -> System.out.println(category.getId() + ". " + category));
                    System.out.println("");
                    int userCategoryNameToEdit = scanner.nextInt();
                    Category categorysNameToEdit;
                    try {
                        categorysNameToEdit = categoryList.stream().filter(category -> category.getId() == userCategoryNameToEdit).findFirst().get();
                        System.out.println("Edit the name of category: " + categorysNameToEdit.getName());
                        String categorysNewName = scanner1.nextLine();
                        categorysNameToEdit.setName(categorysNewName);
                        System.out.println("You edited name of category to: " + categorysNewName + "\n");
                    } catch (NoSuchElementException e) {
                        System.out.println("No value present\n");
                    }
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 21:
                    ExportData.getInstance().saveAuthorsToFile(authorsList);
                    ExportData.getInstance().saveBooksToFile(bookList);
                    ExportData.getInstance().saveCategoriesToFile(categoryList);
                    System.out.println("All changes have been saved to files\n");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 22:
                    System.out.println("Set new book's title:");
                    String newBookTitle = scanner1.nextLine();
                    System.out.println("ISBN:");
                    String newBookIsbn = scanner1.nextLine();
                    System.out.println("Year:");
                    int newBookYear = scanner.nextInt();
                    System.out.println("Kind of cover - M for soft, T for hard:");
                    String newBookCover = scanner1.nextLine();

                    System.out.println("Type the id of existing author or 0 to add new.");
                    authorsList.stream().forEach(author -> System.out.println(author.getId() + ". " + author));
                    System.out.println("");

                    int authorId = scanner.nextInt();
                    List<Author> newBookAuthors = new ArrayList<>();
                    int newAuthorId;
                    Author newAuthor;
                    while (authorId != -1) {
                        if (authorId == 0) {
                            newAuthorId = AuthorFunctions.addNewAuthor(scanner, scanner1, authorsList);
                            newAuthor = AuthorFunctions.getAuthorById(newAuthorId);
                            newBookAuthors.add(newAuthor);
                        } else {
                            final int authorId2 = authorId;
                            newAuthor = authorsList.stream().filter(author -> author.getId() == authorId2).findFirst().get();
                            newBookAuthors.add(newAuthor);

                            /*for (Author author : authorsList) {
                                if (author.getId() == authorId) {
                                    newBookAuthors.add(author);
                                }
                            }*/
                        }
                        System.out.println("New author added. If you would like to add next, type the id of existing author or 0 to add new or -1 to end adding.");
                        authorId = scanner.nextInt();
                    }

                    System.out.println("Type the id of existing category or 0 to add new:");
                    categoryList.stream().forEach(category -> System.out.println(category.getId() + ". " + category + " No. of books: " +
                            CategoryFunctions.getCategoryNumberOfBooks(category)));
                    System.out.println("");
                    int categoryId = scanner.nextInt();
                    int newCategoryId;
                    Category newCategory;
                    if (categoryId == 0) {
                        newCategoryId = CategoryFunctions.addNewCategory(scanner, scanner1, categoryList);
                        newCategory = CategoryFunctions.getCategoryById(newCategoryId);
                    } else {
                        newCategory = categoryList.stream().filter(category -> category.getId() == categoryId).findFirst().get();
                    }

                    Book newBook = new Book(newBookTitle, newBookIsbn, newBookYear, newBookCover, newBookAuthors, newCategory);
                    bookList.add(newBook);
                    System.out.println("New book added.\n");
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 23:
                    System.out.println("Type the title of book you would like to order\n");
                    booksPrintStrategy.printAllBooks(bookList);
                    String bookToOrder = scanner1.nextLine();
                    Book newBookToOrder = bookList.stream().filter(book -> book.getTitle().equals(bookToOrder)).findAny().get();
                    OrderSender orderSender;

                    if (newBookToOrder.getKindOfCover().equals("M")){
                        orderSender = new SoftCoverOrderSender();
                    } else {
                        orderSender = new HardCoverOrderSender();
                    }

                    orderSender.makeOrder(newBookToOrder.getTitle());

                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
                case 24:
                    System.out.println("What would you like to delete:");
                    System.out.println("1. Author");
                    System.out.println("2. Category");
                    System.out.println("3. Book");
                    System.out.println("4. Back");
                    int userDeleteInput = scanner.nextInt();

                    if (userDeleteInput == 1) {
                        System.out.println("Type the id of the author you would like to delete:\n");
                        authorsList.stream().forEach(author -> System.out.println(author.getId() + ". " + author + " No. of books: " +
                                AuthorFunctions.getAuthorsNumberOfBooks(author)));
                        System.out.println("");
                        int authorToDelete = scanner.nextInt();
                        AuthorFunctions.deleteAuthor(authorToDelete, authorsList);
                    } else if (userDeleteInput == 2) {
                        System.out.println("Type the id of the category you would like to delete:\n");
                        categoryList.stream().forEach(category -> System.out.println(category.getId() + ". " + category));
                        System.out.println("");
                        int categoryToDelete = scanner.nextInt();
                        CategoryFunctions.deleteCategory(categoryToDelete, categoryList);
                    } else if (userDeleteInput == 3) {
                        System.out.println("Type the title of book you would like to order\n");
                        booksPrintStrategy.printAllBooks(bookList);
                        String bookToDelete = scanner1.nextLine();
                        BooksFunctions.deleteBook(bookToDelete, bookList);
                    } else {}
                    printMenu();
                    userInput = getPlayerInput(scanner);
                    break;
            }
        }
        System.out.println("Thank you for using our application.");
    }

    private static void printPrintingWaysMenu() {
        System.out.println("What format would you like to get lists of books?");
        System.out.println("1. Year, Title, Isbn");
        System.out.println("2. Title, Year, Isbn");
        System.out.println("3. Isbn, Title, Year");
    }


    private static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println(" 1. Show contact");
        System.out.println(" 2. Show available books");
        System.out.println(" 3. Show books published before 2000");
        System.out.println(" 4. Sort books from the first published");
        System.out.println(" 5. Sort books from the latest published");
        System.out.println(" 6. Show books published after 2003");
        System.out.println(" 7. Change way of showing books list");
        System.out.println(" 8. Show list of categories");
        System.out.println(" 9. Show all books from design patterns category");
        System.out.println("10. Add new author");
        System.out.println("11. Show list of authors");
        System.out.println("12. Edit book title");
        System.out.println("13. Save authors to file");
        System.out.println("14. Save books to file");
        System.out.println("15. Save categories to file");
        System.out.println("16. Edit age of chosen author");
        System.out.println("17. Show all books written by chosen author");
        System.out.println("18. Add new category");
        System.out.println("19. Show all books from chosen category");
        System.out.println("20. Edit category name");
        System.out.println("21. Save all changes to file");
        System.out.println("22. Add new book");
        System.out.println("23. Make new order");
        System.out.println("24. Delete book, author or category");
        System.out.println("25. End application");
    }

    private static int getPlayerInput(Scanner scanner) {
        int number = 0;
        boolean correctInput;
        do {
            try {
                correctInput = true;
                number = scanner.nextInt();
                while (number < 1 || number > 25) {
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