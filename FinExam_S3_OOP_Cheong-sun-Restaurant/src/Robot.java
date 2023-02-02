import java.time.Instant;

abstract class Robot implements Runnable {
    protected MenuItem menuItem;
    protected int qty;

    public void setMenuItem(MenuItem menuItem, int qty) {
        this.menuItem = menuItem;
        this.qty = qty;
    }

    @Override
    public void run() {
        System.out.println("Robot is cooking %d ".formatted(qty) + menuItem.getName() + " ...");
        try {
            Thread.sleep((long) (menuItem.getCookTime() * 1000.0 * qty));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished cooking %d ".formatted(qty) + menuItem.getName() + "!");
    }
}

class HotdogsMaker extends Robot{

    @Override
    public void run() {
        System.out.println("Hotdogs Maker is cooking %d ".formatted(qty) + menuItem.getName() + " ...");
        try {
            Thread.sleep((long) (menuItem.getCookTime() * 1000.0 * qty));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished cooking %d ".formatted(qty) + menuItem.getName() + "!");
    }
}

class FriesMaker extends Robot{

    @Override
    public void run() {
        System.out.println("Fries Maker is cooking %d ".formatted(qty) + menuItem.getName() + " ...");
        try {
            Thread.sleep((long) (menuItem.getCookTime() * 1000.0 * qty));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished cooking %d ".formatted(qty) + menuItem.getName() + "!");
    }
}

class ChickensMaker extends Robot{

    @Override
    public void run() {
        System.out.println("Chickens Maker is cooking %d ".formatted(qty) + menuItem.getName() + " ...");
        try {
            Thread.sleep((long) (menuItem.getCookTime() * 1000.0 * qty));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished cooking %d ".formatted(qty) + menuItem.getName() + "!");
    }
}

class BurgersMaker extends Robot{

    @Override
    public void run() {
        System.out.println("Burgers Maker is cooking %d ".formatted(qty) + menuItem.getName() + " ...");
        try {
            Thread.sleep((long) (menuItem.getCookTime() * 1000.0 * qty));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished cooking %d ".formatted(qty) + menuItem.getName() + "!");
    }
}

class DrinksMaker extends Robot{
    @Override
    public void run() {
        System.out.println("Drinks Maker is making %d ".formatted(qty) + menuItem.getName() + " ...");
        try {
            Thread.sleep((long) (menuItem.getCookTime() * 1000.0 * qty));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished making %d ".formatted(qty) + menuItem.getName() + "!");
    }
}