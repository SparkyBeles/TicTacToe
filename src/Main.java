
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
        Player player1 = new Player("Max",'x');
        Player player2 = new Player("Adam",'o');


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
                        if (choice1 == 1) {    //Starts with player 1, checks for win.
                            PrintGameboard(gameGrid);
                            PlayerMovesOnTheBoard(gameGrid, player1, sc);
                            DisplayWinner(gameGrid, player1);
                            {
                                if (DisplayWinner(gameGrid, player1)) {
                                    System.out.println("You win! " + player1.getGamePlayerName());
                                    break;
                                }
                                if (DisplayTiedGame(gameGrid)) {
                                System.out.println("Tied Game! ");
                                break;
                            }
                            }
                        }


                        PrintGameboard(gameGrid);
                        PlayerMovesOnTheBoard(gameGrid, player2, sc);    //check for player 2 win.
                        DisplayWinner(gameGrid, player2);
                        {
                            if (DisplayWinner(gameGrid, player2)) {
                                System.out.println("You win! " + player2.getGamePlayerName());
                                break;
                            }

                       if (DisplayTiedGame(gameGrid)) {
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
            System.out.println("Please enter a number between 0 and 3");
            sc.nextLine();

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


    /**
     *
     * @param gameGrid
     * @return Checks for full board to return Tied game true
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
     *
     * @param gameGrid
     * @param player
     * @return Checks for winner.
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
     * Checks for valid move and place valid move on the board
     * Have the option to quit the game with 0.
     * Only accepts input between 1-9, loops till you make a valid input.
     * Try and catch for invalid input.
     * @param gameGrid
     * @param currentPlayer
     * @param sc
     */
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
                if (row < 0 || row > 2) { //Checks for Invalid move
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