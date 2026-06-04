import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class House {
    private int houseNumber;
    private int houseScore;
    private List<Card> cardsInHouse;
    private boolean isHouseClosed;

    public House(int houseNumber) {
        this.houseNumber = houseNumber;
        this.houseScore = 0;
        this.cardsInHouse = new ArrayList<Card>();
        this.isHouseClosed = false;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    public void setHouseScore(int houseScore) {
        this.houseScore = houseScore;
    }

    public int getHouseScore() {
        return houseScore;
    }
    public int getHouseNumber() {
        return houseNumber;
    }
    public boolean getIsHouseClosed() {
        return isHouseClosed;
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

//    public void resetHouseScore() {
//        this.houseScore = 0;
//    }
    public void closeHouse(int houseNumber) {
        this.isHouseClosed = true;
    }

    @Override
    public String toString() {
        return "House " + houseNumber + " has a score of " + houseScore;
    }

}