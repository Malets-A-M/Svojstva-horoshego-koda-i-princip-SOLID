package Category;

import java.util.HashMap;
import java.util.Map;

public final class Devices implements Categories {
    private static Devices instance;

    private Devices() {
    }

    public static Devices getInstance() {
        if (instance == null) instance = new Devices();
        return instance;
    }

    protected HashMap<String, Integer> list = new HashMap<>();

    @Override
    public String category() {
        return NameCategory.Devices;
    }

    @Override
    public Categories add(String title, Integer price) {
        this.list.put(title, price);
        return this;
    }
    @Override
    public HashMap<String, Integer> getList(){
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
