public class GameSetting {
    private String gamePlayerName;
    private char gamePlayerSymbol;
    private int gamePlayerScore;
    private int gamePlayerWins;
    private int gamePlayerLosses;
    private int gamePlayerDraws;
    private int gamePlayerTurns;
    public int PlayerPosition;


public GameSetting(String gameUserName, char gameUserSymbol, int gameUserScore, int gameUserWins, int gameUserLosses, int gameUserDraws, int gameUserTurns, int playerPosition) {
    this.gamePlayerName = gameUserName;
    this.gamePlayerSymbol = gameUserSymbol;


}



    public String getGamePlayerName() {
        return gamePlayerName;
    }

    public void setGamePlayerName(String gamePlayerName) {
        this.gamePlayerName = gamePlayerName;



    }

    public char getGamePlayerSymbol() {
        return gamePlayerSymbol;
    }

    public void setGamePlayerSymbol(char gamePlayerSymbol) {
        this.gamePlayerSymbol = gamePlayerSymbol;
    }

    public int getGamePlayerScore() {
        return gamePlayerScore;
    }

    public void setGamePlayerScore(int gamePlayerScore) {
        this.gamePlayerScore = gamePlayerScore;
    }

    public int getGamePlayerWins() {
        return gamePlayerWins;
    }

    public void setGamePlayerWins(int gamePlayerWins) {
        this.gamePlayerWins = gamePlayerWins;
    }

    public int getGamePlayerLosses() {
        return gamePlayerLosses;
    }

    public void setGamePlayerLosses(int gamePlayerLosses) {
        this.gamePlayerLosses = gamePlayerLosses;
    }

    public int getGamePlayerDraws() {
        return gamePlayerDraws;
    }

    public void setGamePlayerDraws(int gamePlayerDraws) {
        this.gamePlayerDraws = gamePlayerDraws;
    }

    public int getGameUserTurns() {
        return gamePlayerTurns;
    }

    public void setGameUserTurns(int gameUserTurns) {
        this.gamePlayerTurns = gameUserTurns;
    }

    public int getPlayerPosition() {
        return PlayerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        PlayerPosition = playerPosition;
    }

    @Override
    public String toString() {
        return "GameSetting{" +
                "gamePlayerName='" + gamePlayerName + '\'' +
                ", gamePlayerSymbol='" + gamePlayerSymbol + '\'' +
                ", gamePlayerScore=" + gamePlayerScore +
                ", gamePlayerWins=" + gamePlayerWins +
                ", gamePlayerLosses=" + gamePlayerLosses +
                ", gamePlayerDraws=" + gamePlayerDraws +
                '}';
    }
}
