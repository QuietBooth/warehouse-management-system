package model;

public class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            this.quantity -= amount;
        } else {
            System.out.println("❌ Not enough stock to remove " + amount);
        }
    }

    public String toString() {
        return "📦 " + name + " — Qty: " + quantity;
    }
}
