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


        try {
      while (true) {
          PrintGameboard(gameGrid);
          System.out.println("Make your move! 1-9");
          String playerMove = sc.nextLine();
          switch (playerMove) {
              case "1":
                  gameGrid[0][0] = 'x';
                  break;

              case "2":
                  gameGrid[0][1] = 'x';
                  break;
              case "3":
                  gameGrid[0][2] = 'x';
                  break;
              case "4":
                  gameGrid[1][0] = 'x';
                  break;
              case "5":
                  gameGrid[1][1] = 'x';
                  break;
              case "6":
                  gameGrid[1][2] = 'x';
                  break;
              case "7":
                  gameGrid[2][0] = 'x';
                  break;
              case "8":
                  gameGrid[2][1] = 'x';
                  break;
              case "9":
                  gameGrid[2][2] = 'x';
                  break;


              default:
                  System.out.println("Invalid move!");
                  break;

          }


      }
    }catch (InputMismatchException e){
            System.out.println("Invalid move!");
            sc.nextLine();
        }
    }

    //Game board
    public static void PrintGameboard(char[][] gameGrid) {
        System.out.println(gameGrid[0][0] +"|"+ gameGrid[0][1] +"|"+ gameGrid[0][2]);
        System.out.println(gameGrid[1][0] + "|" + gameGrid[1][1]+ "|" + gameGrid[1][2]);
        System.out.println(gameGrid[2][0]+ "|" + gameGrid[2][1]+ "|" + gameGrid[2][2]);
    }
















}