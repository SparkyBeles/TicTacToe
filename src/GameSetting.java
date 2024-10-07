public class GameSetting {
    private String gamePlayerName;
    private char gamePlayerSymbol;
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

    public void setGamePlayerName(String gamePlayerName) {
        this.gamePlayerName = gamePlayerName;



    }

    public char getGamePlayerSymbol() {
        return gamePlayerSymbol;
    }

    public void setGamePlayerSymbol(char gamePlayerSymbol) {
        this.gamePlayerSymbol = gamePlayerSymbol;
    }


    @Override
    public String toString() {
        return "GameSetting{" +
                "gamePlayerName='" + gamePlayerName + '\'' +
                ", gamePlayerSymbol=" + gamePlayerSymbol +
                '}';
    }
}
