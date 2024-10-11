public class Player extends GameSetting {


    public Player(String gameUserName, char gameUserSymbol,int gamePlayerScore) {
        super(gameUserName, gameUserSymbol, gamePlayerScore);
    }

    //Made static in order to use in GameManager.
     static Player player1 = new Player("", 'X', 0);
     static Player player2 = new Player("", 'O', 0);





    }

