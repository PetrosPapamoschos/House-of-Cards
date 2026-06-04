public class Card{
    private int suit;
    private int rank;

    //private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    //private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue(){
        if(rank >= 2 && rank <= 10) {
            return rank;
        } else if(rank >= 11 && rank <= 13) {
            return 10;
        } else if(rank == 14) {
            return 11; 
        } else {
            return 0; // Invalid card
        }
    }

    public String getCardName() {
        String suitName;
        String rankName;

        switch (suit) {
            case 0: suitName = "♥"; break;
            case 1: suitName = "♦"; break;
            case 2: suitName = "♣"; break;
            case 3: suitName = "♠"; break;
            default: suitName = "Unknown Suit"; break;
        }

        switch (rank) {
            case 2: rankName = "2"; break;
            case 3: rankName = "3"; break;
            case 4: rankName = "4"; break;
            case 5: rankName = "5"; break;
            case 6: rankName = "6"; break;
            case 7: rankName = "7"; break;
            case 8: rankName = "8"; break;
            case 9: rankName = "9"; break;
            case 10: rankName = "10"; break;
            case 11: rankName = "Jack"; break;
            case 12: rankName = "Queen"; break;
            case 13: rankName = "King"; break;
            case 14: rankName = "Ace"; break;
            default: rankName = "Unknown Rank"; break;
        }

        return rankName + " of " + suitName;
    }

    @Override
    public String toString() {
        return getCardName();
    }
//    public int getRank() {
//        return rank;
//    }
    // public int getSuit() {
    //     return suit;
    // }

    // public int getRank() {
    //     return rank;
    // }

    // @Override
    // public String toString() {
    //     return rank + " of " + suit;
    // }
    // public String getCardName(int suit, int rank) {
    //     if(suit == 0) {
    //         return rank + " of Hearts";
    //     } else if(suit == 1) {
    //         return rank + " of Diamonds";
    //     } else if(suit == 2) {
    //         return rank + " of Clubs";
    //     } else if(suit == 3) {
    //         return rank + " of Spades";
    //     } else {
    //         return "Invalid card";
    //     }
    // }
}