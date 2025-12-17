package se.lexicon;

import java.util.ArrayList;

public class Order {
    private int id;
    private Customer customer;
    private double totalPrice;
    private ArrayList<Product> products;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product p){
        products.add(p);
    }
    public void removeProduct(Product p){
        products.remove(p);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public double calculateTotal(){
        double total= 0;
        for (Product p : products){
            total += p.getPrice();
        }
        totalPrice= total;
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order ID:{").append(id).append("\n");
         stringBuilder.append("Customer: ").append(customer.getName()).append("\n");
         stringBuilder.append("products: ").append(products.size()).append("\n");

        for (Product p: products){
            stringBuilder.append(" -name: ").append(p.getName())
                    .append(" price:$" ).append(p.getPrice()).append("}\n") ;
        }
        stringBuilder.append("Total: $").append(calculateTotal());
        return stringBuilder.toString();

    }
}
