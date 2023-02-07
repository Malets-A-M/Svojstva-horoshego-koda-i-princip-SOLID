package Category;

import java.util.HashMap;

public interface Categories {
    String category ();
    Categories add(String title, Integer price);
    HashMap<String, Integer> getList();
    void printList();
    default void assortment(){
        System.out.println("В МАГАЗИНЕ В РАЗДЕЛЕ " + category() + " В НАЛИЧИИ");
        printList();
    }
}
