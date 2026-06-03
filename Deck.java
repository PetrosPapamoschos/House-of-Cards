import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 2; rank < 15; rank++) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public Card getCard(int index) {
        return cards.get(index);
    }
    public int getSize() {
        return cards.size();
    }
    public void removeCard(int index) {
        cards.remove(index);
    }
}