public class GameSetting {
    private final String gamePlayerName;
    private final char gamePlayerSymbol;
    private int gamePlayerScore;





public GameSetting(String gameUserName, char gameUserSymbol, int gamePlayerScore) {
    this.gamePlayerName = gameUserName;
    this.gamePlayerSymbol = gameUserSymbol;
    this.gamePlayerScore = gamePlayerScore;



}

    public void setGamePlayerScore(int gamePlayerScore) {
        this.gamePlayerScore = gamePlayerScore;
    }

    public int getGamePlayerScore() {
        return gamePlayerScore;
    }

    public String getGamePlayerName() {
        return gamePlayerName;
    }



    public char getGamePlayerSymbol() {
        return gamePlayerSymbol;
    }




    @Override
    public String toString() {
        return "GameSetting{" +
                "gamePlayerName='" + gamePlayerName + '\'' +
                ", gamePlayerSymbol=" + gamePlayerSymbol +
                '}';
    }
}
