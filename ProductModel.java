import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductModel {
   private Connection conn;

   public ProductModel(){
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:./computerShop.db");
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
   }

   public ArrayList<Desktop> queryProductByDesktop(double price){
        ArrayList<Desktop> desktop = new ArrayList<Desktop>();
        //String type= "PC";
        try{
            String query = "select maker, model, speed, ram, hd, price from Product NATURAL JOIN PC where price < ? and inventory > 0";
            PreparedStatement statement = conn.prepareStatement(query);
            //statement.setString(1, type);
            statement.setDouble(1, price);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                Desktop desktops = new Desktop(rs.getInt("model"), rs.getFloat("speed"), rs.getInt("ram"), rs.getInt("hd"), rs.getString("maker"), rs.getInt("price"));
                desktop.add(desktops);
            }

        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
        return desktop;
   }

   public ArrayList<Laptop> queryProductByLaptop(float largerScreenSize, float smallerScreenSize){
        ArrayList<Laptop> laptop = new ArrayList<Laptop>();
        try{
            String query = "select model, speed, ram, hd, screen, maker, price from Product NATURAL JOIN Laptop where inventory > 0 and screen BETWEEN ? AND ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setFloat(1, smallerScreenSize);
            statement.setFloat(2, largerScreenSize);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                Laptop laptops = new Laptop(rs.getInt("model"), rs.getFloat("speed"), rs.getInt("ram"), rs.getInt("hd"), rs.getFloat("screen"), rs.getString("maker"), rs.getInt("price"));
                laptop.add(laptops);
            }
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
        return laptop;
   }

   public ArrayList<Printer> queryProductByPrinter(int color){
        ArrayList<Printer> printer = new ArrayList<Printer>();
        try{
            String query = "select model,color, printerType, maker, price from Product NATURAL JOIN Printer where color= ? and inventory > 0";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, color);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
            Printer printers = new Printer(rs.getInt("model"), rs.getInt("color"), rs.getString("printerType"), rs.getString("maker"), rs.getInt("price"));
            printer.add(printers);
            }
        }catch(SQLException se){
            System.out.println(se.getMessage());
        }
        return printer;
    }

    // public void insertIntoOrders(int number, int model, int price, String cashier) {
    //     try {
    //         String query = "insert into Orders values (?, ?, ?, ?)";
    //         PreparedStatement statement = conn.prepareStatement(query);
    //         statement.setInt(1, number);
    //         statement.setInt(2, model);
    //         statement.setInt(3, price);
    //         statement.setString(4, cashier);
    //         conn.setAutoCommit(false);
    //         statement.executeUpdate();
    //         conn.commit();
    //         conn.setAutoCommit(true);
    //         System.out.println("Order is inserted...");
    //     } catch (SQLException e) {
    //         System.err.println(e.getMessage());
    //         if (conn != null) {
    //             try {
    //                 conn.rollback();
    //                 conn.setAutoCommit(true);
    //             } catch (SQLException e2) {
    //                 System.err.println(e2.getMessage());
    //             }
    //         }
    //     }
    // }

    public void insertNewOrder(int model, int price, String cashier) {
        try {
            int orderNumber=0;
            orderNumber++;
            String query = "insert into Orders values (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, orderNumber);
            statement.setInt(2, model);
            statement.setInt(3, price);
            statement.setString(4, cashier);
            conn.setAutoCommit(false);
            statement.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    conn.setAutoCommit(true);
                } catch (SQLException e2) {
                    System.err.println(e2.getMessage());
                }
            }
        }
    }

    public boolean updateInventory(int productModel){
        try{
            String checkInventoryQuery = "select inventory from Product where model = ?";
            PreparedStatement st = conn.prepareStatement(checkInventoryQuery);
            st.setInt(1, productModel);
            ResultSet rs = st.executeQuery();

            if(rs.getInt("inventory") < 1){
                System.out.println("Inventory of this particular product is Empty...");
                return false;
            }else{
                String query = "UPDATE Product SET inventory=inventory-1 where model = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, productModel);
                statement.executeUpdate();
            }

            
        }catch(SQLException e){
            System.err.println(e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    conn.setAutoCommit(true);
                } catch (SQLException e2) {
                    System.err.println(e2.getMessage());
                }
            }
        }
        return true;
    }
}
