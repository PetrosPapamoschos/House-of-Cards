import java.util.Random;

public class GameLogic {
    
    private final static int HOUSE_COUNT = 4;
    private final House[] HOUSES = new House[HOUSE_COUNT];
    private Player player;
    private Deck deck;

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        game.initializeHouses(HOUSE_COUNT);
        
    }
   
    public static int randomNumberGenerator(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    
    public Card drawCard(Deck cards) { //deck
        int cardIndex = randomNumberGenerator(0, cards.getSize() - 1); // Generate a random index for the card to draw
        Card drawnCard = cards.getCard(cardIndex);
        cards.removeCard(cardIndex); // Remove the drawn card from the deck
        return drawnCard;
    }

    //  public void addCardToHouse(House houseNumber, Card card) {
    //     cardsInHouse.addCardToHouse(card);
    // }

    public int checkHouseScore(House houseNumber, Card card) {
        int currentHouseScore = houseNumber.getHouseScore();
        int cardValue = card.getValue();
        int newHouseScore = currentHouseScore + cardValue;
        if (newHouseScore < 31) {
            return newHouseScore; // House is not closed
        } else if (newHouseScore == 31) {
            return 31; //Player takes points
        } else {
            return -1; //House will be unavailable
        }
    }

    public void addCardValueToHouseScore(House houseNumber, Card card) {
        int cardValue = card.getValue();
        int newHouseScore = houseNumber.getHouseScore() + cardValue;
        houseNumber.setHouseScore(newHouseScore);
    }

    public void initializeHouses(int HOUSE_COUNT) {
        for (int i = 0; i < HOUSE_COUNT; i++) {
            HOUSES[i] = new House(i + 1);
        }
    }
   

}