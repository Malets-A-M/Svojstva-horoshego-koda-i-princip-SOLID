package category;

import java.util.HashMap;
import java.util.Map;

public class Product implements Categories {
    private static Product instance;

    private Product() {
    }

    public static Product getInstance() {
        if (instance == null) instance = new Product();
        return instance;
    }

    protected Map<String, Integer> list = new HashMap<>();

    @Override
    public String category() {
        return NameCategory.Products;
    }

    @Override
    public Categories add(String title, Integer price) {
        this.list.put(title, price);
        return this;
    }
    @Override
    public Map<String, Integer> getList(){
        return list;
    }

    @Override
    public void printList() {
        for (Map.Entry<String, Integer> productAndPrice : list.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        System.out.println();
    }

    @Override
    public void assortment() {
        Categories.super.assortment();
    }
}
