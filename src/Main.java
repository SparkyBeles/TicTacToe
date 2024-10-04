
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


        while (true){

            PrintGameboard(gameGrid);

            PlayerMovesOnTheBoard(gameGrid,player1,sc);
            PrintGameboard(gameGrid);

            PlayerMovesOnTheBoard(gameGrid,player2,sc);



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








    //Method for Displaying the winner of the game.
    public static boolean DisplayWinnerAndLoser(char[][] gameGrid,char symbol) {

        if (gameGrid[0][0] == symbol && gameGrid[0][1] == symbol && gameGrid[0][2] == symbol) {
            return true;
        }


        if (gameGrid[1][0] == symbol && gameGrid[1][1] == symbol && gameGrid[1][2] == symbol) {
            return true;
        }

        if (gameGrid [2][0] == symbol && gameGrid[2][1] == symbol && gameGrid[2][2] == symbol) {
            return true;
        }

        if (gameGrid [1][0] == symbol && gameGrid[1][1] == symbol && gameGrid[2][2] == symbol) {
            return true;
        }
        if (gameGrid [2][0] == symbol && gameGrid[1][1] == symbol && gameGrid[0][2] == symbol) {
            return true;
        }
         return false;
    }



    //Method for displaying tied games.
    public static boolean DisplayDraw(char[][] gameGrid,char symbol) {
        if (gameGrid[0][0] != symbol && gameGrid[0][1] != symbol && gameGrid[0][2] != symbol) {
            return true;
        }
        if (gameGrid[1][0] != symbol && gameGrid[1][1] != symbol && gameGrid[1][2] != symbol) {
            return true;
        }
        if (gameGrid [2][0] != symbol && gameGrid[2][1] != symbol && gameGrid[2][2] != symbol) {
            return true;
        }
        if (gameGrid [1][0] != symbol && gameGrid[1][1] != symbol && gameGrid[2][2] != symbol) {
            return true;
        }
        if (gameGrid [2][0] != symbol && gameGrid[1][1] != symbol && gameGrid[0][2] != symbol) {
            return true;
        }

        return false;
    }


    // Method for displaying who has the highest score.
    public static void DisplayGameScore(Player player1, Player player2){

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

                if (row < 0 || row > 9) {
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

          PrintGameboard(gameGrid);

        }
    }


}