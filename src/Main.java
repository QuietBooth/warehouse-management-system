import model.Product;
import model.SpecialProduct;
import model.Warehouse;
import service.OrderService;
import service.WarehouseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WarehouseService warehouseService = new WarehouseService();
        OrderService orderService = new OrderService();

        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("🏢 Enter warehouse name: ");
                    String warehouseName = sc.nextLine();
                    warehouseService.addWarehouse(warehouseName);
                    break;

                case 2:
                    System.out.print("🏢 Enter warehouse name: ");
                    warehouseName = sc.nextLine();
                    Warehouse warehouse = warehouseService.getWarehouseByName(warehouseName);
                    if (warehouse != null) {
                        System.out.print("📦 Enter product name: ");
                        String productName = sc.nextLine();

                        System.out.print("🔢 Enter quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        System.out.print("⭐ Is this a special product? (yes/no): ");
                        String isSpecial = sc.nextLine();

                        if (isSpecial.equalsIgnoreCase("yes")) {
                            warehouse.addProduct(new SpecialProduct(productName, quantity, true));
                        } else {
                            warehouse.addProduct(new Product(productName, quantity));
                        }
                    }
                    break;

                case 3:
                    warehouseService.viewAllWarehouses();
                    break;

                case 4:
                    System.out.print("From warehouse: ");
                    String from = sc.nextLine();
                    System.out.print("To warehouse: ");
                    String to = sc.nextLine();
                    System.out.print("Product name: ");
                    String product = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    Warehouse fromWh = warehouseService.getWarehouseByName(from);
                    Warehouse toWh = warehouseService.getWarehouseByName(to);
                    if (fromWh != null && toWh != null) {
                        orderService.transferProduct(fromWh, toWh, product, qty);
                    }
                    break;

                case 5:
                    System.out.print("🔍 Enter warehouse name: ");
                    String targetWarehouse = sc.nextLine();
                    Warehouse foundWarehouse = warehouseService.getWarehouseByName(targetWarehouse);
                    if (foundWarehouse != null) {
                        foundWarehouse.viewProducts();
                    }
                    break;

                case 6:
                    System.out.println("👋 Exiting system. See you next time!");
                    return;

                default:
                    System.out.println("❗ Invalid option, try again.");
            }

            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("\n============================");
        System.out.println("📦 WAREHOUSE MANAGEMENT SYSTEM");
        System.out.println("============================");
        System.out.println("1. Add Warehouse");
        System.out.println("2. Add Product to Warehouse");
        System.out.println("3. View All Warehouses");
        System.out.println("4. Transfer Product Between Warehouses");
        System.out.println("5. View Products in a Warehouse");
        System.out.println("6. Exit");
    }
}
