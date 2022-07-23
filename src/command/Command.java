package command;

interface Command {
    void execute() throws Exception;
}
class SleepCommand implements Command{
    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;

    SleepCommand(long milisecond, ActiveObjectEngine engine, Command wakeupComman){
        this.engine = engine;
        this.wakeupCommand =wakeupComman;
        this.sleepTime = milisecond;
    }

    @Override
    public void execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if(! started ){
            started =true;
            startTime = currentTime;
            engine.addCommand(this);
        }else if((currentTime - startTime) < sleepTime){
            engine.addCommand(this);
        }else{
            engine.addCommand(wakeupCommand);
        }
    }
}
class DelayedTyper implements Command{

    private long itsDelay;
    private char itsChar;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();
    private static boolean stop = false;

    public DelayedTyper(long itsDelay, char itsChar) {
        this.itsChar = itsChar;
        this.itsDelay = itsDelay;
    }

    public static void main(String[] args) throws Exception {
        engine.addCommand(new DelayedTyper(100,'1'));
        engine.addCommand(new DelayedTyper(300,'3'));
        engine.addCommand(new DelayedTyper(500,'5'));
        engine.addCommand(new DelayedTyper(700,'7'));
        Command stopCommand = ()-> stop = true;
        engine.addCommand(new SleepCommand(20000, engine, stopCommand));
        engine.run();
    }
    @Override
    public void execute() throws Exception {
        System.out.print(itsChar);
        if(! stop) delayAndRepeat();
    }

    private void delayAndRepeat() {
        engine.addCommand(new SleepCommand(itsDelay, engine, this));
    }
}