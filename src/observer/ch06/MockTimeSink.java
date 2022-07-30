package observer.ch06;

class MockTimeSink implements Observer {
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;
    private TimeSource timeSource;

    public MockTimeSink(TimeSource timeSource) {
        this.timeSource = timeSource;
    }

    @Override
    public void update() {
        itsHours = timeSource.getHours();
        itsMinutes = timeSource.getMinutes();
        itsSeconds = timeSource.getSeconds();
    }

    public int getHours() {
        return itsHours;
    }

    public int getMinutes() {
        return itsMinutes;
    }

    public int getSeconds() {
        return itsSeconds;
    }
}
