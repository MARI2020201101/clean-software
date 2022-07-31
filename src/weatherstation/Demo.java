package weatherstation;

class Demo {
    public static void main(String[] args) {
        factoryV1();
        factoryV2(args);
    }
    private static void factoryV1(){
        StationToolkit st = new Nimbus1_0Toolkit();
        AlarmClock ac = new AlarmClock(st);
        TemperatureSensor ts = new TemperatureSensor(ac, st);
        BarometricPressureSensor bps = new BarometricPressureSensor(ac,st);
        BarometricPressureTrend bpt = new BarometricPressureTrend(bps);
    }
    private static void factoryV2(String[] args){
        try {
            Class<?> kClass = Class.forName(args[0]);
            StationToolkit st =(StationToolkit) kClass.getConstructor().newInstance();
            AlarmClock ac = new AlarmClock(st);
            TemperatureSensor ts = new TemperatureSensor(ac, st);
            BarometricPressureSensor bps = new BarometricPressureSensor(ac,st);
            BarometricPressureTrend bpt = new BarometricPressureTrend(bps);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
