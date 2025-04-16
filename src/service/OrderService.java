package service;

import model.Product;
import model.Warehouse;

public class OrderService {
    public void transferProduct(Warehouse from, Warehouse to, String productName, int quantity) {
        System.out.println("🔁 Transferring " + quantity + " of " + productName + " from " + from.getName() + " to " + to.getName());
        from.removeProduct(productName, quantity);
        to.addProduct(new Product(productName, quantity));
    }
}
