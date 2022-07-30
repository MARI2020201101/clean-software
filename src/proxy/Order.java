package proxy;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class Order {
    private final LocalDateTime date;
    private final String customerName;
    private Status status;
    private int total;
    private Set<Item> itsItems = new HashSet<>();

    public Order(String customerName) {
        this.customerName = customerName;
        this.date = LocalDateTime.now();
        this.status = Status.YET;
    }
    public void completeOrder(){
        this.status = Status.COMP;
    }

    public Item addItem(Product p, int qty) {
        Item item = new Item(p, qty);
        itsItems.add(item);
        return item;
    }
    private void calculateTotal() {
        int total = 0;
        for(Item item :itsItems){
            Product p = item.getProduct();
            int qty = item.getQuantity();
            total += p.getPrice() * qty;
        }
        this.total = total;
    }
    public int total() {
        calculateTotal();
        return total;
    }
}
class Item {
    private final Product product;
    private final int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
class Product{
    private final String name;
    private final int price;

    public Product(String name,int price) {
        this.name = name;
        this.price =price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
enum Status {
    COMP,YET;
}