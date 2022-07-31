package weatherstation;

import java.util.Observable;

class TemperatureSensor extends Observable{
    private TemperatureSensorImp itsImp;
    public TemperatureSensor(AlarmClock ac, StationToolkit st) {
        itsImp = st.makeTemperature();
    }
}