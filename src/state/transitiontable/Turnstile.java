package state.transitiontable;

import java.util.ArrayList;
import java.util.List;

class Turnstile {
    //상태
    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;
    //이벤트
    public static final int COIN = 0;
    public static final int PASS = 1;

    int state = LOCKED;

    private TurnstileController controller;
    //상태전이테이블리스트
    private List<Transition> transitions = new ArrayList<>();

    private interface Action{
        void execute();
    }
    private class Transition {
        public Transition(int currentState, int event,
                          int newState, Action action){
            this.currentState = currentState;
            this.event = event;
            this.newState = newState;
            this.action = action;

        }
        int currentState;
        int event;
        int newState;
        Action action;//달라지는 부분만 추상화

    }


    public Turnstile(TurnstileController action) {
        this.controller = action;
        addTransition(LOCKED, COIN, UNLOCKED, unlock());
        addTransition(LOCKED, PASS, LOCKED, alarm());
        addTransition(UNLOCKED, COIN, UNLOCKED, thankyou());
        addTransition(UNLOCKED, PASS, LOCKED, lock());
    }

    private Action lock() {
        return new Action() {
            @Override
            public void execute() {
                doLock();
            }
        };
    }

    private void doLock() {
        controller.lock();
    }

    private Action thankyou() {
        return new Action() {
            @Override
            public void execute() {
                doThankyou();
            }
        };
    }

    private void doThankyou() {
        controller.thankyou();
    }

    private Action alarm() {
        return new Action() {
            @Override
            public void execute() {
                doAlarm();
            }
        };
    }

    private void doAlarm() {
        controller.alarm();
    }

    private Action unlock() {
        return new Action() {
            @Override
            public void execute() {
                doUnLock();
            }
        };
    }

    private void doUnLock() {
        controller.unlock();
    }

    private void addTransition(int currentState, int event,
                               int newState, Action action){
        transitions.add(new Transition(currentState, event, newState, action));
    }

    public void event(int event){
        for (int i = 0; i < transitions.size(); i++) {
            Transition transition = transitions.get(i);
            if(state == transition.currentState && event==transition.event){
                state = transition.newState;
                transition.action.execute();
            }
        }
    }
}
