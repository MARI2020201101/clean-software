package strategy;

class ApplicationRunner {
    private Application application;
    ApplicationRunner(Application application){
        this.application=application;
    }
    public void run(){
        application.init();
        while(! application.done()){
            application.idle();
        }
        application.cleanup();
    }
}
class Main{
    public static void main(String[] args) {
        new ApplicationRunner(new FtoCStrategy()).run();
    }
}
