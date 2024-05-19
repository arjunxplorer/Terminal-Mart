import java.util.ArrayList;
import java.util.Scanner;
public class ProductController {
    public static void main(String[] args) {
        ProductView view = new ProductView();
        ProductModel model = new ProductModel();
        Scanner kb = new Scanner(System.in);
        ArrayList<Desktop> desktop =  new ArrayList<Desktop>();
        ArrayList<Laptop> laptop = new ArrayList<Laptop>();
        ArrayList<Printer> printer = new ArrayList<Printer>();
        ArrayList<Cart> cart = new ArrayList<Cart>();
        int number=0;
        while(true){
            //Asking for username
            System.out.println("Enter Username: ");
            String username= kb.nextLine();
            
            //Greeting User
            System.out.println("Welcome "+username+" to our Shop.");

            //Asking which product, they want to see
            System.out.println("What Product would you like to see?.");
            System.out.println("1. Desktop");
            System.out.println("2. Laptop");
            System.out.println("3. Printer");
            System.out.println("4. Exit");

            //taking user's input
            int userOption = kb.nextInt();
            kb.nextLine();

            //using switch statement
            switch (userOption) {
                //case 1 for desktop
                case 1:
                    //Desktop 
                    System.out.println("Welcome to Desktop Zone...");
                    //getting input for the highest price user wants to pay
                    int guessedPrice= view.getPrice();
                    //kb.nextLine();
                    //all the desktop according to user price
                    desktop = model.queryProductByDesktop(guessedPrice);
                    //displaying those desktop
                    view.displayDesktops(desktop);

                    //Confirming if user wants to buy any desktop
                    System.out.println("Would you like to buy any? (Yes/No)");
                    String desktopBuyDecision = kb.nextLine();

                    //if "no/No" then runs the loop again
                    if(desktopBuyDecision.equals("no")){
                        System.out.println("Thank you for looking our Desktops...");
                        continue;
                    }else{ //if "yes/Yes" then selecting which item they want
                        System.out.println("Please select which item number you'd like to have...");
                        int desktopItemNumber = kb.nextInt();
                        kb.nextLine();
                        
                        //checking if the selected number is valid or not
                        if(desktopItemNumber >=1 && desktopItemNumber <= desktop.size()){
                            //getting the selected desktop for the user
                            Desktop selectedDesktop = desktop.get(desktopItemNumber-1);
                            int desktopModel = selectedDesktop.getModel();
                            int desktopPrice = selectedDesktop.getPrice();

                            //adding it to the cart
                            Cart carts = new Cart(desktopModel, desktopPrice);
                            cart.add(carts);
                          
                            boolean result = model.updateInventory(desktopModel);
                            if(result){
                                System.out.println("Item is available...");
                            }else{
                                System.out.println("Inventory is empty...");
                            }
                            model.insertNewOrder(desktopModel, desktopPrice, username);                         

                            //asking user choice for buying another item or proceeding for checkout
                            System.out.println("Please select the following option");
                            System.out.println("1. Proceed to Checkout.");
                            System.out.println("2. Like to buy another item.");
                            
                            int checkoutOptions = kb.nextInt();
                            kb.nextLine();
                            //proceeding to checkout
                            if(checkoutOptions==1){
                                //displaying items in the cart and the total price
                                view.displayCart(cart);
                                
                                
                                int cartTotalPrice = view.displayCartTotalPrice(cart);
                                

                                //asking for payment
                                System.out.println("Please enter the totalAmount to pay...");
                                int payingAmount = kb.nextInt();
                                kb.nextLine();
                                
                                //check if the payment it less,more, or equals to the cartTotalPrice
                                if(payingAmount < cartTotalPrice){
                                    System.out.println("You didn't entered money.");
                                }else if(payingAmount > cartTotalPrice){
                                    //clearing cart and desktop for another user 
                                    System.out.println("Thank you for buying with us.");
                                    System.out.println("Change: "+(payingAmount-cartTotalPrice));
                                    cart.clear();
                                    desktop.clear();
                                }else if(payingAmount == cartTotalPrice){
                                    //clearing cart and desktop for another user 
                                    System.out.println("Thank you for buying with us.");
                                    cart.clear();
                                    desktop.clear();
                                }
                            }else if(checkoutOptions == 2){//going through the loop again
                                continue;
                            }else{
                                System.out.println("Invalid Option...");
                            }
                            

                        }else{
                            System.out.println("Invalid number selection.");
                        }
                    }

                    break;

                //Laptop   
                case 2:

                    //Laptop
                    System.out.println("Welcome to Laptop Zone...");
                    //getting screen sizes
                    float smallerScreenSize = view.getSmallerSize();
                    float largerScreenSize = view.getLargerSize();
                    kb.nextLine();
                    //all the Laptops according to user's choice

                    laptop =  model.queryProductByLaptop(largerScreenSize, smallerScreenSize);
                    
                    //displaying those desktop
                    view.displayLaptops(laptop);

                    //Confirming if user wants to buy any desktop
                    System.out.println("Would you like to buy any? (Yes/No)");
                    String LaptopBuyDecision = kb.nextLine();

                    //if "no/No" then runs the loop again
                    if(LaptopBuyDecision.equals("no")){
                        System.out.println("Thank you for looking our Desktops...");
                        continue;
                    }else{ //if "yes/Yes" then selecting which item they want
                        System.out.println("Please select which item number you'd like to have...");
                        int LaptopItemNumber = kb.nextInt();
                        kb.nextLine();
                        
                        //checking if the selected number is valid or not
                        if(LaptopItemNumber >=1 && LaptopItemNumber <= laptop.size()){
                            //getting the selected desktop for the user
                            Laptop selectedLaptop = laptop.get(LaptopItemNumber-1);
                            int LaptopModel = selectedLaptop.getModel();
                            int LaptopPrice = selectedLaptop.getPrice();
                            

                            //adding it to the cart
                            Cart carts = new Cart(LaptopModel, LaptopPrice);
                            cart.add(carts);
                            
                            boolean result = model.updateInventory(LaptopModel);
                            if(result){
                                System.out.println("Item is available...");
                            }else{
                                System.out.println("Inventory is empty...");
                            }

                            //asking user choice for buying another item or proceeding for checkout
                            System.out.println("Please select the following option");
                            System.out.println("1. Proceed to Checkout.");
                            System.out.println("2. Like to buy another item.");
                            
                            int checkoutOptions = kb.nextInt();
                            kb.nextLine();
                            //proceeding to checkout
                            if(checkoutOptions==1){
                                //displaying items in the cart and the total price
                                view.displayCart(cart);
                                //model.updateInventory(LaptopModel);
                                int cartTotalPrice = view.displayCartTotalPrice(cart);

                                //asking for payment
                                System.out.println("Please enter the totalAmount to pay...");
                                int payingAmount = kb.nextInt();
                                kb.nextLine();
                                
                                //check if the payment it less,more, or equals to the cartTotalPrice
                                if(payingAmount < cartTotalPrice){
                                    System.out.println("You didn't entered money.");
                                }else if(payingAmount > cartTotalPrice){
                                    //clearing cart and desktop for another user 
                                    System.out.println("Thank you for buying with us.");
                                    System.out.println("Change: "+(payingAmount-cartTotalPrice));
                                    cart.clear();
                                    laptop.clear();
                                }else if(payingAmount == cartTotalPrice){
                                    //clearing cart and desktop for another user 
                                    System.out.println("Thank you for buying with us.");
                                    cart.clear();
                                    laptop.clear();
                                }
                            }else if(checkoutOptions == 2){//going through the loop again
                                continue;
                            }else{
                                System.out.println("Invalid Option...");
                            }
                            

                        }else{
                            System.out.println("Invalid number selection.");
                        }    
                    }
                    break;

                //Printer
                case 3:

                    //Printer
                    System.out.println("Welcome to Printer Zone...");
                    //getting the color choice from the user
                    int userColorChoice = view.getColor();
                    kb.nextLine();
                    //all the Printers according to user's color choice
                    printer = model.queryProductByPrinter(userColorChoice);
                    //displaying those printer
                    view.displayPrinters(printer);
                    
                    //Confirming if user wants to buy any printer
                    System.out.println("Would you like to buy any? (Yes/No)");
                    String printerBuyDecision = kb.nextLine();

                    //if "no/No" then runs the loop again
                    if(printerBuyDecision.equals("no")){
                        System.out.println("Thank you for looking our Desktops...");
                        continue;
                    }else{ //if "yes/Yes" then selecting which item they want
                        System.out.println("Please select which item number you'd like to have...");
                        int printerItemNumber = kb.nextInt();
                        kb.nextLine();
                        
                        //checking if the selected printers valid or not
                        if(printerItemNumber >=1 && printerItemNumber <= printer.size()){
                            //getting the selected printer for the user
                            Printer selectedPrinter = printer.get(printerItemNumber-1);
                            int printerModel = selectedPrinter.getModel();
                            int printerPrice = selectedPrinter.getPrice();

                            //adding it to the cart
                            Cart carts = new Cart(printerModel,printerPrice);
                            cart.add(carts);
                           
                            boolean result = model.updateInventory(printerModel);
                            if(result){
                                System.out.println("Item is available...");
                            }else{
                                System.out.println("Inventory is empty...");
                            }
                            

                            //asking user choice for buying another item or proceeding for checkout
                            System.out.println("Please select the following option");
                            System.out.println("1. Proceed to Checkout.");
                            System.out.println("2. Like to buy another item.");
                            
                            int checkoutOptions = kb.nextInt();
                            kb.nextLine();
                            //proceeding to checkout
                            if(checkoutOptions==1){
                                //displaying items in the cart and the total price
                                view.displayCart(cart);
                                //model.updateInventory(printerModel);
                                int cartTotalPrice = view.displayCartTotalPrice(cart);

                                //asking for payment
                                System.out.println("Please enter the totalAmount to pay...");
                                int payingAmount = kb.nextInt();
                                kb.nextLine();
                                
                                //check if the payment it less,more, or equals to the cartTotalPrice
                                if(payingAmount < cartTotalPrice){
                                    System.out.println("You didn't entered money.");
                                }else if(payingAmount > cartTotalPrice){
                                    //clearing cart and printer for another user 
                                    System.out.println("Thank you for buying with us.");
                                    System.out.println("Change: "+(payingAmount-cartTotalPrice));
                                    cart.clear();
                                    printer.clear();
                                }else if(payingAmount == cartTotalPrice){
                                    //clearing cart and printer for another user 
                                    System.out.println("Thank you for buying with us.");
                                    cart.clear();
                                    printer.clear();
                                }
                            }else if(checkoutOptions == 2){//going through the loop again
                                continue;
                            }else{
                                System.out.println("Invalid Option...");
                            }
                            

                        }else{
                            System.out.println("Invalid number selection.");
                        }
                    }

                    break;

                //Exit
                case 4:
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
        

    }
}
