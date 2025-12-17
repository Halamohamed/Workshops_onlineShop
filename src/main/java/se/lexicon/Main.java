package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Customer anna = new Customer(1,"Anna",  "anna@email.com");
        Customer hala = new Customer(2,"Hala", "hala@email.com");
        Product product = new Product(1,"Laptop",10200.5);

        IO.println(anna);
        IO.println(hala);
        IO.println(product);
        hala.setEmail("hala.com");
        hala.setName("");

        IO.println(hala);
    }
}
