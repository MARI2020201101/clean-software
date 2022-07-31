package weatherstation;

import java.util.Observable;

class BarometricPressureSensor extends Observable {
    private BarometricPressureSensorImp itsImp;
    public BarometricPressureSensor(AlarmClock ac, StationToolkit st) {
        itsImp = st.makeBarometricPressureSensor();
    }
}
