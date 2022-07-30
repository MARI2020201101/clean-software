package proxy.ch02;

import java.util.HashSet;
import java.util.Set;

interface Order {
    String getCustomerId();
    void addItem(Product p, int qty);
    int total();
}
class OrderImpl implements Order{
    private final String customerName;
    private int total;
    private Set<Item> itsItems = new HashSet<>();

    OrderImpl(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String getCustomerId() {
        return customerName;
    }

    @Override
    public void addItem(Product p, int qty) {
        itsItems.add(new Item(p,qty));
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
    @Override
    public int total() {
        calculateTotal();
        return total;
    }
}
class OrderProxy implements Order{
    private OrderImpl orderImp;

    public OrderProxy(int oid) {
        OrderData orderData = DB.getOrderData(oid);
        this.orderImp = new OrderImpl(orderData.customerId);
    }

    @Override
    public String getCustomerId() {
        return orderImp.getCustomerId();
    }

    @Override
    public void addItem(Product p, int qty) {
        orderImp.addItem(p,qty);
    }

    @Override
    public int total() {
        return orderImp.total();
    }
}