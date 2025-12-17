package se.lexicon;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManagement {

    Scanner scanner = new Scanner(System.in);


    Order order1 = new Order(1, new Customer(1, "Anna", "anna@email.com"));
    ArrayList<Product> productArrayList = new ArrayList<>(order1.getProducts());

    void main() {
        boolean run = true;
        do {
            //order1 = addCustomer();
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
                case 6: order1 = addCustomer();
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

    private Order addCustomer(){
        int orderId = 0;
        IO.println("Enter id: ");
        int id = scanner.nextInt();
        IO.println("Enter name: ");
        String name = scanner.next();
        IO.println("Enter email: " );
        String email = scanner.next();

        Order order = new Order(++orderId, new Customer(id, name, email));
        return order;
    }
    private void getOrder() {
        //ArrayList<Product> products = new ArrayList<>(order1.getProducts());
        IO.println("Customer: " + order1.getCustomer());
        for (Product p : order1.getProducts()) {
            IO.println(p);
        }
    }

    private void getTotalPrice() {
        //ArrayList<Product> products = new ArrayList<>(order1.getProducts());
        double total = 0;
        for (Product p : order1.getProducts()) {
            total += p.getPrice();
        }
        IO.println("Total price: $" + order1.calculateTotal());
    }

    private void removeProduct() {
        ArrayList<Product> products = new ArrayList<>(order1.getProducts());
        boolean removed = false;
        IO.println("Enter product number: ");
        int id = scanner.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                order1.removeProduct(p);
                removed= true;
                IO.println("product: " + p + " removed from order");
            }
        }
        if(!removed){
            IO.println("Cannot remove the order!");
        }
    }

    private void addProduct() {
        ArrayList<Product> products = new ArrayList<>(showProducts());
        IO.println("Enter product number: ");
        int id = scanner.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                order1.addProduct(p);
                IO.println("Added product: " + p + " to order");
            }
        }
    }

    private ArrayList<Product> showProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Notebook", 10500.95));
        products.add(new Product(2, "pen", 2.95));
        products.add(new Product(3, "Backpack", 508.5));
        products.add(new Product(4, "Water bottle", 305.25));
        products.add(new Product(5, "Calculator", 110.5));
        products.add(new Product(6, "Headphone", 380.95));
        products.add(new Product(7, "Charger", 530.95));
        products.add(new Product(8, "Mouse", 300.5));
        products.add(new Product(9, "USB cable", 30.95));
        products.add(new Product(10, "Planner", 59.3));
        products.add(new Product(11, "IPhone", 5490.90));
        products.add(new Product(12, "Notebook2", 7500.25));
        products.add(new Product(13, "Notebook3", 6500.5));
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
