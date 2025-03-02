package snakeAndLadder.model;

import java.util.Random;

public class Dice {
    private int numberOfDices;

    public Dice(int numberOfDices){
        this.numberOfDices = numberOfDices;
    }

    public int rollDice(){
        Random random = new Random();
        return ( random.nextInt(numberOfDices*5)) + numberOfDices;
    }

}
