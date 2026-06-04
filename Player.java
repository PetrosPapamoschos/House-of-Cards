public class Player{
    private int totalScore;
    public Player(){
        totalScore = 0;
    }
    public void addScore(){
        totalScore = totalScore + 100;
    }
    public int getTotalScore(){
        return totalScore;
    }
}