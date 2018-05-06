package bookstore;

import java.util.List;

public class CategoryData {

    private static CategoryData categoryData = null;
    private List<Category> categoryList = ImportData.getInstance().importCategories();

    private CategoryData(){

    }

    public static CategoryData getInstance() {

        if (categoryData == null) {
            categoryData = new CategoryData();
        }
        return categoryData;
    }


    public List<Category> getAllCategories() {
        return categoryList;
    }

    public void setCategories(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

}
