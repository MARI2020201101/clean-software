package visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestModemVisitor {

    private UnixModemConfigurator visitor ;
    private HayesModem h;
    private ZoomModem z;
    private ErnieModem e;

    @BeforeEach
    public void setUp(){
        visitor = new UnixModemConfigurator();
        h = new HayesModem();
        z = new ZoomModem();
        e = new ErnieModem();
    }
    @Test
    public void testHayesForUnix(){
        h.accept(visitor);
        assertEquals("hello world".toUpperCase(), h.configurationString.toUpperCase());
    }
    @Test
    public void testZoomForUnix(){
        z.accept(visitor);
        assertEquals(12345, z.configurationValue);
    }
    @Test
    public void testErnieForUnix(){
        e.accept(visitor);
        assertEquals("hello kitty".toUpperCase(), e.internalPattern.toUpperCase());
    }
}
