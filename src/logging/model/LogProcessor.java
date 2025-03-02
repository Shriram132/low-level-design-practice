package logging.model;

public abstract class LogProcessor {
    private LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public void processLog(LogLevel logLevel, String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.processLog(logLevel,message);
        }
    }
}
