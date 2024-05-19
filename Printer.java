public class Printer {
    private int model;
    private int color;
    private String printerType;
    private String maker;
    private int price;

    public Printer(int model, int color, String printerType, String maker, int price) {
        this.model = model;
        this.color = color;
        this.printerType = printerType;
        this.maker = maker;
        this.price=price;
    }

    // Getters and Setters
    public int getModel() { return model; }
    public void setModel(int model) { this.model = model; }

    public int getColor() { return color; }
    public void setColor(int color) { this.color = color; }

    public String getPrinterType() { return printerType; }
    public void setPrinterType(String printerType) { this.printerType = printerType; }

    public String getMaker() { return maker; }
    public void setMaker(String maker) { this.maker = maker; }

    public int getPrice(){ return this.price; }
    public void setPrice(int newPrice){ this.price=newPrice; }
}
