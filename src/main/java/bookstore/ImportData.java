package bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImportData {

    private static ImportData importData = null;

    private ImportData(){

    }

    public static ImportData getInstance() {

        if (importData == null) {
            importData = new ImportData();
        }
        return importData;
    }

    public List<Book> importBooks() {
        BufferedReader br;
        List<Book> books = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(
                    ClassLoader.getSystemResourceAsStream("books.csv")));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                Book book = createBook(attributes);
                books.add(book);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private Book createBook(String[] attributes) {
        return new Book(attributes[0], attributes[1], Integer.parseInt(attributes[2]), attributes[3],
                getAuthor(attributes[4]), getCategory(Integer.parseInt(attributes[5])));
    }

    private Category getCategory(int id) {

        List<Category> categories = CategoryData.getInstance().getAllCategories();

        return categories.stream().filter(category1 -> category1.getId() == id).findAny().get();
    }

    private List<Author> getAuthor(String authorsId) {

        String[] splittedAuthors = authorsId.split(",");
        List<Author> authors = new ArrayList<>();
        for (String author : splittedAuthors) {
            authors.add(AuthorFunctions.getAuthorById(Integer.parseInt(author)));
        }
        return authors;
    }


    public List<Author> importAuthors() {
        BufferedReader br;
        List<Author> authors = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(
                    ClassLoader.getSystemResourceAsStream("authors.csv")));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                Author author = createAuthor(attributes);
                authors.add(author);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authors;
    }

    private Author createAuthor(String[] attributes) {
        return new Author(Integer.parseInt(attributes[0]), attributes[1], Integer.parseInt(attributes[2]));
    }


    public List<Category> importCategories() {
        BufferedReader br;
        List<Category> categories = new ArrayList<>();
        try {
            br = new BufferedReader(new InputStreamReader(
                    ClassLoader.getSystemResourceAsStream("categories.csv")));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                Category category = createCategory(attributes);
                categories.add(category);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }

    private Category createCategory(String[] attributes) {
        return new Category(Integer.parseInt(attributes[0]), attributes[1], Integer.parseInt(attributes[2]));
    }

}