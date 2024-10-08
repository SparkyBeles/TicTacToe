
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
        Player player1 = new Player("", 'x', 0);
        Player player2 = new Player("", 'o', 0);


        player1.getGamePlayerScore();
        player2.getGamePlayerScore();


        //List for Win Score
        ArrayList<Integer> ScoreList = new ArrayList<>();
        ScoreList.add(player1.getGamePlayerScore());
        ScoreList.add(player2.getGamePlayerScore());


        boolean gameOver;
        while (true) {
            try{
                System.out.println("Welcome to the game of Tic-Tac-Toe! 1:PLAY 0:QUIT");
                int choice = sc.nextInt();

                if (choice == 0) {
                    System.out.println("Thanks for playing!, bye!!");
                    System.exit(0);

                }else if (choice == 1) {
                    System.out.println("Player 1 name?: ");
                    String name1 = sc.next();
                    player1.setGamePlayerName(name1);

                    System.out.println("Player 2 name?: ");
                    String name2 = sc.next();
                    player2.setGamePlayerName(name2);

                    gameOver = false;
                    while (!gameOver) {
                       GameManager.PrintGameboard(gameGrid);
                       GameManager.PlayerMovesOnTheBoard(gameGrid,player1,sc,player1.setGamePlayerName(name1));
                       if (GameManager.DisplayWinner(gameGrid,player1)) {
                           System.out.println("You won!"+ " " +player1.setGamePlayerName(name1));
                           player1.setGamePlayerScore(player1.getGamePlayerScore()+1);
                           System.out.println("Win points " + player1.getGamePlayerScore());
                           gameOver = true;
                           continue;
                       }
                        if (GameManager.DisplayTiedGame(gameGrid)) {
                           System.out.println("Tied game ");
                           gameOver = true;
                           continue;
                       }

                        {
                           GameManager.PrintGameboard(gameGrid);
                           GameManager.PlayerMovesOnTheBoard(gameGrid,player2,sc,player2.setGamePlayerName(name2));
                           if (GameManager.DisplayWinner(gameGrid,player2)) {
                               System.out.println("you won"+ " "+player2.setGamePlayerName(name2));
                               player2.setGamePlayerScore(player2.getGamePlayerScore()+1);
                               System.out.println("Win points " + " "+player2.getGamePlayerScore());
                               gameOver = true;
                           }else if (GameManager.DisplayTiedGame(gameGrid)) {
                               System.out.println("Tied game ");
                               gameOver = true;
                           }
                        }


                    }
                    gameGrid = new char[3][3];
                    for (int i = 0; i < gameGrid.length; i++) {
                        for (int j = 0; j < gameGrid.length; j++) {
                            gameGrid[i][j] = ' ';
                        }
                    }


                }



            }catch (InputMismatchException e){
                System.out.println("Try again!");
                sc.nextLine();
            }
        }




    }
}



