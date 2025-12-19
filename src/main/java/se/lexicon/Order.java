package se.lexicon;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int id;
    private Customer customer;
    private ArrayList<OrderItem> itemList;
    private double discountPercentage;
    private OrderStatus status;
    private LocalDateTime orderDate;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.itemList = new ArrayList<>();
        this.discountPercentage = 0;
        this.orderDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return orderDate;
    }

    public void setTime(LocalDateTime time) {
        this.orderDate = time;
    }

    public ArrayList<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<OrderItem> itemList) {
        this.itemList = itemList;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addItem(Product p, int quantity) {

        double discountedPrice = p.getPrice() - (p.getPrice() * (getDiscountPercentage() / 100));
        if (p.getPrice() * quantity > 1000) {
            IO.println("You have received a discount of 10% for products over $1000!");
            setDiscountPercentage(10);
            p.setPrice(discountedPrice);
        }

        itemList.add(new OrderItem(p, quantity));
    }

    public void removeItem(OrderItem p) {
        itemList.remove(p);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (OrderItem item : itemList) {
            total += item.getLineTotal() * item.getQuantity();
        }
        if (getDiscountPercentage() > 0) {
            total = total - (total * (getDiscountPercentage() / 100));
        }

        return total;
    }

    public void updateItemQuantity(Product product, int quantity) {
        for (OrderItem item : itemList) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(quantity);
            }
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", itemList=" + itemList +
                ", discountPercentage=" + getDiscountPercentage() +
                ", status=" + getStatus() +
                ", total=" + calculateTotalPrice() +
                ", orderDate=" + getOrderDate() +
                '}';
    }

    public String getSummary() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order ID:{").append(id).append("\n");
        stringBuilder.append("Customer: ").append(customer.getName()).append("\n");
        stringBuilder.append("products: ").append(itemList.size()).append("\n");

        for (OrderItem p : itemList) {
            stringBuilder.append(" -name: ").append(p.getProduct())
                    .append(" Total price:$").append(p.getLineTotal()).append("}\n");
        }
        //  stringBuilder.append("Total: $").append(calculateTotal());
        stringBuilder.append(" time: ").append(orderDate.getHour()).append(" minutes: ").append(orderDate.getMinute());
        return stringBuilder.toString();

    }


    public void updateStatus(String choice, Product product) {
        if (choice.equalsIgnoreCase("Y")) {
            IO.println("You have successfully added to your order at: " + getTime());
            if (product.getPrice() > 1000) {
                IO.println("You have received a discount of 10% for products over $1000!");
                setDiscountPercentage(10);
            }
            setStatus(OrderStatus.CONFIRMED);
        } else {
            IO.println("Added product: " + choice + " cancelled.");
            setStatus(OrderStatus.CANCELLED);
        }
    }
}
