package observer.ch06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObserverTest {
    private MockTimeSource source;
    private MockTimeSink sink;

    @BeforeEach
    public void setUp(){
        source = new MockTimeSource();
        sink = new MockTimeSink(source);
        source.registerObserver(sink);
    }

    @Test
    public void testTimeChange(){
        source.setTime(3,4,5);
        assertSinkEquals(sink, 3,  4,  5);

        source.setTime(7,8,9);
        assertSinkEquals(sink,7,8,9);

    }
    @Test
    public void testMultipleSinks(){
        MockTimeSink sink2 = new MockTimeSink(source);
        source.registerObserver(sink2);

        source.setTime(12,13,14);
        assertSinkEquals(sink, 12,13,14);
        assertSinkEquals(sink2, 12,13,14);
    }
    private void assertSinkEquals(MockTimeSink sink, int hours, int minutes, int seconds) {
        assertEquals(hours, sink.getHours());
        assertEquals(minutes, sink.getMinutes());
        assertEquals(seconds, sink.getSeconds());
    }
}
