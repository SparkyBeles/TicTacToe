public class GameSetting {
    private String gameUserName;
    private char gameUserSymbol;


public GameSetting(String gameUserName, char gameUserSymbol) {
    this.gameUserName = gameUserName;
    this.gameUserSymbol = gameUserSymbol;


}


    public String getGameUserName() {
        return gameUserName;
    }

    public void setGameUserName(String gameUserName) {
        this.gameUserName = gameUserName;



    }


    @Override
    public String toString() {
        return "GameSetting{" +
                "gameUserName='" + gameUserName + '\'' +
                ", gameUserSymbol=" + gameUserSymbol +
                '}';
    }
}
