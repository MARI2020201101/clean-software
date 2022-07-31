package weatherstation;

class AlarmClock {
    private AlarmClockImp alarmClock;
    public AlarmClock(StationToolkit st) {
        AlarmClockImp alarmClock = st.getAlarmClock();
        this.alarmClock = alarmClock;
//        alarmClock.register()
    }
}
