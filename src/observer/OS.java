package observer;

import java.util.StringJoiner;

class OS {
    private Clock clock;

 public OS(Clock clock) {
  this.clock = clock;
 }

 public void displayTime(){
        while(true)  {
         int sec = clock.getSeconds();
         int min = clock.getMinutes();
         int hour = clock.getHours();
         showTime(hour, min, sec);
        }
    }

    private void showTime(int hour, int min, int sec) {
       StringJoiner sj = new StringJoiner(" : ");
       String timeInfo = sj
               .add(String.valueOf(hour))
               .add(String.valueOf(min))
               .add(String.valueOf(sec))
               .toString();
       System.out.println("Time info :: " + timeInfo);
    }
}
