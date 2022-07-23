package strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FtoCStrategy implements Application {
    private InputStreamReader isr;
    private BufferedReader br ;
    private boolean done = false;

    @Override
    public void init() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

    @Override
    public void idle() {
        String fahrStr = readLineErrorHandle();
        if(fahrStr == null || fahrStr.length() == 0) setDone();
        else{
            double fahr = Double.parseDouble(fahrStr);
            double celcius = 5.0 / 9.0 * (fahr - 32);
            System.out.println("F= " + fahr + " , C= " + celcius);
        }
    }

    private String readLineErrorHandle(){
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    @Override
    public void cleanup() {
        System.out.println("exit");
    }

    public void setDone(){
        done = true;
    }
    @Override
    public boolean done() {
        return done;
    }

}
