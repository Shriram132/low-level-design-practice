package evenOddPrint.runner;

import evenOddPrint.model.PrinterType;
import evenOddPrint.model.State;

public class Printer implements Runnable {

    private int currentValue;

    private int maxValue;

    private State state;

    private PrinterType currentPrinterType;

    private PrinterType nextPrinterType;



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
                currentValue ++;
                state.nextToPrint = this.nextPrinterType;
                state.notifyAll();
            }
        }
    }


}
