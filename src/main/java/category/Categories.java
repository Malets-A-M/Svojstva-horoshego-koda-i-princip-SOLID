package category;

import java.util.Map;

public interface Categories {
    String category ();
    Categories add(String title, Integer price);
    Map<String, Integer> getList();
    void printList();
    default void assortment(){
        System.out.println("В МАГАЗИНЕ В РАЗДЕЛЕ " + category() + " В НАЛИЧИИ:");
        printList();
    }
}
