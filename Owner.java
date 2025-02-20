package SmartMart;

public class Owner {

    private String Password = "2662";

    Customer customer = new Customer();

    public void AddProductQuantity(int Product) {
        customer.addProductQuantity(Product);
        System.out.println("\n" + Product + " added In Storage");
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
