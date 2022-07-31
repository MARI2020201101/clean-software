package visitor.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModemDecoratorTest {
    @Test
    public void testCreate(){
        Modem m = new HayesModem();
        m.dial("5551212");
        assertEquals("5551212", m.getPhoneNumber());
        m.setSpeakerVolume(100);
        assertEquals(100, m.getSpeakerVolume());
    }

    @Test
    public void testLoudModem(){
        Modem m = new HayesModem();
        Modem decorator = new LoudDialModem(m);
        decorator.dial("12345678");
        assertEquals("12345678" , decorator.getPhoneNumber());
        assertEquals("12345678" , m.getPhoneNumber());
        assertEquals(10, decorator.getSpeakerVolume());
        assertEquals(10, m.getSpeakerVolume());
    }
}
