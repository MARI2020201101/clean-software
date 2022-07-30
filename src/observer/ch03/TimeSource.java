package observer.ch03;

import java.util.HashSet;
import java.util.Set;

interface TimeSource {
    void setTime(int hours, int minutes, int seconds);
    void registerObserver(ClockObserver clockObserver);
}

class MockTimeSource implements TimeSource{
    private Set<ClockObserver> itsObservers = new HashSet<>();

    @Override
    public void setTime(int hours, int minutes, int seconds) {
        for (ClockObserver itsObserver : itsObservers)
        itsObserver.update(hours, minutes, seconds);
    }

    @Override
    public void registerObserver(ClockObserver clockObserver) {
        itsObservers.add(clockObserver);
    }
}

interface TimeSink {
    void setTime(int hours, int minutes, int seconds);
}

class MockTimeSink implements ClockObserver{
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;

    public int getHours() {
        return itsHours;
    }

    public int getMinutes() {
        return itsMinutes;
    }

    public int getSeconds() {
        return itsSeconds;
    }

    @Override
    public void update(int hours, int minutes, int seconds) {
        itsHours=hours;
        itsMinutes=minutes;
        itsSeconds=seconds;
    }

    @Override
    public void addTimeSink(TimeSink timeSink) {

    }
}
