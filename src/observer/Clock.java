package observer;

import java.time.LocalDateTime;

class Clock {
    private final LocalDateTime time;

    private Clock(LocalDateTime time) {
        this.time = time;
    }

    public int getSeconds() {
        return time.getSecond();
    }

    public int getMinutes() {
        return time.getMinute();
    }

    public int getHours() {
        return time.getHour();
    }

    public static Clock tic(LocalDateTime time){
        return new Clock(time);
    };
}
