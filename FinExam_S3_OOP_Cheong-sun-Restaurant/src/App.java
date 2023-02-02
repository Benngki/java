import java.util.Scanner;

/* 
 * author : Benediktus Hengki Setiawan
 * NIM    : 2502025302
 * kelas  : LA20
 */

public class App {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Order newOrder ;
        int choice, conceptChoice, qty;

        // make robots
        HotdogsMaker hotdogsMaker = new HotdogsMaker();
        FriesMaker friesMaker = new FriesMaker();
        ChickensMaker chickensMaker = new ChickensMaker();
        BurgersMaker burgersMaker = new BurgersMaker();
        DrinksMaker drinksMaker = new DrinksMaker();

        // make menu items
        MenuItem hotdog = new MenuItem("Hotdog Reguler", 19000, 3.0, hotdogsMaker);
        MenuItem burger = new MenuItem("Beef Burger", 10000, 10.0, burgersMaker);
        MenuItem fries = new MenuItem("French Fries", 15000, 5.0, friesMaker);
        MenuItem chicken = new MenuItem("Original Fried Chicken", 10000, 12.0, chickensMaker);
        MenuItem drink = new MenuItem("Coca Cola", 7000, 1.0, drinksMaker);
        
        // make menu packages
        MenuPackage packageA = new MenuPackage("Package A"); // package A
        packageA.addItem(hotdog);
        packageA.addItem(fries);
        packageA.addItem(drink);
        packageA.setDesc1("Package A: Hotdog, French fries + drink");
        packageA.setDesc2("1 x %s, 1 x %s, 1 x %s".formatted(
                                            hotdog.getName(), 
                                            fries.getName(), 
                                            drink.getName())
        );
        MenuPackage packageB = new MenuPackage("Package B"); // package B
        packageB.addItem(burger);
        packageB.addItem(fries);
        packageB.addItem(drink);
        packageB.setDesc1("Package B: Hamburger, French fries + drink");
        packageB.setDesc2("1 x %s, 1 x %s, 1 x %s".formatted(
                                            burger.getName(), 
                                            fries.getName(), 
                                            drink.getName())
        );
        MenuPackage packageC = new MenuPackage("Package C"); // package C
        packageC.addItem(chicken);
        packageC.addItem(fries);
        packageC.addItem(drink);
        packageC.setDesc1("Package C: Fried chicken + French fries + drink");
        packageC.setDesc2("1 x %s, 1 x %s, 1 x %s".formatted(
                                            chicken.getName(), 
                                            fries.getName(), 
                                            drink.getName())
        );

        do {
            String header = "\t\t      _  _ ____ __    ___ __  _  _ ____    ____ __\n"+
                            "\t\t     / )( (  __(  )  / __/  \\( \\/ (  __)  (_  _/  \\\n"+
                            "\t\t     \\ /\\ /) _)/ (_/( (_(  O / \\/ \\) _)     )((  O )\n"+
                            "\t\t     (_/\\_(____\\____/\\___\\__/\\_)(_(____)   (__)\\__/\n"+
                            "  ___ _  _ ____ __  __ _  ___     ____ _  _ __ _    ____ __  ____ ____    ____ __   __ ____ \n"+
                            " / __/ )( (  __/  \\(  ( \\/ __)___/ ___/ )( (  ( \\  (  __/ _\\/ ___(_  _)  (  __/  \\ /  (    \\\n"+
                            "( (__) __ () _(  O /    ( (_ (___\\___ ) \\/ /    /   ) _/    \\___ \\ )(     ) _(  O (  O ) D (\n"+
                            " \\___\\_)(_(____\\__/\\_)__)\\___/   (____\\____\\_)__)  (__)\\_/\\_(____/(__)   (__) \\__/ \\__(____/\n"+
                            "============================================================================================";

            System.out.println(header);

            do {
                System.out.println("Use concept :");
                System.out.println("1. SIngle Threading");
                System.out.println("2. Multi Threading");
                System.out.print("Input your choice : ");
                conceptChoice = input.nextInt();    

                if (conceptChoice < 1 || conceptChoice > 2) System.out.println("Wrong input!");
            } while (conceptChoice < 1 || conceptChoice > 2);
            

            System.out.println("Please select your menu package :");
            // package A
            System.out.println("1. "+packageA.getDesc1());
            System.out.println("   Desc  : "+packageA.getDesc2());
            System.out.println("   Price : "+packageA.getPrice());
            // package B
            System.out.println("2. "+packageB.getDesc1());
            System.out.println("   Desc  : "+packageB.getDesc2());
            System.out.println("   Price : "+packageB.getPrice());
            // package C
            System.out.println("3. "+packageC.getDesc1());
            System.out.println("   Desc  : "+packageC.getDesc2());
            System.out.println("   Price : "+packageC.getPrice());
            System.out.print("Input number of package menu : ");
            choice = input.nextInt();
            System.out.print("Input quantity : ");
            qty = input.nextInt();

            switch (choice) {
                case 1: 
                // packageA
                    newOrder = new Order(packageA, qty);
                    System.out.println("-> Subtotal : "+(newOrder.getSubtotal()));
                    newOrder.setPay();
                    newOrder.processOrder(conceptChoice);
                    newOrder.displayReceipt();
                    break;
                case 2: 
                // packageB
                    newOrder = new Order(packageB, qty);
                    System.out.println("-> Subtotal : "+(newOrder.getSubtotal()));
                    newOrder.setPay();
                    newOrder.processOrder(conceptChoice);
                    newOrder.displayReceipt();
                    break;
                case 3: 
                // packageC
                    newOrder = new Order(packageC, qty);
                    System.out.println("-> Subtotal : "+(newOrder.getSubtotal()));
                    newOrder.setPay();
                    newOrder.processOrder(conceptChoice);
                    newOrder.displayReceipt();
                    break;
            
                default:
                    break;
            }

            System.out.print("Back to home [y/n]? ");
            if (!input.next().equals("y")) break;
        } while (true);        

        System.out.println("============ Good Bye ============");
        
    }
}