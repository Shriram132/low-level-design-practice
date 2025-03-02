package evenOddPrint.model;

public class State {

    public PrinterType nextToPrint;

    public State(PrinterType nextToPrint){
        this.nextToPrint = nextToPrint;
    }

    public PrinterType getNextToPrint() {
        return nextToPrint;
    }
}
