package command;

interface Command {
    void execute() throws Exception;
}
class SleepCommand implements Command{
    private Command wakeupCommand = null;
    private ActiveObjectEngine e = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;

    SleepCommand(long milisecond, ActiveObjectEngine e, Command wakeupComman){
        this.e=e;
        this.wakeupCommand =wakeupComman;
        this.sleepTime = milisecond;
    }

    @Override
    public void execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if(! started ){
            started =true;
            startTime = currentTime;
            e.addCommand(this);
        }else if((currentTime - startTime) < sleepTime){
            e.addCommand(this);
        }else{
            e.addCommand(wakeupCommand);
        }
    }
}