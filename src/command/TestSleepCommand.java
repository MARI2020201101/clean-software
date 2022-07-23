package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TestSleepCommand {
    private boolean commandExecuted = false;
    @Test
    public void testSleep() throws Exception {
        Command wakeup = () -> commandExecuted = true;
        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000,e,wakeup);
        e.addCommand(c);
        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();
        long sleepTime = (stop - start);
        assertTrue(sleepTime > 999);
        assertTrue(sleepTime < 1100);
        assertTrue(commandExecuted);
    }






}
class ActiveObjectEngine {
    LinkedList itsCommands =new LinkedList();
    public void addCommand(Command command) {
        itsCommands.add(command);
    }
    public void run() throws  Exception{
        while(! itsCommands.isEmpty()){
            Command command = (Command) itsCommands.getFirst();
            itsCommands.removeFirst();
            command.execute();
        }
    }
}