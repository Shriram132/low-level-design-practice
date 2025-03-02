package logging.model;

public  class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void processLog(LogLevel logLevel, String message){
        if(logLevel == LogLevel.INFO){
           System.out.println(message);
        }else{
            System.out.println("INSIDE INFO");
            super.processLog(logLevel,message);
        }
    }
}
