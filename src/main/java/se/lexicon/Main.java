package se.lexicon;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Customer anna = new Customer(1, "Anna", "anna@email.com");
        Customer hala = new Customer(2, "Hala", "hala@email.com");
        Product product = new Product(1, "Laptop", 10200.5);
        Order order1 = new Order(1, anna);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Notebook", 10500.95));
        productList.add(new Product(2, "pen", 2.95));
        productList.add(new Product(3, "Backpack", 508.5));
        productList.add(new Product(4, "Water bottle", 305.25));
        productList.add(new Product(5, "Calculator", 110.5));
        productList.add(new Product(6, "Headphone", 380.95));
        productList.add(new Product(7, "Charger", 530.95));
        productList.add(new Product(8, "Mouse", 300.5));
        productList.add(new Product(9, "USB cable", 30.95));
        productList.add(new Product(10, "Planner", 59.3));
       /* productList.add(new Product(11,"Notebook",10500.95));
        productList.add(new Product(12,"Notebook",10500.95));
        productList.add(new Product(13,"Notebook",10500.95));
*/
        order1.setProducts(productList);


        /*IO.println(anna);
        IO.println(hala);
        IO.println(product);*/

        IO.println(order1);


    }
}
