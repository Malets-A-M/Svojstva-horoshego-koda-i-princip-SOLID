import category.Categories;

import java.util.HashMap;
import java.util.Map;

public final class Market {
    private static Market instance;
    private Market(){}
    private Map<String, Categories> category = new HashMap<>();
    public static Market getInstance(){
        if (instance == null) instance = new Market();
        return instance;
    }
    public void addCategory(String nameCategory, Categories categories){
        category.put(nameCategory, categories);
    }

    public Map<String, Categories> getCategory(){
        return category;
    }
}
