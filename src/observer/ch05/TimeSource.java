package observer.ch05;

import java.util.HashSet;
import java.util.Set;

interface TimeSource {
    void registerObserver(ClockObserver clockObserver);
}
class TimeSourceImplementation {
    private Set<ClockObserver> itsObservers = new HashSet<>();
    public void notify(int hours, int minutes, int seconds){
        for (ClockObserver itsObserver : itsObservers)//갱신
            itsObserver.update(hours, minutes, seconds);
    }
    public void registerObserver(ClockObserver clockObserver) {
        itsObservers.add(clockObserver);//등록
    }
}
//위임을 통한 구현방법
//인터페이스를 구현하는 동시에 Impl 에 대한 참조도 유지하고 있다.
class MockTimeSource implements TimeSource{ //관찰대상 subject = time source
    private TimeSourceImplementation tsImpl = new TimeSourceImplementation();
    public void notify(int hours, int minutes, int seconds){
        tsImpl.notify(hours, minutes, seconds);
    }//메서드의 모든 호출을 Impl 에게 위임한다.
    //엄청 보기 좋은건 아니지만 (?) 상속에 흔들리지 않는다는 장점.
    //Time 로직은 얘가 맡고고.observer 의 등록/ 갱신은 Impl 이 맡는다.
    public void setTime(int hours, int minutes, int seconds) {
        tsImpl.notify(hours, minutes, seconds);
    }

    @Override
    public void registerObserver(ClockObserver clockObserver) {
        tsImpl.registerObserver(clockObserver);
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
