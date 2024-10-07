
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Game Board TicTacToe
        char[][] gameGrid = new char[3][3];
        gameGrid[0][0] = ' ';
        gameGrid[0][1] = ' ';
        gameGrid[0][2] = ' ';
        gameGrid[1][0] = ' ';
        gameGrid[1][1] = ' ';
        gameGrid[1][2] = ' ';
        gameGrid[2][0] = ' ';
        gameGrid[2][1] = ' ';
        gameGrid[2][2] = ' ';

        //Player class
        Player player1 = new Player("Max",'x',0);
        Player player2 = new Player("Adam",'o',0);



        player1.getGamePlayerScore();
        player2.getGamePlayerScore();


        //List for Win Score
        ArrayList<Integer> ScoreList = new ArrayList<>();
        ScoreList.add(player1.getGamePlayerScore());
        ScoreList.add(player2.getGamePlayerScore());



        boolean gameOver = false;


        try {
            while (true) {
                System.out.println("Welcome to TicTacToe 1:PLAY 0:Quit ");
                int choice1 = sc.nextInt();
                if (choice1 == 0) {
                    System.out.println("Thanks for playing!, Bye!");
                    System.exit(0);
                    break;
                }
                if (choice1 == 1) {

                    while (!gameOver) {
                        if (choice1 == 1) {    //Starts with player 1, checks for win and prints out score points.
                            GameManager.PrintGameboard(gameGrid);
                            GameManager.PlayerMovesOnTheBoard(gameGrid,player1,sc);
                            {
                                if (GameManager.DisplayWinner(gameGrid, player1)) {
                                   GameManager.PrintGameboard(gameGrid);
                                    player1.setGamePlayerScore(player1.getGamePlayerScore() + 1);
                                    System.out.println("Winner is! " + player1.getGamePlayerName());
                                    System.out.println("Win Points " + player1.getGamePlayerScore() + " " +player1.getGamePlayerName());
                                    break;
                                }
                                if (GameManager.DisplayWinner(gameGrid, player1)) {
                                System.out.println("Tied Game! ");
                                break;
                                }
                            }
                        }

                        GameManager.PrintGameboard(gameGrid);
                        GameManager.PlayerMovesOnTheBoard(gameGrid,player2,sc);   //check for player 2 win and prints out score points.
                        GameManager.DisplayWinner(gameGrid, player2);
                        {
                            if (GameManager.DisplayWinner(gameGrid, player2)) {
                                GameManager.PrintGameboard(gameGrid);
                                player2.setGamePlayerScore(player2.getGamePlayerScore() + 1);
                                System.out.println("Winner is! " + player2.getGamePlayerName());
                                System.out.println("Win Points " + player2.getGamePlayerScore() + " " +player2.getGamePlayerName());
                                break;
                            }

                       if (GameManager.DisplayTiedGame(gameGrid)) {
                           System.out.println("Tied Game! ");
                           break;
                       }
                        }
                    }
                    gameOver = false;
                    gameGrid = new char[3][3];  // Creates a new game Board
                    for (int i = 0; i <gameGrid.length; i++) {
                        for (int j = 0; j <gameGrid[0].length; j++) {
                            gameGrid[i][j] = ' ';
                        }
                    }
                }
            }

        }catch (InputMismatchException e) {
            System.out.println("Please enter a number 1-9  0:Quit");
            sc.nextLine();

        }
    }







}