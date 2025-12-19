package se.lexicon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * OrderManagement class to handle order operations.
 * @author Hala
 * Simple console-based menu to manage a single Order
 * (view products, add/remove items, view order and total, replace customer).
 */
public class OrderManagement {

    Scanner scanner = new Scanner(System.in);
    Order order1 = new Order(1, new Customer(1, "Anna", "anna@email.com", "alice street 20"));
    ArrayList<OrderItem> productArrayList = new ArrayList<>(order1.getItemList());

    void main() {
        boolean run = true;
        do {
            menu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    getOrder();
                    break;
                case 5:
                    getTotalPrice();
                    break;
                case 6:
                    order1 = addCustomer();
                    break;
                case 0:
                    run = false;
                    IO.println("Existing... the shop!");
                    break;
                default:
                    IO.println("Invalid option, try again!");
                    break;
            }

        } while (run);
    }

    private Order addCustomer() {
        int orderId = 0;
        IO.println("Enter id: ");
        int id = scanner.nextInt();
        IO.println("Enter name: ");
        String name = scanner.next();
        IO.println("Enter email: ");
        String email = scanner.next();
        IO.println("Enter address: ");
        String address = scanner.next();

        Order order = new Order(++orderId, new Customer(id, name, email, address));
        return order;
    }

    private void getOrder() {
        ArrayList<OrderItem> items = new ArrayList<>(order1.getItemList());
        IO.println("Customer: " + order1.getCustomer());
        for (OrderItem item : items) {
            IO.println(item);
        }
    }

    private void getTotalPrice() {
        ArrayList<OrderItem> items = new ArrayList<>(order1.getItemList());
        double total = 0;
        for (OrderItem p : items) {
            total += p.getLineTotal();
        }
        IO.println("Total price: $" + total);
    }

    private void removeProduct() {
        ArrayList<OrderItem> products = new ArrayList<>(order1.getItemList());
        boolean removed = false;
        IO.println(order1);
        IO.println("Enter product number: ");
        int id = scanner.nextInt();
        for (OrderItem p : products) {
            if (p.getProduct().getId() == id) {
                if (p.getQuantity() > 1) {
                    order1.updateItemQuantity(p.getProduct(), p.getQuantity() - 1);
                    IO.println("product: " + p + " removed " + 1 + " from order");
                } else {
                    order1.removeItem(p);
                    removed = true;
                    IO.println("product: " + p + " removed from order");
                }
            }
        }
        if (!removed) {
            IO.println("Cannot remove the order!");
        }
    }
//asks for product id and quantity, finds product in the fresh list and calls order1.addItem(p, quantity) and sets order time.
    private void addProduct() {
        ArrayList<Product> products = new ArrayList<>(showProducts());
        IO.println("Enter product number: ");
        int id = scanner.nextInt();
        IO.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                order1.addItem(p, quantity);
                order1.setTime(LocalDateTime.now());
                LocalDateTime time = order1.getTime();
                IO.println("want to buy " + quantity + " of " + p.getName() + " Y/N?");
                String choice = scanner.next();
                order1.updateStatus(choice,p);
            }
        }
    }

    //
    // prints a fresh product list, returns it.
    private ArrayList<Product> showProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Notebook", 10500.95, "electronic"));
        products.add(new Product(2, "pen", 2.95, "electronic"));
        products.add(new Product(3, "Backpack", 508.5, "electronic"));
        products.add(new Product(4, "Water bottle", 305.25, "electronic"));
        products.add(new Product(5, "Calculator", 110.5, "electronic"));
        products.add(new Product(6, "Headphone", 380.95, "electronic"));
        products.add(new Product(7, "Charger", 530.95, "electronic"));
        products.add(new Product(8, "Mouse", 300.5, "electronic"));
        products.add(new Product(9, "USB cable", 30.95, "electronic"));
        products.add(new Product(10, "Planner", 59.3, "electronic"));
        products.add(new Product(11, "IPhone", 5490.90, "electronic"));
        products.add(new Product(12, "Notebook2", 7500.25, "electronic"));
        products.add(new Product(13, "Notebook3", 6500.5, "electronic"));
        for (Product p : products) {
            IO.println(p);
        }
        return products;
    }

    void menu() {
        IO.println("Welcome to online shop!");
        IO.println("1- show all Products");
        IO.println("2- addProduct");
        IO.println("3- removeProduct");
        IO.println("4- get order");
        IO.println("5- calculate total");
        IO.println("6- Add new customer");
        IO.println("0- Exit");
        IO.println("chose an option");
    }

}
