import java.util.ArrayList;
import java.util.List;

public class House {
    private int houseNumber;
    private int houseScore;
    private List<Card> cardsInHouse;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
        this.houseScore = 0;
        this.cardsInHouse = new ArrayList<>();
    }
    public void setHouseScore(int houseScore) {
        this.houseScore = houseScore;
    }

    public int getHouseScore() {
        return houseScore;
    }
    public int calculateHouseScore(int houseNumber, int houseScore, ArrayList<Card> cardsInHouse) { 
        for (Card card : cardsInHouse) {
            houseScore += card.getValue();
        }
        return houseScore;
    }
    public void addCardToHouse(Card card) {
        cardsInHouse.add(card);
    }
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
//    public void resetHouseScore() {
//        this.houseScore = 0;
//    }

    @Override
    public String toString() {
        return "House " + houseNumber + " has a score of " + houseScore;
    }

    public void initializeHouses() {
        for (int i = 0; i < 4; i++) {
            House house = new House(i + 1);
            //house.setHouseNumber(i + 1);
            //house.resetHouseScore();
        }
    }

}