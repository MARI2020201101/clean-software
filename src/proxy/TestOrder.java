package proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestOrder {

    @Test
    public void testOrderPrice(){
        Order o = new Order("Bob");
        Product toothPaste = new Product("반짝반짝 치약", 129);
        o.addItem(toothPaste,1);
        assertEquals(129, o.total());
        Product mouthWash = new Product("부쿠부쿠 가그린", 342);
        o.addItem(mouthWash, 2);
        assertEquals(813, o.total());

    }
}
