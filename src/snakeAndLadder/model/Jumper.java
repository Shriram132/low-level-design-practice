package snakeAndLadder.model;

public class Jumper {

    private int startPoint;

    private int endPoint;

    private JumperType jumperType;

    public Jumper( int startPoint , int endPoint, JumperType jumperType){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.jumperType = jumperType;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public JumperType getJumperType() {
        return jumperType;
    }
}
