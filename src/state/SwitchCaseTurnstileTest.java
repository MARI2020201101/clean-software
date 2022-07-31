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
    public void testStateMachine1(){
        turnstile.state = Turnstile.LOCKED;
        turnstile.event(Turnstile.COIN);
        assertEquals(Turnstile.UNLOCKED, turnstile.state);
        assertTrue(controller.unlocked);
    }
    @Test
    public void testStateMachine2(){
        turnstile.state = Turnstile.LOCKED;
        turnstile.event(Turnstile.PASS);
        assertEquals(Turnstile.LOCKED, turnstile.state);
        assertTrue(controller.alarm);
    }
    @Test
    public void testStateMachine3(){
        turnstile.state = Turnstile.UNLOCKED;
        turnstile.event(Turnstile.COIN);
        assertEquals(Turnstile.UNLOCKED, turnstile.state);
        assertTrue(controller.thankyou);
    }
    @Test
    public void testStateMachine4(){
        turnstile.state = Turnstile.UNLOCKED;
        turnstile.event(Turnstile.PASS);
        assertEquals(Turnstile.LOCKED, turnstile.state);
        assertTrue(controller.lock);
    }
}
