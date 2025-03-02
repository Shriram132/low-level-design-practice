package evenOddPrint.main;

import evenOddPrint.model.PrinterType;
import evenOddPrint.model.State;
import evenOddPrint.runner.Printer;

public class Main {
    public static  void main(String[] args){
        State state = new State(PrinterType.ODD);
        Printer oddPrinter =  new Printer(1,20,state,PrinterType.ODD,PrinterType.EVEN);
        Printer evenPrinter =  new Printer(2,20,state,PrinterType.EVEN,PrinterType.ODD);

        final Thread oddThread = new Thread(oddPrinter);
        final Thread evenThread = new Thread(evenPrinter);

        oddThread.start();
        evenThread.start();

    }
}
