public class Desktop {
    private int model;
    private float speed;
    private int ram;
    private int hd;
    private String maker;
    private int price;
    public Desktop(int model, float speed, int ram, int hd, String maker, int price) {
        this.model = model;
        this.speed = speed;
        this.ram = ram;
        this.hd = hd;
        this.maker = maker;
        this.price=price;
    }

    
    // Getters and Setters
    public int getModel(){ 
        return model; 
    }
    public void setModel(int model){
        this.model = model;
    }

    public float getSpeed(){ 
        return speed; 
    }
    public void setSpeed(float speed){ 
        this.speed = speed; 
    }

    public int getRam(){ 
        return ram; 
    }
    public void setRam(int ram){ 
        this.ram = ram; 
    }

    public int getHd(){ 
        return hd; 
    }
    public void setHd(int hd){ 
        this.hd = hd; 
    }

    public String getMaker(){ 
        return maker; 
    }
    public void setMaker(String maker){ 
        this.maker = maker; 
    }

    public int getPrice(){ return this.price; }
    public void setPrice(int newPrice){ this.price=newPrice; }
}