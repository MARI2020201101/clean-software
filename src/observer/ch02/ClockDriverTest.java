package observer.ch02;

import org.junit.jupiter.api.Test;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockDriverTest {
    @Test
    public void testTimeChange(){
        MockTimeSource source = new MockTimeSource();
        MockTimeSink sink = new MockTimeSink();
        ClockDriver driver = new ClockDriver(source, sink);
        source.setTime(3,4,5);
        assertEquals(3, sink.getHours());
        assertEquals(4, sink.getMinutes());
        assertEquals(5, sink.getSeconds());

        source.setTime(7,8,9);
        assertEquals(7, sink.getHours());
        assertEquals(8, sink.getMinutes());
        assertEquals(9, sink.getSeconds());

    }
}
