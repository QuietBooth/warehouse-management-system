package model;

public class SpecialProduct extends Product {
    private boolean highValue;

    public SpecialProduct(String name, int quantity, boolean highValue) {
        super(name, quantity);
        this.highValue = highValue;
    }

    public boolean isHighValue() {
        return highValue;
    }

    @Override
    public String toString() {
        return "⭐ " + getName() + " — Qty: " + getQuantity() + (highValue ? " [HIGH VALUE]" : "");
    }
}
