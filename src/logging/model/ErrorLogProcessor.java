package logging.model;

public class ErrorLogProcessor extends LogProcessor{

    public ErrorLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void processLog(LogLevel logLevel, String message){
        if(logLevel == LogLevel.ERROR){
            System.out.println(message);
        } else{
            System.out.println("INSIDE ERROR");
            super.processLog(logLevel,message);
        }
    }
}
