public class GameSetting {
    private String gamePlayerName;
    private char gamePlayerSymbol;
    private int gamePlayerScore;
    private int gamePlayerWins;
    private int gamePlayerLosses;
    private int gamePlayerDraws;




public GameSetting(String gameUserName, char gameUserSymbol, int gameUserScore, int gameUserWins, int gameUserLosses, int gameUserDraws) {
    this.gamePlayerName = gameUserName;
    this.gamePlayerSymbol = gameUserSymbol;
    this.gamePlayerScore = gameUserScore;
    this.gamePlayerWins = gameUserWins;
    this.gamePlayerLosses = gameUserLosses;
    this.gamePlayerDraws = gameUserDraws;



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


    @Override
    public String toString() {
        return "GameSetting{" +
                "gamePlayerName='" + gamePlayerName + '\'' +
                ", gamePlayerSymbol=" + gamePlayerSymbol +
                ", gamePlayerScore=" + gamePlayerScore +
                ", gamePlayerWins=" + gamePlayerWins +
                ", gamePlayerLosses=" + gamePlayerLosses +
                ", gamePlayerDraws=" + gamePlayerDraws +
                '}';
    }
}
