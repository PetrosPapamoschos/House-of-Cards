import java.util.Random;

public class GameLogic {
    
    private final static int HOUSE_COUNT = 4;

    public static void main(String[] args) {

    }

    public static int randomNumberGenerator(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    
    public Card drawCard(Deck cards) {
        int cardIndex = randomNumberGenerator(1, cards.getSize() - 1); // Generate a random index for the card to draw
        Card drawnCard = cards.getCard(cardIndex);
        cards.removeCard(cardIndex); // Remove the drawn card from the deck
        return drawnCard;
    }

     public void addCardToHouse(House houseNumber, Card card) {
        cardsInHouse.addCardToHouse(card);
    }

    public int checkHouseScore(House houseNumber, Card card) {
        int currentHouseScore = houseNumber.getHouseScore();
        int cardValue = card.getValue();
        int newHouseScore = currentHouseScore + cardValue;
        if (newHouseScore < 31) {
            return newHouseScore; // House is not closed
        } else if (newHouseScore == 31) {
            return 31; //Player takes points
        } else {
            return -1; //House will be closed 
        }
    }

    public void addCardValueToHouseScore(House houseNumber, Card card) {
        int cardValue = card.getValue();
        int newHouseScore = houseNumber.getHouseScore() + cardValue;
        houseNumber.setHouseScore(newHouseScore);
    }

    public House initializeHouses(int HOUSE_COUNT) {
        for(int i = 0; i <= HOUSE_COUNT; i++){
            return new House(i);
        }
    }
    public void printAllHouses(){
        for (int i = 0; i<=HOUSE_COUNT, i++){
            System.out.println("House(" + i + "), Score:" + houseScore);
        }3
    }

}