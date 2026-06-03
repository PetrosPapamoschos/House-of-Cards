public class Card{
    private int suit;
    private int rank;

    //private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    //private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    public String getCardName(int suit, int rank) {
        if(suit == 0) {
            return rank + " of Hearts";
        } else if(suit == 1) {
            return rank + " of Diamonds";
        } else if(suit == 2) {
            return rank + " of Clubs";
        } else if(suit == 3) {
            return rank + " of Spades";
        } else {
            return "Invalid card";
        }
    }
}