package weatherstation;

interface StationToolkit {
    TemperatureSensorImp makeTemperature();
    BarometricPressureSensorImp makeBarometricPressureSensor();
    AlarmClockImp getAlarmClock();
}
class Nimbus1_0Toolkit implements StationToolkit{

    @Override
    public TemperatureSensorImp makeTemperature() {
        return null;
    }

    @Override
    public BarometricPressureSensorImp makeBarometricPressureSensor() {
        return null;
    }

    @Override
    public AlarmClockImp getAlarmClock() {
        return null;
    }
}