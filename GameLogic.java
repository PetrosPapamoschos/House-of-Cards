import java.util.Random;
import java.util.Scanner;


public class GameLogic {
    
    private final static int HOUSE_COUNT = 4;
    private final static House[] HOUSES = new House[HOUSE_COUNT];
    private static Player player;
    private static Deck deck;
    private static Card curCard;
    private final static Scanner SCAN = new Scanner(System.in);
    private static int houseChoice;
    private static int houseState;


    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        startGame();
    }

    public GameLogic() {
        player = new Player();
        deck = new Deck();
    }
    
    public static void startGame() {
        initializeHouses(HOUSE_COUNT);
        while (true) {
        printAllHouses();
        curCard = drawCard(deck);
        System.out.println("Card Drawn: " + curCard.getCardName() + ". Which house do you want to place the card in?");
        while((houseState == -1 || houseState == 31) && !areAllHousesUnavailable()){
        houseChoice = SCAN.nextInt();
        houseState = checkHouseScore(HOUSES[houseChoice - 1], curCard);
        if (houseState == -1) {
            HOUSES[houseChoice - 1].closeHouse(houseChoice);
            System.out.println("House " + houseChoice + " is not available.");
        } else if (houseState == 31) {
            player.addScore();
            HOUSES[houseChoice - 1].setHouseScore(0);
            System.out.println("Scored. Your total score is: " + player.getTotalScore());
        } else {
            HOUSES[houseChoice - 1].setHouseScore(houseState);
            System.out.println("Card added to House " + houseChoice + ". Current House Score: " + HOUSES[houseChoice - 1].getHouseScore());
        }
        }
        System.out.println("Meow");

    }


        
    }
   

    public static boolean areAllHousesUnavailable() {
        for (House house : HOUSES) {
            if (checkHouseScore(house, curCard) != -1) {
                return false; // At least one house is still available
            }
        }
        return true; // All houses are unavailable
    }


    public static int randomNumberGenerator(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    
    public static Card drawCard(Deck cards) { //deck
        int cardIndex = randomNumberGenerator(0, cards.getSize() - 1);
        Card drawnCard = cards.getCard(cardIndex);
        cards.removeCard(cardIndex); // Remove the drawn card from the deck
        return drawnCard;
    }

    //  public void addCardToHouse(House houseNumber, Card card) {
    //     cardsInHouse.addCardToHouse(card);
    // }

    public static int checkHouseScore(House houseNumber, Card card) {
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

    public static void initializeHouses(int HOUSE_COUNT) {
        for (int i = 0; i < HOUSE_COUNT; i++) {
            HOUSES[i] = new House(i + 1);
        }
    }
    public static void printAllHouses(){
        for (House house : HOUSES) {
            if (house != null) {
                System.out.println("House(" + house.getHouseNumber() + "), Score:" + house.getHouseScore());
            }
        }
    }

}