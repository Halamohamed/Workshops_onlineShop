package se.lexicon;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Customer anna = new Customer(1, "Anna", "anna@email.com","sweden");
        Customer hala = new Customer(2, "Hala", "hala@email.com","sweden");
        Product product = new Product(1, "Laptop", 10200.5,"electronic");
        Order order1 = new Order(1, anna);
        ArrayList<OrderItem> productList = new ArrayList<>();
        productList.add(new OrderItem(new Product(1, "Notebook", 10500.95,"electronic"),12));
        productList.add(new OrderItem(new Product(1, "Notebook", 10500.95,"electronic"),134));
        productList.add(new OrderItem(new Product(2, "pen", 2.95,"electronic"),234));
        productList.add(new OrderItem(new Product(3, "Backpack", 508.5,"electronic"),234));
        productList.add(new OrderItem(new Product(4, "Water bottle", 305.25,"electronic"),230));
        productList.add(new OrderItem(new Product(5, "Calculator", 110.5,"electronic"),300));
        productList.add(new OrderItem(new Product(6, "Headphone", 380.95,"electronic"),209));
        productList.add(new OrderItem(new Product(7, "Charger", 530.95,"electronic"),297));
        productList.add(new OrderItem(new Product(8, "Mouse", 300.5,"electronic"),432));
        productList.add(new OrderItem(new Product(9, "USB cable", 30.95,"electronic"),129));
        productList.add(new OrderItem(new Product(10, "Planner", 59.3,"electronic"),543));
       /* productList.add(new Product(11,"Notebook",10500.95));
        productList.add(new Product(12,"Notebook",10500.95));
        productList.add(new Product(13,"Notebook",10500.95));
*/
        order1.setItemList(productList);


        /*IO.println(anna);
        IO.println(hala);
        IO.println(product);*/

        IO.println(order1);


    }
}
