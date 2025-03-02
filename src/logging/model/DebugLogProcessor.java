package logging.model;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void processLog(LogLevel logLevel, String message){
        if(logLevel == LogLevel.DEBUG){
            System.out.println(message);
        } else {
            System.out.println("INSIDE DEBUG");
            super.processLog(logLevel, message);
        }
    }
}
