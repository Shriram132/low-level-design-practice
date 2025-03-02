package snakeAndLadder.main;

import snakeAndLadder.model.Jumper;
import snakeAndLadder.model.JumperType;
import snakeAndLadder.model.Player;
import snakeAndLadder.runner.GameBoard;

import java.util.*;


public class Main {
    public static void main (String[] args){

        Player player1 = new Player("Shriram", 1);
        Player player2 = new Player("Jatin", 2);
        Player player3 = new Player("Tanmay", 3);
        Player player4 = new Player("Gokul", 4);

        Queue<Player> q =new LinkedList<>();
        q.add(player1);
        q.add(player2);
        q.add(player3);
        q.add(player4);

        Map<Integer,Integer> playerPositions = new HashMap<>();
        playerPositions.put(1,1);
        playerPositions.put(2,1);
        playerPositions.put(3,1);
        playerPositions.put(4,1);

        List<Jumper> jumperList = new ArrayList<>(Arrays.asList(new Jumper(9,65, JumperType.LADDER),
                new Jumper(8,69, JumperType.LADDER),
                new Jumper(21,75, JumperType.LADDER),
                new Jumper(36,47, JumperType.LADDER),
                new Jumper(39,92, JumperType.LADDER),
                new Jumper(48,1, JumperType.SNAKE),
                new Jumper(79,28, JumperType.SNAKE),
                new Jumper(88,65, JumperType.SNAKE),
                new Jumper(93,52, JumperType.SNAKE),
                new Jumper(25,22, JumperType.SNAKE)
                ));


        GameBoard gameBoard = new GameBoard(1,q,jumperList,playerPositions,100);
        gameBoard.startGame();








    }
}
