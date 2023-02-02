
class MenuItem {
    private String name;
    private int price;
    private double cookTime; // satuan detik
    private Robot maker;

    public MenuItem(String name, int price, double cookTime, Robot maker) {
        this.name = name;
        this.price = price;
        this.cookTime = cookTime;
        this.maker = maker;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getCookTime() {
        return cookTime;
    }

    public Robot getMaker() {
        return maker;
    }
}