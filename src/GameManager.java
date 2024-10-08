import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager extends Player{


    public GameManager(String gameUserName, char gameUserSymbol, int gamePlayerScore) {
        super(gameUserName, gameUserSymbol, gamePlayerScore);
    }

    /**
     *  Checks for players move on the board and for invalid move.
     * Accptes only valid move 1-9 0:quit other input is invalid and will loop till you make a valid move
     * @param gameGrid
     * @param currentPlayer
     * @param sc
     */
    public static void PlayerMovesOnTheBoard(char[][] gameGrid, Player currentPlayer, Scanner sc,String playerName) {

        boolean validMove = false;

        while (!validMove) {
            try {

                System.out.println(currentPlayer.setGamePlayerName(playerName) + " Enter your move  0:Quit");
                int move = sc.nextInt();
                int row = (move - 1) / 3;  // For movement on the board vertical.
                int col = (move - 1) % 3;  // For movement on the board horizontal

                //Only accepts input between (1 - 9).
                if (move == 0){
                    System.out.println("Thanks for playing!, Bye!!");
                    System.exit(0);
                }
                if (row < 0 || row > 2) { //Checks for Invalid move
                    System.out.println(currentPlayer.getGamePlayerName() + " Invalid move 1-9 0:Quit");
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


    /**
     *
     * @param gameGrid
     * @param player
     * @return Checks for a winner
     */
    public static boolean DisplayWinner(char[][] gameGrid, Player player) {
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
        return gameGrid[0][0] == player.getGamePlayerSymbol() && gameGrid[1][1] == player.getGamePlayerSymbol() && gameGrid[2][2] == player.getGamePlayerSymbol();
    }


    /**
     *
     * @param gameGrid
     * @return Checks the board for empty spot and return true when the boards are full
     */
    public static boolean DisplayTiedGame(char[][] gameGrid) {

        //Loops through the game board to find full board
        for (int row = 0; row < gameGrid.length; row++) {
            for (int col = 0; col <gameGrid[row].length; col++) {
                if (gameGrid[row][col] == ' ') {
                    return false;
                }
            }

        }

        return true;
    }


    /**
     * Prints out the TicTacToe board
     * @param gameGrid
     */
    public static void PrintGameboard(char[][] gameGrid) {
        System.out.println(gameGrid[0][0] +"|"+ gameGrid[0][1] +"|"+ gameGrid[0][2]);
        System.out.println(gameGrid[1][0] + "|" + gameGrid[1][1]+ "|" + gameGrid[1][2]);
        System.out.println(gameGrid[2][0]+ "|" + gameGrid[2][1]+ "|" + gameGrid[2][2]);
    }

}
