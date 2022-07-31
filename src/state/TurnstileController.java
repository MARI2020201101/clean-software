package state;

class TurnstileController {
    boolean unlocked;
    boolean alarm;
    boolean lock;
    boolean thankyou;
    public void unlock() {
        unlocked = true;
        System.out.println("unlocked");
    }

    public void alarm() {
        alarm = true;
        System.out.println("alarm");
    }

    public void lock() {
        lock = true;
        System.out.println("lock");
    }

    public void thankyou() {
        thankyou = true;
        System.out.println("thankyou");
    }
}
