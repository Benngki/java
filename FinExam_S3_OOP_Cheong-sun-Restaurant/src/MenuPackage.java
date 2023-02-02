import java.util.ArrayList;
import java.util.List;

class MenuPackage {
    private List<MenuItem> listItem;
    private int price;
    private String desc1; // package name
    private String desc2; // package item desc
    private String name; 

    public MenuPackage(String name) {
        this.name = name;
        listItem = new ArrayList<>();
        price = 0;
    }

    public String getName() {
        return name;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc1() {
        return desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void addItem(MenuItem menuItem){
        listItem.add(menuItem);
        setPrice(menuItem);
    }

    private void setPrice(MenuItem menuItem) {
    price += menuItem.getPrice();
    }

    public int getPrice() {
        return price;
    }

    public List<MenuItem> getListItem() {
        return listItem;
    }
}