package singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TurnstileTest {
    Turnstile t;
    Turnstile t1;
    @BeforeEach
    public void setUp(){
        t = new Turnstile();
        t.reset();
        t1 = new Turnstile();
    }
    @Test
    public void testInit(){
        assertTrue(t.locked());
        assertTrue(!t.alarm());
    }
    @Test
    public void testCoin(){
        t.coin();
        assertTrue(! t1.locked());
        assertTrue(! t1.alarm());
        assertEquals(1, t1.coins());
    }
    @Test
    public void testCoinAndPass(){
        t.coin();
        t.pass();
        assertTrue(t1.locked());
        assertTrue(! t1.alarm());
        assertEquals(1, t1.coins());
    }
    @Test
    public void testTwoCoins(){
        t.coin();
        t.coin();
        assertTrue(!t1.locked());
        assertEquals(1, t1.coins());
        assertEquals(1, t1.refunds());
        assertTrue(! t1.alarm());
    }
    @Test
    public void testPass(){
        t.pass();
        assertTrue(t1.alarm());
        assertTrue(t1.locked());
    }
    @Test
    public void testCancelAlarm(){
        t.pass();
        t.coin();
        assertTrue(! t1.alarm());
        assertTrue(! t1.locked());
        assertEquals(1, t1.coins());
        assertEquals(0, t1.refunds());
    }

    @Test
    public void testTwoOperations(){
        t.coin();
        t.pass();
        t.coin();
        assertTrue(! t.locked());
        assertEquals(2, t.coins());
        t.pass();
        assertTrue(t.locked());
    }
}
