public class Player{
    private int totalScore;
    public Player(){
        totalScore = 0;
    }
    public void addScore(int points){
        totalScore += points;
    }
    public int getTotalScore(){
        return totalScore;
    }
}