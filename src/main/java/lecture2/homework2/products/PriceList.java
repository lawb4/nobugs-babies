package lecture2.homework2.products;

import java.util.HashMap;
import java.util.Map;

public class PriceList {

    private final Map<String, Double> priceList = new HashMap<>();

    public void addProduct(Product product) {
        priceList.put(product.getName(), product.getPrice());
    }

    public void changePrice(Product product, double newPrice) {

        for (Map.Entry<String, Double> aProduct : priceList.entrySet()) {
            if (product.getName().equals(aProduct.getKey())) {
                aProduct.setValue(newPrice);
            }
        }
    }

    public double getPrice(String productName) {
        double price = 0;

        for (Map.Entry<String, Double> aProduct : priceList.entrySet()) {
            if (productName.equals(aProduct.getKey())) {
                price = aProduct.getValue();
                break;
            }
        }

        return price;
    }

    public void printProducts() {
        for (Map.Entry<String, Double> product : priceList.entrySet()) {
            System.out.printf("Продукт: %s. Стоимость: %s$;\n",
                    product.getKey(), String.format("%.2f", product.getValue()));
        }
    }

    public void printIndividualProductByName(String productName) {
        System.out.printf("Стоимость продукта: %s$\n",
                String.format("%.2f", getPrice(productName)));
    }
}
