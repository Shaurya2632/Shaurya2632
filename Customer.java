package SmartMart;

import Utility.Utility;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int SubPrice,TPrice, Total_Product_Quantity = 10000, i = 0;
    private boolean ProductAdded = false;

    static List<String> Bill = new ArrayList<>();

    public void ShowBill(){

        System.out.println();

        Bill.add("|--------------------------------------------|");
        Bill.add(String.format("| Total Bill: %-30d |" , TPrice));
        Bill.add("+--------------------------------------------+");

        for(String s : Bill) System.out.println(s);

    }

    public void addItemInfo(String Product, int Product_Quantity){

        if(Product.contains(" ")) Product = Product.trim().replace(" ", "_");

        else Product = Product.trim();

        SubPrice = Storage.Products.get(Product)[1] * Product_Quantity;

        if(Product.contains("_")) Product = Product.trim().replace("_", " ");

        TPrice += SubPrice;
        Bill.add(i, String.format("| %-23s %-9d %-8d |", Product, Product_Quantity, SubPrice));
        i++;

        ProductAdded = true;
    }

    public void SaveOrderHistory(){

        String OrderHistoryFile = "D:\\coding\\java\\Main code\\SmartMart\\Order History.txt";

        if(ProductAdded){

        try (FileWriter writer = new FileWriter(OrderHistoryFile, true)){

            if (new File(OrderHistoryFile).length() == 0) {
                writer.write("+-----------------+\n");
                writer.write("   Order History   \n");
                writer.write("+-----------------+\n\n");
            }

            for(String s : Bill) writer.write(s + "\n");

            writer.write("\n");
            writer.flush();

         Bill.clear();
         i = 0;
         TPrice = 0;
         SubPrice = 0;
        }catch(Exception e){
            Utility.HandleException(e);
        }
    }

    }

      public void addProductQuantity( int QNT){
        Total_Product_Quantity += QNT;

      }

      public void Name(String Name){
        Bill.add("+--------------------------------------------+");
        i++;
        Bill.add(String.format("| Customer Name: %-27s |", Utility.Capital_First_Letter(Name)));
        i++;
        Bill.add("""
                |--------------------------------------------|
                | Products                QNT       Price    |\s
                |--------------------------------------------|""");
        i++;
      }

}
