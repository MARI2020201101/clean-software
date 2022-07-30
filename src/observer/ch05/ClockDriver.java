package observer.ch05;

interface ClockObserver{
    void update(int hours, int minutes, int seconds);
    void addTimeSink(TimeSink timeSink);
}

class ClockDriver implements ClockObserver{
    private TimeSink itsSink;

    public ClockDriver(TimeSource source) {
        source.registerObserver(this);
    }
    @Override
    public void addTimeSink(TimeSink timeSink){
        itsSink=timeSink;
    }
    @Override
    public void update(int hours, int minutes, int seconds){
        itsSink.setTime(hours, minutes, seconds);
    }
}
