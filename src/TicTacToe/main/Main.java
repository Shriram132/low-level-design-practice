package TicTacToe.main;

import TicTacToe.runner.GameBoard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player 1 Name: ");
        String player1Name = scanner.nextLine();
        System.out.println("Enter Player 2 Name: ");
        String player2Name = scanner.nextLine();

        GameBoard gameBoard = new GameBoard(player1Name,player2Name);
        gameBoard.startGame();

    }
}
