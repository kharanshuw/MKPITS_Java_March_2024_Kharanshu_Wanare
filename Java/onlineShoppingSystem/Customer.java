package onlineShoppingSystem;

public class Customer implements User{.

    private String name;

    @Override
    public String getName() {
        String x=name;
        return  x;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }

}
