public class Cart {
    private int model;
    private int price;

    public Cart(int model, int price){
        setModel(model);
        setPrice(price);
    }

    public void setModel(int newModel){
        this.model=newModel;
    }

    public void setPrice(int newPrice){
        this.price=newPrice;
    }

    public int getModel(){
        return this.model;
    }

    public int getPrice(){
        return this.price;
    }
}
