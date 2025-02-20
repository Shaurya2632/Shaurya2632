package SmartMart;

import static Utility.Utility.*;

import java.util.Scanner;

@SuppressWarnings("unused")
public class SmartMart {

    public static void main(String... args) {shop();}

    public static void shop (){

        try{

        String Customer_Name;
        String Product;
        int ProductQuantity;
        String info;
        String[] Parts;
        String choice;

        Scanner input = new Scanner(System.in);

        Customer customer = new Customer();
        Owner owner = new Owner();

        while (true) {

            Welcome();
            System.out.print("\nEnter: ");
            String E = input.nextLine().trim();

            if (E.equalsIgnoreCase("2")) {

                int i = 0;

                String customerName = input("\nEnter Name: ", String.class).trim();
                customer.Name(customerName);
                boolean ProductFound = false;

                do {

                    System.out.print("\nEnter Product Info: ");

                    info = input.nextLine();

                    Parts = info.split(",");

                    if (Parts[0].contains(" ")) Product = Parts[0].trim().replace(" ", "_");
                    else Product = Parts[0].trim();

                    Product = Capital_First_Letter(Product);
                    ProductQuantity = Integer.parseInt(Parts[1].trim());

                    for(String product : Storage.Products.keySet()) {

                        if(Product.equals(product)) {

                            System.out.print("Product Found in Mart");
                            customer.addItemInfo(Product, ProductQuantity);
                            ProductFound = true;
                            break;
                        }
                    }

                        if(!ProductFound)
                            System.out.print("Sorry, Product Not available in Mart");

                    System.out.print("\n\nadd Product(Y/N): ");

                    choice = input.nextLine().toLowerCase();

                    if(!(choice.contains("y") || choice.contains("n"))){
                        System.out.println("invalid choice!");
                        StopProgram();
                    }

                }while(!choice.equalsIgnoreCase("n"));

                customer.ShowBill();
                customer.SaveOrderHistory();

            } else if (E.equalsIgnoreCase("4")) {
                System.out.println("Exiting..........");
                System.exit(0);

            } else if (E.equalsIgnoreCase("1")) {

                Verification(owner);
                System.out.println();
                System.out.println("+----------------------+");
                System.out.println("|     Welcome Owner    |");
                System.out.println("|----------------------|");
                System.out.println("| Add Product info     |");
                System.out.println("+----------------------+");

                System.out.print("\nInfo: ");

                info = input.nextLine();

                Parts = info.split(",");

                String ProductName = Capital_First_Letter(Parts[0]).trim();
                int ProductPrice_ = Integer.parseInt(Parts[1].trim());
                int ProductQuantity_ = Integer.parseInt(Parts[2].trim());

                Storage.Products.put(ProductName, new int[]{ProductPrice_, ProductQuantity_});

            }
        }
    }
        catch(Exception e){
            System.out.println();
            e.getCause();
            HandleException(e);

        }
    }

    public static void Verification(Owner owner) {

        Scanner input = new Scanner(System.in);

        String password;

        if (owner.getPassword() == null) {
            System.out.print("Set your password: ");
            owner.setPassword(input.nextLine());
            System.out.println("password created\n");

        }

        do {
            System.out.print("\nPassword: ");
            password = input.nextLine();
        } while (!owner.getPassword().equals(password));
    }

    public static void Welcome() {
        System.out.println();
        System.out.println("+----------------------+");
        System.out.println("| Welcome to SmartMart |");
        System.out.println("|----------------------|");
        System.out.println("|                      |");
        System.out.println("| 1. Owner             |");
        System.out.println("| 2. Customer          |");
        System.out.println("| 3. About             |");
        System.out.println("| 4. Exit              |");
        System.out.println("+----------------------+");
    }

}
