package evenOddPrint.runner;

import evenOddPrint.model.PrinterType;
import evenOddPrint.model.State;

public class Printer implements Runnable {

    private int currentValue;

    private int maxValue;

    private State state;

    private PrinterType currentPrinterType;

    private PrinterType nextPrinterType;


    public Printer(int currentValue, int maxValue, State state, PrinterType currentPrinterType, PrinterType nextPrinterType) {
        this.currentValue = currentValue;
        this.maxValue = maxValue;
        this.state = state;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
    }

    @Override
    public void run(){

        while(currentValue <= maxValue){
            synchronized (state){
                while (this.currentPrinterType != state.getNextToPrint()){
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(currentPrinterType.toString() + " " + currentValue);
                currentValue += 2;
                state.nextToPrint = this.nextPrinterType;
                state.notifyAll();
            }
        }
    }


}
