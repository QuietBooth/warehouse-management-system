package service;

import model.Warehouse;

import java.util.*;

public class WarehouseService {
    private List<Warehouse> warehouses;

    public WarehouseService() {
        warehouses = new ArrayList<>();
    }

    public void addWarehouse(String name) {
        warehouses.add(new Warehouse(name));
        System.out.println("✅ Warehouse '" + name + "' added.");
    }

    public Warehouse getWarehouseByName(String name) {
        for (Warehouse w : warehouses) {
            if (w.getName().equalsIgnoreCase(name)) {
                return w;
            }
        }
        System.out.println("❌ Warehouse not found.");
        return null;
    }   

    public void viewAllWarehouses() {
        if (warehouses.isEmpty()) {
            System.out.println("⚠️  No warehouses created yet.");
        } else {
            for (Warehouse w : warehouses) {
                w.viewProducts();
            }
        }
    }
}
