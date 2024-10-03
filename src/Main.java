
import java.awt.desktop.ScreenSleepEvent;
import java.util.DoubleSummaryStatistics;
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



        Player player1 = new Player("Max",'x',0,0,0,0,0,0);
        Player player2 = new Player("Adam",'o',0,0,0,0,0,0);


       // PlayerMovesOnTheBoard(gameGrid, sc);

        while (true){
            PrintGameboard(gameGrid);

            PlayerMovesOnTheBoard(gameGrid,player1,sc);
            PrintGameboard(gameGrid);

            PlayerMovesOnTheBoard(gameGrid,player2,sc);
            PrintGameboard(gameGrid);


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
    public static boolean DisplayWinnerAndLoser(Player player1, Player player2,char[][] gameGrid) {


        return false;
    }



    //Method for displaying tied games.
    public static boolean DisplayDraw(Player player1, Player player2){
        return false;
    }


    // Method for displaying who has the highest score.
    public static void DisplayGameScore(Player player1, Player player2){
        if (player1.getGamePlayerScore() > player2.getGamePlayerScore()) {
            System.out.println("Player: " + player1.getGamePlayerName() + "Score is "+ player1.getGamePlayerScore() );
        }else {
            System.out.println("Player: " + player2.getGamePlayerName() + "Score is "+ player2.getGamePlayerScore() );
        }
    }



    //Method for checking if both player have picked the same spot.
    public static boolean IsPlayerPositionSame(char[][] gameGrid,int position,Player player1,Player player2) {

        return player1.getPlayerPosition() != player2.getPlayerPosition();
    }

    public static void PlayerMovesOnTheBoard(char[][] gameGrid,Player currentPlayer,Scanner sc) {
        int row,col;
        boolean validMove = false;

        while (!validMove) {
            System.out.println(currentPlayer.getGamePlayerName() + "Enter you move");
            row = sc.nextInt();
            col = sc.nextInt();



            if (row <0 || row >2 || col <0 || col >2) {
                System.out.println(currentPlayer.getGamePlayerName() + "Invalid move");
                continue;
            }
            if (gameGrid[row][col] != ' ') {
                System.out.println("Position already occupied");
            }else {
                gameGrid[row][col] = currentPlayer.getGamePlayerSymbol();
                validMove = true;
            }


        }
    }


}