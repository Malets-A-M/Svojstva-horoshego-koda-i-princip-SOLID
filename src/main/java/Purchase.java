import java.util.Map;

public class Purchase {
    protected String title;
    protected int count;
    protected Purchase[] purchases; // размер массива вынес в переменную, которая будет зависеть от количества продуктов в хэшмапе

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public Purchase(int countOfProducts) {
        this.purchases = new Purchase[countOfProducts];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) continue; // удалил лишнюю строку, которая в каждой итерации создавала объект
            System.out.println("\t" + purchases[i].title + " " + purchases[i].count + " шт. в сумме " + (purchases[i].count * prices.get(purchases[i].title)) + " руб.");
            sum += purchases[i].count * prices.get(purchases[i].title);
        }
        return sum;
    }
}