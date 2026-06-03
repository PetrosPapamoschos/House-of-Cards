public class House {
    private int houseNumber;
    private int houseScore;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
        this.houseScore = 0;
    }

    public int getHouseScore() {
        return houseScore;
    }
    public void addToHouseScore(int score) {
        this.houseScore += score;
    }
    public void resetHouseScore() {
        this.houseScore = 0;
    }

    @Override
    public String toString() {
        return "House " + houseNumber + " has a score of " + houseScore;
    }

    public void initializeHouses() {
        for (int i = 0; i < 5; i++) {
            House house = new House(i + 1);
            house.resetHouseScore();
        }
    }

}