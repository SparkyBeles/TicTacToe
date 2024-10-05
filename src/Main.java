
import java.awt.desktop.ScreenSleepEvent;
import java.util.DoubleSummaryStatistics;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

        Player player1 = new Player("Max",'x',0,0,0,0);
        Player player2 = new Player("Adam",'o',0,0,0,0);


        boolean gameOver = false;

        while (!gameOver) {
            try{
                System.out.println("Welcome to TicTacToe 0:Quit ");
                int choice = sc.nextInt();

                if (choice == 0) {
                    System.out.println("Thanks for playing!, Bye!");
                    System.exit(0);
                }
                if (choice == 1) {
                    PrintGameboard(gameGrid);
                    PlayerMovesOnTheBoard(gameGrid,player1,sc);

                    if (DisplayWinnerAndLoser(gameGrid,player1)){
                        System.out.println("You won the game!");
                        gameOver = true;
                        continue;
                    }


                    PrintGameboard(gameGrid);
                    PlayerMovesOnTheBoard(gameGrid,player2,sc);


                    if (DisplayWinnerAndLoser(gameGrid,player2)){
                        System.out.println("You wom the game!");
                        gameOver = true;
                        continue;
                    }


                }

            }catch (InputMismatchException e){
                System.out.println("Please enter a number between 1 and 9  (0:Quit): ");
                sc.nextLine();
            }
        }






    }




    /**
     *
     * @param gameGrid Prints out the TicTacToe board
     */
    public static void PrintGameboard(char[][] gameGrid) {
        System.out.println(gameGrid[0][0] +"|"+ gameGrid[0][1] +"|"+ gameGrid[0][2]);
        System.out.println(gameGrid[1][0] + "|" + gameGrid[1][1]+ "|" + gameGrid[1][2]);
        System.out.println(gameGrid[2][0]+ "|" + gameGrid[2][1]+ "|" + gameGrid[2][2]);
    }






    public static boolean IsBoardFull(char[][] gameGrid) {
        if (gameGrid[0][0] == ' ' && gameGrid[0][1] == ' ' && gameGrid[0][2] == ' ') {
            return true;
        }


        if (gameGrid[1][0] == ' ' && gameGrid[1][1] == ' ' && gameGrid[1][2] == ' ') {
            return true;
        }

        if (gameGrid[2][0] == ' ' && gameGrid[2][1] == ' ' && gameGrid[2][2] == ' ') {
            return true;
        }


        return false;
    }



    //Method for Displaying the winner of the game.
    public static boolean DisplayWinnerAndLoser(char[][] gameGrid,Player player) {
        if (gameGrid[0][0] == player.getGamePlayerSymbol() && gameGrid[0][1] == player.getGamePlayerSymbol() && gameGrid[0][2] == player.getGamePlayerSymbol()) {
            return true;
        }


        if (gameGrid[1][0] == player.getGamePlayerSymbol() && gameGrid[1][1] == player.getGamePlayerSymbol() && gameGrid[1][2] == player.getGamePlayerSymbol()) {
            return true;
        }

        if (gameGrid[2][0] == player.getGamePlayerSymbol() && gameGrid[2][1] == player.getGamePlayerSymbol() && gameGrid[2][2] == player.getGamePlayerSymbol()) {
            return true;
        }

        if (gameGrid[0][0] == player.getGamePlayerSymbol()&& gameGrid[1][0] == player.getGamePlayerSymbol()&& gameGrid[2][0] == player.getGamePlayerSymbol()) {
            return true;
        }
        if (gameGrid[0][1] == player.getGamePlayerSymbol() && gameGrid[1][1] == player.getGamePlayerSymbol() && gameGrid[2][1] == player.getGamePlayerSymbol()) {
            return true;
        }

        if (gameGrid[0][2] == player.getGamePlayerSymbol() && gameGrid[1][2] == player.getGamePlayerSymbol()&& gameGrid[2][2] == player.getGamePlayerSymbol()) {
            return true;
        }

        if (gameGrid[2][0] == player.getGamePlayerSymbol() && gameGrid[1][1] == player.getGamePlayerSymbol() && gameGrid[0][2] == player.getGamePlayerSymbol()) {
            return true;
        }
        if (gameGrid[0][0] == player.getGamePlayerSymbol() && gameGrid[1][1] == player.getGamePlayerSymbol() && gameGrid[2][2] == player.getGamePlayerSymbol()) {
            return true;
        }
        return false;
    }







    public static void PlayerMovesOnTheBoard(char[][] gameGrid,Player currentPlayer,Scanner sc) {

        boolean validMove = false;

        while (!validMove) {
            try {

                System.out.println(currentPlayer.getGamePlayerName() + " Enter you move  0:Quit");
                int move = sc.nextInt();
                int row = (move - 1) / 3;  // For movement on the board vertical.
                int col = (move - 1) % 3;  // For movement on the board horizontal

                //Only accepts input between (1 - 9).
                if (move == 0){
                    System.out.println("Thanks for playing!, Bye!!");
                    System.exit(0);
                }
                if (row < 0 || row > 2) {
                    System.out.println(currentPlayer.getGamePlayerName() + " Invalid move");
                    continue;
                }
                if (gameGrid[row][col] != ' ') {
                    System.out.println("Position already occupied");
                } else {
                    gameGrid[row][col] = currentPlayer.getGamePlayerSymbol();
                    validMove = true;
                }


            }catch (InputMismatchException e) {
                System.out.println("Invalid move! Try again 0:Quit");
                sc.nextLine();
            }



        }
    }


}