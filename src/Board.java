public class Board {
public char[][] gameGrid;

public Board() {
    this.gameGrid = new char[3][3];
    initializeGameGrid();
}

public char[][] getGameGrid() {
    return gameGrid;
}

    /**
     * Creates a new empty board
     */
    public void initializeGameGrid() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            this.gameGrid[i][j] = ' ';

        }
    }
}


    /**
     * Prints the TicTacToe Board
     */
    public void PrintGameGrid() {
        System.out.println(gameGrid[0][0]+"|"+ gameGrid[0][1]+"|"+ gameGrid[0][2]);
        System.out.println(gameGrid[1][0]+"|"+ gameGrid[1][1]+"|"+ gameGrid[1][2]);
        System.out.println(gameGrid[2][0]+"|"+ gameGrid[2][1]+"|"+ gameGrid[2][2]);
    }


}
