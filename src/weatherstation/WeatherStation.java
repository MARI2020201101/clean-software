package weatherstation;

import java.util.Observer;

class WeatherStation {
    private TemperatureSensor itsTS;
    private BarometricPressureSensor itsBPS;
    private BarometricPressureTrend itsBPT;

    public WeatherStation(String tkName) {
        try {
            Class<?> kClass = Class.forName(tkName);
            StationToolkit st =(StationToolkit) kClass.getConstructor().newInstance();
            AlarmClock ac = new AlarmClock(st);
            itsTS = new TemperatureSensor(ac, st);
            itsBPS = new BarometricPressureSensor(ac,st);
            itsBPT = new BarometricPressureTrend(itsBPS);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void addTempObserver(Observer o){
        itsTS.addObserver(o);
    }
    public void addBPSObserver(Observer o){
        itsBPS.addObserver(o);
    }
    public void addBPTObserver(Observer o){
        itsBPT.addObserver(o);
    }
}