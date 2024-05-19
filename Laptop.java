public class Laptop {
    private int model;
    private float speed;
    private int ram;
    private int hd;
    private float screen;
    private String maker;
    private int price;
    public Laptop(int model, float speed, int ram, int hd, float screen, String maker, int price) {
        this.model = model;
        this.speed = speed;
        this.ram = ram;
        this.hd = hd;
        this.screen = screen;
        this.maker = maker;
        this.price=price;
    }

    // Getters and Setters
    public int getModel() { return model; }
    public void setModel(int model) { this.model = model; }

    public float getSpeed() { return speed; }
    public void setSpeed(float speed) { this.speed = speed; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public int getHd() { return hd; }
    public void setHd(int hd) { this.hd = hd; }

    public float getScreen() { return screen; }
    public void setScreen(float screen) { this.screen = screen; }

    public String getMaker() { return maker; }
    public void setMaker(String maker) { this.maker = maker; }

    public int getPrice(){ return this.price; }
    public void setPrice(int newPrice){ this.price=newPrice; }
}