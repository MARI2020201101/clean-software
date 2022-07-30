package observer.ch06;

interface TimeSource {
    int getHours();
    int getMinutes();
    int getSeconds();
}
class MockTimeSource extends Subject implements TimeSource{

    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;

    public MockTimeSource() {
    }

    @Override
    public int getHours() {
        return itsHours;
    }

    @Override
    public int getMinutes() {
        return itsMinutes;
    }

    @Override
    public int getSeconds() {
        return itsSeconds;
    }

    public void setTime(int hour, int minute, int second) {
        this.itsHours = hour;
        this.itsMinutes = minute;
        this.itsSeconds = second;
        notifyObservers();
    }
}