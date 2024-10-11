import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager extends Player{


    public GameManager(String gameUserName, char gameUserSymbol, int gamePlayerScore) {
        super(gameUserName, gameUserSymbol, gamePlayerScore);
    }

      //New instance of board to use in while loop.
     //Made Static to be able to use in while loop.
    static Board board = new Board();
    static Scanner sc = new Scanner(System.in);


    /**
     * while loop for the TicTacToe
     *
     */
    public static void play() {

    boolean gameOver;
    while (true) {
        try {
            System.out.println("Welcome to the game of Tic-Tac-Toe! 1:PLAY 0:QUIT");
            int choice = sc.nextInt();

            if (choice == 0) { //The loop ends with 0
                System.out.println("Thanks for playing!, bye!!");
                System.exit(0);

            } else if (choice == 1) {
                System.out.println("Player 1 name?: ");
                String name1 = sc.next();
                player1.setGamePlayerName(name1);

                System.out.println("Player 2 name?: ");
                String name2 = sc.next();
                player2.setGamePlayerName(name2);

                gameOver = false;
                while (!gameOver) {
                    GameManager.board.PrintGameGrid();//Starts with player 1, check for win and tied game.
                    GameManager.PlayerMovesOnTheBoard(board.gameGrid, player1, sc, player1.setGamePlayerName(name1));
                    if (GameManager.DisplayWinner(board.gameGrid, player1)) {
                        System.out.println("You won!" + " " + player1.setGamePlayerName(name1));
                        player1.setGamePlayerScore(player1.getGamePlayerScore() + 1);
                        System.out.println("Win points " + player1.getGamePlayerScore());
                        gameOver = true;

                    }
                    if (GameManager.DisplayTiedGame(board.gameGrid)) {
                        System.out.println("Tied game ");
                        gameOver = true;

                    }

                    {
                        GameManager.PrintGameboard(board.gameGrid);//Player 2s check for win and tied game,
                        GameManager.PlayerMovesOnTheBoard(board.gameGrid, player2, sc, player2.setGamePlayerName(name2));
                        if (GameManager.DisplayWinner(board.gameGrid, player2)) {
                            System.out.println("you won" + " " + player2.setGamePlayerName(name2));
                            player2.setGamePlayerScore(player2.getGamePlayerScore() + 1);
                            System.out.println("Win points " + " " + player2.getGamePlayerScore());
                            gameOver = true;
                        } else if (GameManager.DisplayTiedGame(board.gameGrid)) {
                            System.out.println("Tied game ");
                            gameOver = true;
                        }
                    }


                }
                board.initializeGameGrid();


            }


        } catch (InputMismatchException e) {
            System.out.println("Try again!");
            sc.nextLine();
        }


    }


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
