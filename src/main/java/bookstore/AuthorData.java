package bookstore;

import java.util.List;

public class AuthorData {

    private static AuthorData authorData = null;
    private List<Author> authorList = ImportData.getInstance().importAuthors();

    private AuthorData(){

    }

    public static AuthorData getInstance() {

        if (authorData == null) {
            authorData = new AuthorData();
        }
        return authorData;
    }


    public List<Author> getAllAuthors() {
        return authorList;
    }

    public void setAuthors(List<Author> authorList) {
        this.authorList = authorList;
    }

}
