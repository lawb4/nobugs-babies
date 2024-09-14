package lecture2.homework2.products;

public class Main {
    public static void main(String[] args) {

        PriceList priceList = new PriceList();
        Product product1 = new Product("Индивидуальная консультация", 100.50d);
        Product product2 = new Product("Групповая консультация", 55.50d);

        System.out.println("~Добавляем новый продукт в прайс-лист.");
        priceList.addProduct(product1);
        System.out.println("~Список продуктов в прайс-листе:");
        priceList.printProducts();

        System.out.println("~Добавляем ещё один продукт в прайс-лист.");
        priceList.addProduct(product2);
        System.out.println("~Список продуктов в прайс-листе:");
        priceList.printProducts();

        System.out.println("~Меняем стоимость продукта.");
        priceList.changePrice(product1, 199.99d);
        System.out.println("~Узнаём новую стоимость продукта по наименованию продукта (Индивидуальная консультация):");
        priceList.printIndividualProductByName("Индивидуальная консультация");
    }
}
