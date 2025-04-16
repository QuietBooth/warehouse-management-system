package model;

import java.util.*;

public class Warehouse {
    private String name;
    private List<Product> products;

    public Warehouse(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(product.getName())) {
                p.addQuantity(product.getQuantity());
                return;
            }
        }
        products.add(product);
    }

    public void removeProduct(String productName, int quantity) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                p.reduceQuantity(quantity);
                return;
            }
        }
        System.out.println("❌ Product not found in warehouse.");
    }

    public void viewProducts() {
        System.out.println("🧱 Warehouse: " + name);
        for (Product p : products) {
            System.out.println("   " + p);
        }
    }
}
