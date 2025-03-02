package logging.runner;

import logging.model.*;

public class Main {

    public static void main(String[] args){
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.processLog(LogLevel.ERROR,"Error Log");
        logProcessor.processLog(LogLevel.INFO, "Info Log");
        logProcessor.processLog(LogLevel.DEBUG, "Debug Log");

    }
}
