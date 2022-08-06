package state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SwitchCaseTurnstileTest {
    TurnstileController controller;
    Turnstile turnstile;
    @BeforeEach
    public void setUp(){
        controller = new TurnstileController();
        turnstile = new Turnstile(controller);
    }
    @Test
    public void testCoinInLockedState(){
        turnstile.state = Turnstile.LOCKED;
        turnstile.event(Turnstile.COIN);
        assertEquals(Turnstile.UNLOCKED, turnstile.state);
        assertTrue(controller.unlocked);
    }
    @Test
    public void testPassInLockedState(){
        turnstile.state = Turnstile.LOCKED;
        turnstile.event(Turnstile.PASS);
        assertEquals(Turnstile.LOCKED, turnstile.state);
        assertTrue(controller.alarm);
    }
    @Test
    public void testCoinInUnlockedState(){
        turnstile.state = Turnstile.UNLOCKED;
        turnstile.event(Turnstile.COIN);
        assertEquals(Turnstile.UNLOCKED, turnstile.state);
        assertTrue(controller.thankyou);
    }
    @Test
    public void testPassInUnlockedState(){
        turnstile.state = Turnstile.UNLOCKED;
        turnstile.event(Turnstile.PASS);
        assertEquals(Turnstile.LOCKED, turnstile.state);
        assertTrue(controller.lock);
    }
}
