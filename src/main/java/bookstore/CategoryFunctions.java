package bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryFunctions {

    public static int getCategoryNumberOfBooks(Category category) {

        List<Book> bookList = BookData.getInstance().getAllBooks();

        int numberOfBooks = 0;
        for (Book book : bookList) {
            if (book.getCategory().getId() == category.getId()) {
                numberOfBooks++;
            }
        }
        return numberOfBooks;
    }

    public static List<Book> getCategoryListOfBooks(int id) {

        List<Book> categoryListOfBooks = new ArrayList<>();
        List<Book> bookList = BookData.getInstance().getAllBooks();

        for (Book book : bookList) {
                if (book.getCategory().getId() == id) {
                    categoryListOfBooks.add(book);
                }
        }
        return categoryListOfBooks;

    }

    public static int addNewCategory(Scanner scanner, Scanner scanner1, List<Category> categoryList) {
        System.out.println("Set new category's name:");
        String newCategorysName = scanner1.nextLine();
        System.out.println("Set new category's priority (numbers 1-3):");
        int newCategorysPriority = scanner.nextInt();
        Category newCategory = new Category(categoryList.size() + 1, newCategorysName, newCategorysPriority);
        categoryList.add(newCategory);
        System.out.println("New category added.\n");

        return newCategory.getId();
    }

    public static Category getCategoryById(int id) {
        return CategoryData.getInstance().getAllCategories().stream().filter(category -> category.getId() == id).findFirst().get();
    }

    public static void deleteCategory(int id, List<Category> categoryList) {

        categoryList.get(id-1).setName(null);
        categoryList.get(id-1).setPriority(0);
        System.out.println("Category is deleted.\n");

    }
}