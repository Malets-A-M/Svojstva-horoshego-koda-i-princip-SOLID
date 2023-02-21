import category.Categories;
import check.Basket;
import check.Purchase;

import java.util.Scanner;

public class Client {
    private String name;
    private Scanner scanner = new Scanner(System.in);
    private Basket basket;

    public Client(String name){
        this.name = name;
    }


    public void buys(Categories categories){
        basket = new Basket(categories);
        System.out.println(name + ", приветствуем в нашем магазине!");
        categories.assortment(); // вынес в отдельный метод отоброжение содержимого магазина
        System.out.println("Введите два слова: название товара и количество. Или end");
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            basket.addPurchase(product, count);
        }
        long sum = basket.sum(categories.getList());
        System.out.println("ИТОГО: " + sum + "\n");

    }
}
