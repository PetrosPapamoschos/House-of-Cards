public class Player{
    private int totalScore;
    private String playerName;
    public Player(){
        totalScore = 0;
        playerName = "";
    }
    public void addScore(){
        totalScore = totalScore + 100;
    }
    public int getTotalScore(){
        return totalScore;
    }
    public String getName(){
        return playerName;
    }
    public void setName(String name){
        this.playerName = name;
    }
}