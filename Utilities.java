//import java.util.Random;
import java.util.Scanner;

public class Utilities {

    public void printAllHouses(){
        for (House house : HOUSES) {
            if (house != null) {
                System.out.println("House(" + house.getHouseNumber() + "), Score:" + house.getHouseScore());
            }
        }
    }
    public void printAtStart(){
        System.out.println("Welcome! The game is about to start. Please provide the player's name:");
        Scanner scan = new Scanner(System.in);
        String playerName = scan.nextLine();
        player.setName(playerName);
        scan.close();
        System.out.println("Nice to meet you " + player.getName() + "!");
    }
    public void printAtEnd(){
        System.out.println("The Game is over! Your final score is: " + player.getTotalScore());
    }

    public void displayMenu(){
        for(int i = 0; i <= HOUSES.size(); i++){
        System.out.println("Please choose a house to add the card to:\n Current state of houses:" + HOUSES.displayHouse(houseNumber));
        }
    }

    public void displayHouse(int houseNumber){
        System.out.println("House" + houseNumber + "has" + HOUSES[houseNumber].getValue + "points.");
        System.out.println("The cards in this house are:");
            System.out.println(HOUSES[houseNumber].getCardsInHouse());
    }
}