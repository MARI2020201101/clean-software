package observer.ch02;

interface TimeSource {
    void setDriver(ClockDriver driver);
    void setTime(int hours, int minutes, int seconds);
}
class MockTimeSource implements TimeSource{
    private ClockDriver itsDriver;
    @Override
    public void setDriver(ClockDriver driver) {
        itsDriver=driver;
    }

    @Override
    public void setTime(int hours, int minutes, int seconds) {
        itsDriver.update(hours, minutes, seconds);
    }
}

interface TimeSink {
    void setTime(int hours, int minutes, int seconds);
}
class MockTimeSink implements TimeSink{
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
    public void setTime(int hours, int minutes, int seconds) {
        itsHours=hours;
        itsMinutes=minutes;
        itsSeconds=seconds;
    }
}
