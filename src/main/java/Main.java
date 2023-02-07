import Category.Devices;
import Category.NameCategory;
import Category.Products;

public class Main {
    /**
     *      Весь код из мейн я перераспределил по классам и методам
     *      Создал интерфейс Category, который является родителем классов типов товара, в данном случае Devices & Products
     *      Классы категорий товаров являются классами singleton
     *      Также создал клас Market, который содержит хэшмапу с категориями товаров, и методы, которые позволяют
     * добавлять новую категорию товара.
     *      Новый класс NameCategory создал для того чтобы хранить там названия категорий. Это необходимо, чтобы при выборе ключа
     * из хэшмапы класса Market, не ошибиться в наименовании этого ключа. Хотел сначала сделать Enum, но через него некрасиво
     * вызывать значение, пришлось бы переводить в стринг.
     *      Также создал класс Client, в который убрал цикл из Main для закупки товара
     */
    public static void main(String[] args) {
        Market market = Market.getInstance(); // вынес продукты магазина в отдельные классы singleton, чтобы было лакониченей управлять ассортиментом
        market.addCategory(NameCategory.Products, Products.getInstance());
        market.addCategory(NameCategory.Devices, Devices.getInstance());
        market.getCategory().get(NameCategory.Products)
                .add("Хлеб", 56)
                .add("Масло", 153)
                .add("Колбаса", 211)
                .add("Пирожок", 45);
        market.getCategory().get(NameCategory.Devices)
                .add("Телефон", 10000)
                .add("Зарядка", 350)
                .add("Блендер", 3800)
                .add("Миксер", 2500);


        new Client("Петя").buys(market.getCategory().get(NameCategory.Products)); //Убрал цикл кода производства покупок из мейн в отдельный метод в классе клиент

        new Client("Вася").buys(market.getCategory().get(NameCategory.Devices));
    }
}