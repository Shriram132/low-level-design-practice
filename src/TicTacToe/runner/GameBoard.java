package TicTacToe.runner;

import TicTacToe.model.Player;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {

    private Queue<Player> playerQueue = new LinkedList();
    private int[][] board = new int[3][3];

    public GameBoard (String playerName1, String playerName2){
        Player player1 = new Player(playerName1,1);
        Player player2 = new Player(playerName2,2);
        this.playerQueue.add(player1);
        this.playerQueue.add(player2);
    }

    public void startGame(){
        while(!playerQueue.isEmpty()){
            Player currPlayer = playerQueue.poll();
            printBoard();
            Scanner scanner = new Scanner(System.in);
            System.out.println(currPlayer.getPlayerName() + " Your turn - Put your X coordinate in range 0-2");
            int inputX = Integer.parseInt(scanner.nextLine());
            System.out.println(currPlayer.getPlayerName() + " Put your Y coordinate in range 0-2");
            int inputY = Integer.parseInt(scanner.nextLine());

            while(board[inputX][inputY] != 0){
                System.out.println("Invalid Turn");
                System.out.println(currPlayer.getPlayerName() + " Your turn - Put your X coordinate in range 0-2");
                inputX = Integer.parseInt(scanner.nextLine());
                System.out.println(currPlayer.getPlayerName() + " Put your Y coordinate in range 0-2");
                inputY = Integer.parseInt(scanner.nextLine());
            }

            board[inputX][inputY] = currPlayer.getId();

            if (playerWon(currPlayer,inputX,inputY)){
                System.out.println(currPlayer.getPlayerName() + " Won");
                printBoard();
                break;
            }

            playerQueue.add(currPlayer);
            if(draw()){
                System.out.println("Game Draw");
                break;
            }

        }
    }

    private boolean draw(){
        for(int i =0;i<3; i++){
            for(int j =0 ; j< 3 ;j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean playerWon(Player currPlayer, int inputX, int inputY) {
        int count = 0;
        for(int j =0 ;j<3; j++){
            if(board[inputX][j] == currPlayer.getId()){
                count++;
            }
        }
        if(count ==3 ){
            return true;
        }
        count = 0;
        for(int j =0 ;j<3; j++){
            if(board[j][inputY] == currPlayer.getId()){
                count++;
            }
        }
        if(count ==3 ){
            return true;
        }
        count = 0;
        int i = 0;
        int j = 0;
        while(i<3){
            if(board[i][j] == currPlayer.getId()){
                count++;
            }
            i++;
            j++;
        }
        if(count ==3 ){
            return true;
        }
        count = 0;
        i=0;
        j=2;
        while(i<3){
            if(board[i][j] == currPlayer.getId()){
                count++;
            }
            i++;
            j--;
        }
        if(count ==3 ){
            return true;
        }
        return false;
    }

    private void printBoard(){
        for(int i =0;i<3; i++){
            for(int j =0 ; j< 3 ;j++){
                if(board[i][j] != 0){
                    System.out.print(board[i][j] + " | ");
                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println();
        }
    }

}
