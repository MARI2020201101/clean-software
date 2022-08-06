package state.statepattern;

class Turnstile {
    private static TurnstileState lockedState = new LockedTurnstileState();
    private static TurnstileState unlockedState = new UnLockedTurnstileState();

    private TurnstileController turnstileController;
    private TurnstileState state = lockedState;

    public Turnstile(TurnstileController action) {
        this.turnstileController = action;
    }

    public void setUnlocked() {
        state = unlockedState;
    }

    public void unlock() {
        turnstileController.unlock();
    }

    public void alarm() {
        turnstileController.alarm();
    }

    public void thankyou() {
        turnstileController.thankyou();
    }

    public void setLocked() {
        this.state = lockedState;
    }

    public void lock() {
        turnstileController.lock();
    }
}
