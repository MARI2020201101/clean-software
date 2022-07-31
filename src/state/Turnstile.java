package state;

class Turnstile {
    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;
    public static final int COIN = 0;
    public static final int PASS = 1;

    int state = LOCKED;
    private TurnstileController controller;

    public Turnstile(TurnstileController controller) {
        this.controller = controller;
    }
    public void event(int event){
        switch (state){
            case LOCKED -> {
                switch (event){
                    case COIN ->{
                        state=UNLOCKED;
                        controller.unlock();
                        break;
                    }
                    case PASS ->{
                        controller.alarm();
                        break;
                    }
                }
                break;
            }
            case UNLOCKED -> {
                switch (event){
                    case COIN ->{
                        controller.thankyou();
                        break;
                    }
                    case PASS ->{
                        state = LOCKED;
                        controller.lock();
                        break;
                    }
                }break;
            }
        }
    }
}
