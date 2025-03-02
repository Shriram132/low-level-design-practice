package snakeAndLadder.runner;

import snakeAndLadder.model.Dice;
import snakeAndLadder.model.Jumper;
import snakeAndLadder.model.Player;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameBoard {

    private Dice dice;
    private Queue<Player> nextTurn = new LinkedList<>();

    private Map<Integer, Jumper> jumpers = new HashMap<>();

    private Map<Integer,Integer> playerPositions = new HashMap<>();

    int boardSize;

    public GameBoard(int numberOfDices, Queue<Player> nextTurn, List<Jumper> jumperList, Map<Integer, Integer>
            playerPositions, int boardSize) {
        this.dice = new Dice(numberOfDices);
        this.nextTurn = nextTurn;
        this.jumpers = jumperList.stream().collect(Collectors.toMap(Jumper::getStartPoint, Function.identity()));
        this.playerPositions = playerPositions;
        this.boardSize = boardSize;
    }

    public void startGame(){
        while (nextTurn.size() > 1){

            Player currPlayer = nextTurn.poll();
            int currPosition = playerPositions.get(currPlayer.getId());

            int newPostion = currPosition+ dice.rollDice();
            if(boardSize < newPostion){
                nextTurn.add(currPlayer);
                continue;
            } else if(boardSize == newPostion){
                System.out.println(currPlayer.getName() + " Won ");
                continue;
            }

            if(jumpers.containsKey(newPostion)){
                System.out.println("Jumping from " + newPostion+ " to " + jumpers.get(newPostion).getEndPoint()
                        + " for Player " + currPlayer.getName());
                newPostion = jumpers.get(newPostion).getEndPoint();
            }
            System.out.println(currPlayer.getName() + " Position - " + newPostion);
            playerPositions.put(currPlayer.getId(),newPostion);
            nextTurn.add(currPlayer);
        }
    }

}
