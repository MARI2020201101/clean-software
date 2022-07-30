package observer.ch02;

class ClockDriver {
    private TimeSink itsSink;

    public ClockDriver(TimeSource source, TimeSink itsSink) {
        source.setDriver(this);
        this.itsSink = itsSink;
    }
    void update(int hours, int minutes, int seconds){
        itsSink.setTime(hours, minutes, seconds);
    }
}
