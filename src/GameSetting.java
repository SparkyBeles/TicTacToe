public class GameSetting {
    private String gamePlayerName;
    private char gamePlayerSymbol;





public GameSetting(String gameUserName, char gameUserSymbol) {
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


    @Override
    public String toString() {
        return "GameSetting{" +
                "gamePlayerName='" + gamePlayerName + '\'' +
                ", gamePlayerSymbol=" + gamePlayerSymbol +
                '}';
    }
}
