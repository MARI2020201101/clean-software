package observer.ch04;

import java.util.HashSet;
import java.util.Set;

class TimeSource {
    private Set<ClockObserver> itsObservers = new HashSet<>();
    protected void notify(int hours, int minutes, int seconds){
        for (ClockObserver itsObserver : itsObservers)
            itsObserver.update(hours, minutes, seconds);
    }
    final void registerObserver(ClockObserver clockObserver){
        itsObservers.add(clockObserver);
    };
}

class MockTimeSource extends TimeSource{
    public void setTime(int hours, int minutes, int seconds) {
        notify(hours, minutes, seconds);
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
