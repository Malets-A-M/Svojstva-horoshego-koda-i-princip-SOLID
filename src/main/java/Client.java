import Category.Categories;

import java.util.Scanner;

public class Client {
    private String name;
    private Scanner scanner = new Scanner(System.in);
    private Purchase purchase;

    public Client(String name){
        this.name = name;
    }


    public void buys(Categories categories){
        purchase = new Purchase(categories.getList().size()); //сопоставил размер массива покупок клиента с количеством продуктов в магазине в хэшмапе
        System.out.println(name + ", приветствуем в нашем магазине!");
        categories.assortment(); // вынес в отдельный метод отоброжение содержимого магазина
        System.out.println("Введите два слова: название товара и количество. Или end");
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            purchase.addPurchase(product, count);
        }
        long sum = purchase.sum(categories.getList());
        System.out.println("ИТОГО: " + sum + "\n");

    }
}
