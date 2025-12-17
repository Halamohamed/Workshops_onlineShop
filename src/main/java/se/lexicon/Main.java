package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Customer anna = new Customer(1,"Anna",  "anna@email.com");
        Customer hala = new Customer(2,"Hala", "hala@email.com");

        IO.println(anna);
        IO.println(hala);
        hala.setEmail("hala.com");
        hala.setName("");

        IO.println(hala);
    }
}
