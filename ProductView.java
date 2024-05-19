import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    Scanner kb;
    public ProductView(){
        kb= new Scanner(System.in);
    }

    public int getPrice(){
        System.out.println("Enter the highest price you are willing to pay for desktop.");
        int price = kb.nextInt();
        kb.nextLine();
        return price;
    }

    public float getSmallerSize(){
        System.out.println("Enter the small size for Laptop.");
        float smallScreenSize = kb.nextFloat();
        kb.nextLine();
        return smallScreenSize;
    }

    public float getLargerSize(){
        System.out.println("Enter the larger size for latop. ");
        float largeScreenSize=kb.nextFloat();
        kb.nextLine();
        return largeScreenSize;
    }

    public int getColor(){
        System.out.println("Enter 1 for black and 0 for white.");
        int color = kb.nextInt();
        return color;
    }

    public void displayDesktops(ArrayList<Desktop> desktops){
        int numOfDesktops = desktops.size();

        for(int i = 0; i < numOfDesktops; i++){
            Desktop currDesktop = desktops.get(i);

            System.out.println("Item Number: "+ (i+1));
            System.out.println("Model: " + currDesktop.getModel());
            System.out.println("Speed: " + currDesktop.getSpeed());
            System.out.println("RAM: " + currDesktop.getRam());
            System.out.println("Hard Disk: " + currDesktop.getHd());
            System.out.println("Maker: " + currDesktop.getMaker());
            System.out.println("Price: " + currDesktop.getPrice()+"\n\n");
        }
    }

    public void displayLaptops(ArrayList<Laptop> laptops){
        int numOfLaptops = laptops.size();

        for(int i = 0; i < numOfLaptops; i++){
            Laptop currLaptop = laptops.get(i);
            System.out.println("Item Number: "+ (i+1));
            System.out.println("Model: " + currLaptop.getModel());
            System.out.println("Speed: " + currLaptop.getSpeed());
            System.out.println("RAM: " + currLaptop.getRam());
            System.out.println("Hard Disk: " + currLaptop.getHd());
            System.out.println("Screen Size: " + currLaptop.getScreen());
            System.out.println("Maker: " + currLaptop.getMaker());
            System.out.println("Price: " + currLaptop.getPrice()+"\n\n");
        }
    }

    public void displayPrinters(ArrayList<Printer> printers){
        int numOfPrinters = printers.size();

        for(int i = 0; i < numOfPrinters; i++){
            Printer currPrinter = printers.get(i);

            System.out.println("Item Number: "+ (i+1));
            System.out.println("Model: " + currPrinter.getModel());
            System.out.println("Color: " + currPrinter.getColor());
            System.out.println("PrinterType: " + currPrinter.getPrinterType());
            System.out.println("Maker: " + currPrinter.getMaker());
            System.out.println("Price: " + currPrinter.getPrice()+"\n\n"); 
        }
    }

    public void displayCart(ArrayList<Cart> carts){
        int numOfCarts = carts.size();
        int totalAmount = 0;
        for(int i = 0; i < numOfCarts; i++){
            Cart currCart = carts.get(i);
            totalAmount += currCart.getPrice();

            System.out.println("Item Number: "+ (i+1));
            System.out.println("Model: "+ currCart.getModel());
            System.out.println("Price: "+ currCart.getPrice());
        }
        System.out.println("-------------------------------");
        System.out.println("Total: "+ totalAmount);
    }

    public int displayCartTotalPrice(ArrayList<Cart> carts){
        int numOfCarts = carts.size();
        int totalAmount = 0;
        for(int i = 0; i < numOfCarts; i++){
            Cart currCart = carts.get(i);
            totalAmount += currCart.getPrice();
        }

        return totalAmount;
    }

    // public void displayOrder(ArrayList<Order> orders) {
    //     int numOfOrders = orders.size();

    //     for (int i = 0; i < numOfOrders; i++) {
    //         Order currOrder = orders.get(i);

    //         System.out.println("Order Number: " + currOrder.getOrderNumber());
    //         System.out.println("Model: " + currOrder.getModel());
    //         System.out.println("Price: " + currOrder.getPrice());
    //         System.out.println("Cashier: " + currOrder.getCashier());
    //         System.out.println();
    //     }
    // }

    public void displayOrders(List<Order> orders) {
        System.out.println("Order Number\tModel\tPrice\tCashier");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + "\t\t" + order.getModel() + "\t" +
                               order.getPrice() + "\t" + order.getCashier());
        }
    }

    



}
