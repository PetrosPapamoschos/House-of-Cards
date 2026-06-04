import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


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
        new GameLogic();
        startGame();
    }

    public GameLogic() {
        player = new Player();
        deck = new Deck();
    }
    
    public static void startGame() {
        initializeHouses(HOUSE_COUNT);
        while (deck.getSize() > 0 && !areAllHousesClosed()) {
            printAllHouses();
            curCard = drawCard(deck);
            System.out.println("Card Drawn: " + curCard.getCardName() + " (" + curCard.getValue() + ")");
            printSuggestedHouses(curCard);

            houseChoice = promptForHouseChoice(curCard);
            House chosenHouse = HOUSES[houseChoice - 1];
            houseState = checkHouseScore(chosenHouse, curCard);
            chosenHouse.addCardToHouse(curCard);

            if (houseState == 31) {
                chosenHouse.resetHouseScore();
                player.addScore();
                System.out.println("House " + houseChoice + " scored 31. Your total score is: " + player.getTotalScore());
            } else if (houseState > 31) {
                chosenHouse.setHouseScore(houseState);
                chosenHouse.closeHouse();
                System.out.println("House " + houseChoice + " exceeded 31 and is now closed.");
            } else {
                chosenHouse.setHouseScore(houseState);
                System.out.println("Card added to House " + houseChoice + ". Current House Score: " + chosenHouse.getHouseScore());
            }

          
        }

        if (areAllHousesClosed()) {
            player.resetScore();
            System.out.println("All houses are closed. You lose and score 0 points.");
        } else {
            System.out.println("All cards have been placed. Final score: " + player.getTotalScore());
        }
    }




    public static boolean areAllHousesClosed() {
        for (House house : HOUSES) {
            if (!house.getIsHouseClosed()) {
                return false;
            }
        }
        return true;
    }


   
    public static int randomNumberGenerator(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    
    public static Card drawCard(Deck cards) { 
        int cardIndex = randomNumberGenerator(0, cards.getSize() - 1);
        Card drawnCard = cards.getCard(cardIndex);
        cards.removeCard(cardIndex); // Remove the drawn card from the deck
        return drawnCard;
    }

    //  public void addCardToHouse(House houseNumber, Card card) {
    //     cardsInHouse.addCardToHouse(card);
    // }

    public static int checkHouseScore(House houseNumber, Card card) {
        if (houseNumber.getIsHouseClosed()) {
            return -1;
        }

        int currentHouseScore = houseNumber.getHouseScore();
        int cardValue = card.getValue();
        return currentHouseScore + cardValue;
    }

    public static boolean wouldHouseClose(House houseNumber, Card card) {
        return !houseNumber.getIsHouseClosed() && houseNumber.getHouseScore() + card.getValue() > 31;
    }

    public static boolean hasAlternativeHouseWithoutClosing(Card card, int excludedHouseIndex) {
        for (int i = 0; i < HOUSES.length; i++) {
            if (i == excludedHouseIndex) {
                continue;
            }

            House house = HOUSES[i];
            if (house != null && !house.getIsHouseClosed() && house.getHouseScore() + card.getValue() <= 31) {
                return true;
            }
        }

        return false;
    }

    public static List<Integer> getThirtyOneHouseSuggestions(Card card) {
        List<Integer> suggestions = new ArrayList<Integer>();

        for (int i = 0; i < HOUSES.length; i++) {
            House house = HOUSES[i];
            if (house != null && !house.getIsHouseClosed() && house.getHouseScore() + card.getValue() == 31) {
                suggestions.add(house.getHouseNumber());
            }
        }

        return suggestions;
    }

    public static void addCardValueToHouseScore(House houseNumber, Card card) {
        int cardValue = card.getValue();
        int newHouseScore = houseNumber.getHouseScore() + cardValue;
        houseNumber.setHouseScore(newHouseScore);
    }

    public static void initializeHouses(int HOUSE_COUNT) {
        for (int i = 0; i < HOUSE_COUNT; i++) {
            HOUSES[i] = new House(i + 1);
        }
    }

    public static int promptForHouseChoice(Card card) {
        while (true) {
            System.out.print("Choose a house (1-" + HOUSE_COUNT + "): ");
            if (!SCAN.hasNextInt()) {
                SCAN.next();
                System.out.println("Please enter a number from 1 to " + HOUSE_COUNT + ".");
                continue;
            }

            int choice = SCAN.nextInt();
            if (choice < 1 || choice > HOUSE_COUNT) {
                System.out.println("Please enter a number from 1 to " + HOUSE_COUNT + ".");
                continue;
            }

            if (HOUSES[choice - 1].getIsHouseClosed()) {
                System.out.println("House " + choice + " is closed. Choose another house.");
                continue;
            }

            if (wouldHouseClose(HOUSES[choice - 1], card) && hasAlternativeHouseWithoutClosing(card, choice - 1)) {
                System.out.println("That move would close House " + choice + ", but a non-closing alternative exists. Choose another house.");
                continue;
            }

            return choice;
        }
    }

    public static void printAllHouses(){
        for (House house : HOUSES) {
            if (house != null) {
                String status = house.getIsHouseClosed() ? "Closed" : "Open";
                System.out.println("House(" + house.getHouseNumber() + ") [" + status + "], Score: " + house.getHouseScore() + ", Cards: " + house.getCardsInHouse());
            }
        }
    }

    public static void printSuggestedHouses(Card card) {
        List<Integer> suggestions = getThirtyOneHouseSuggestions(card);
        if (suggestions.isEmpty()) {
            System.out.println("No house will reach 31 with this card.");
            return;
        }

        System.out.println("Suggested house(s) for 31: " + suggestions);
    }

}


   

