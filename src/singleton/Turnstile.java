package singleton;

class Turnstile {
    private static boolean isLocked = true;
    private static boolean isAlarming = false;
    private static int itsCoins = 0;
    private static int itsRefunds = 0;
    protected final static Turnstile LOCKED = new Locked();
    protected final static Turnstile UNLOCKED = new UnLocked();
    protected static Turnstile itsState = LOCKED;

    public void reset(){
        locked(true);
        alarm(false);
        itsCoins = 0;
        itsRefunds = 0;
        itsState = LOCKED;
    }

    public boolean locked(){
        return isLocked;
    }
    public boolean alarm(){
        return isAlarming;
    }
    public void coin(){
        itsState.coin();
    }
    public void pass(){
        itsState.pass();
    }
    protected void alarm(boolean shouldAlarm) {
        isAlarming = shouldAlarm;
    }

    protected void locked(boolean shouldLocked) {
        isLocked = shouldLocked;
    }

    public int coins(){
        return itsCoins;
    }
    public int refunds(){
        return itsRefunds;
    }
    public void deposit(){
        itsCoins++;
    }
    public void refund(){
        itsRefunds++;
    }
}
class Locked extends Turnstile {
    public void coin(){
        itsState = UNLOCKED;
        locked(false);
        alarm(false);
        deposit();
    }
    public void pass(){
        alarm(true);
    }
}

class UnLocked extends Turnstile {
    public void coin(){
       refund();
    }
    public void pass(){
       locked(true);
       itsState = LOCKED;
    }
}