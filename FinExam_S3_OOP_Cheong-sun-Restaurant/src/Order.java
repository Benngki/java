import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class Order {
    private MenuPackage menuPackage;
    private List<MenuItem> orderList;
    private int subtotal;
    private int pay;
    private int change;
    private String receipt;
    private int quantity;

    public Order(MenuPackage menuPackage, int quantity) {
        orderList = new ArrayList<>();
        this.quantity = quantity;
        this.menuPackage = menuPackage;
        for (MenuItem menuItem : menuPackage.getListItem()) {
            addOrder(menuItem);
        }            
        subtotal = menuPackage.getPrice() * quantity;
    }

    public void addOrder(MenuItem menuItem) {
        orderList.add(menuItem);
    }

    public void processOrder(int mode) {
        System.out.println("Order in process!");
        Instant start = Instant.now();

        if (mode == 1) { // single threading
            for (MenuItem item : orderList) {
                item.getMaker().setMenuItem(item, quantity);
                Thread t = new Thread(item.getMaker());
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }   
            }
        }
        else if (mode == 2){ // multi threading
            List<Thread> threads = new ArrayList<>();
            for (MenuItem item : orderList) {
               item.getMaker().setMenuItem(item, quantity);
               Thread t = new Thread(item.getMaker());
               threads.add(t);
               t.start();
            }
         
            for (Thread t : threads) {
               try {
                  t.join();
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
            }
        }
     
        System.out.println("Order already!");

        Instant end = Instant.now();
        long duration = end.toEpochMilli() - start.toEpochMilli();
        
        System.out.println("Wait time : " + duration + " ms");
     }

    public int getSubtotal() {
        return subtotal;
    }

    public void setPay() {
        int temp = -1;
        do {
            if (temp < subtotal && temp != -1) System.out.println("The money is less!");

            System.out.print("Input the number of payment : ");
            temp = App.input.nextInt();
        } while (temp < subtotal);
        
        this.pay = temp;
        this.change = pay-subtotal;
        generateReceipt();
    }

    public void generateReceipt() {
        receipt = """
        ============ ORDER RECEIPT ============
        ---------------------------------------
            Cheong-sun Fast Food
            Phone: (123) 456-7890
        ---------------------------------------
        Item                              Price
        ---------------------------------------
        """;

        receipt += (quantity)+" x "+menuPackage.getName()+" :\n";

        for (MenuItem menuItem : orderList) {
            receipt += "%d x %-26s %8d\n".formatted(quantity, menuItem.getName(), menuItem.getPrice() * quantity);
        }
                
        receipt +=  """
        ...

        Total   : %29d
        Payment : %29d
        Change  : %29d
        
              Thank you for your purchase!
        ---------------------------------------        
        """.formatted(subtotal, pay, change);
    }

    public void displayReceipt() {
        System.out.println(receipt);
    }
    
}