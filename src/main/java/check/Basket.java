package check;

import category.Categories;

import java.util.Map;

public class Basket {
    private Purchase purchase;

    public Basket(Categories categories) {
        purchase = new Purchase(categories.getList().size()); //сопоставил размер массива покупок клиента с количеством продуктов в магазине в хэшмапе
    }


    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchase.getPurchases().length; i++) {
            if (purchase.getPurchases()[i] == null) continue; // удалил лишнюю строку, которая в каждой итерации создавала объект
            System.out.println("\t" + purchase.getPurchases()[i].title + " " + purchase.getPurchases()[i].count + " шт. в сумме " + (purchase.getPurchases()[i].count * prices.get(purchase.getPurchases()[i].title)) + " руб.");
            sum += purchase.getPurchases()[i].count * prices.get(purchase.getPurchases()[i].title);
        }
        return sum;
    }

    public void addPurchase(String title, int count) {
        purchase.addPurchase(title, count);
    }
}
