package se.lexicon;

public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equalsIgnoreCase("")){
            IO.println("Name cannot be empty!");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.contains("@")){
            this.email = email;
        }else{
            IO.println("Invalid email!");
        }


    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
