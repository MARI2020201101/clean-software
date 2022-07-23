package templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FroCraw {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean done = false;
        while(! done){
            String fahrStr = br.readLine();
            if(fahrStr == null || fahrStr.length() == 0) done = true;
            else{
                double fahr = Double.parseDouble(fahrStr);
                double celcius = 5.0 / 9.0 * (fahr - 32);
                System.out.println("F= " + fahr + " , C= " + celcius);
            }
        }
        System.out.println("exit");
    }
}

//패턴 오용 -> 오히려 더 길고 복잡해졌다.
class FtoCTemplateMethod extends Application{
    private InputStreamReader isr;
    private BufferedReader br ;

    public static void main(String[] args) {
        new FtoCTemplateMethod().run();
    }
    @Override
    protected void init() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
    }

    @Override
    protected void idle() {
        String fahrStr = readLineErrorHandle();
        if (fahrStr == null || fahrStr.length() == 0) super.setDone();
        else {
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
    protected void cleanup() {
        System.out.println("exit");
    }
}
