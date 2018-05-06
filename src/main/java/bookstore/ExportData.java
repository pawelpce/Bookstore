package bookstore;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ExportData {

    private static ExportData exportData = null;

    private ExportData() {

    }

    public static ExportData getInstance() {

        if (exportData == null) {
            exportData = new ExportData();
        }
        return exportData;
    }

    public void saveAuthorsToFile(List<Author> authorList) {

        File file = new File("src\\main\\resources\\authors.csv");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Author author : authorList) {
                bufferedWriter.write(Integer.toString(author.getId()) + ";" + author.getName() + ";" + Integer.toString(author.getAge()));
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n");
        } catch (IOException e) {
            System.out.println("Unexpected error\n");
        }
    }

    public void saveCategoriesToFile(List<Category> categoryList) {

        File file = new File("src\\main\\resources\\categories.csv");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Category category : categoryList) {
                bufferedWriter.write(Integer.toString(category.getId()) + ";" + category.getName() + ";" + Integer.toString(category.getPriority()));
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n");
        } catch (IOException e) {
            System.out.println("Unexpected error\n");
        }
    }

    public void saveBooksToFile(List<Book> bookList) {

        File file = new File("src\\main\\resources\\books.csv");


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            for (Book book : bookList) {
                bufferedWriter.write(book.getTitle() + ";" + book.getIsbn() + ";" + book.getYear() + ";" + book.getKindOfCover() + ";"
                        + getAuthorsId(book.getAuthorList()) + ";" + book.getCategory().getId());
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n");
        } catch (IOException e) {
            System.out.println("Unexpected error\n");
        }
    }


    public String getAuthorsId(List<Author> authorList) {

        List<String> authorsId = new ArrayList<>();
        for (Author author : authorList) {
            authorsId.add(Integer.toString(author.getId()));
        }

        String authorsIdTogether = authorsId.stream().collect(joining(","));

        return authorsIdTogether;
    }

}
