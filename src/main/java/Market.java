import Category.Products;
import Category.Categories;

import java.util.HashMap;

public final class Market {
    private static Market instance;
    private Market(){}
    private HashMap<String, Categories> category = new HashMap<>();
    public static Market getInstance(){
        if (instance == null) instance = new Market();
        return instance;
    }
    public void addCategory(String nameCategory, Categories categories){
        category.put(nameCategory, categories);
    }

    public HashMap<String, Categories> getCategory(){
        return category;
    }
}
