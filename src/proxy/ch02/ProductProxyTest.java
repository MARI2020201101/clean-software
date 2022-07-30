package proxy.ch02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductProxyTest {

    @BeforeEach
    public void setUp(){
        ProductData pd = new ProductData();
        pd.sku = "ProxyTest1";
        pd.name = "ProxyTestNAme1";
        pd.price = 456;
        DB.store(pd);
    }

    @Test
    public void testProductProxy(){
        Product p = new ProductProxy("ProxyTest1");
        assertEquals(456 ,p.getPrice());
        assertEquals("ProxyTestNAme1" ,p.getName());
        assertEquals("ProxyTest1" ,p.getSku());
    }

    @Test
    public void testOrderKeyGeneration(){
        OrderData o1 = DB.newOrder("Bob");
        OrderData o2 = DB.newOrder("Bill");
        int firstOid = o1.orderId;
        int secondOid = o2.orderId;
        assertEquals(firstOid +1 , secondOid);
    }

    public void testOrderProxy(){
        DB.store(new ProductData("Wheat",349,"wheat"));
        DB.store(new ProductData("Crest",258,"crest"));
        ProductProxy wheat = new ProductProxy("wheat");
        ProductProxy crest = new ProductProxy("crest");
        OrderData od = DB.newOrder("testOrderProxy");
//        OrderProxy order = new OrderProxy(od.orderId);


    }
}
