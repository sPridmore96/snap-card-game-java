import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DeckOfCards {
    private static List<Card> deck = new ArrayList<>();
    public static List<Card> getUsedDeck() {
        return usedDeck;
    }
    public static void handleDeckRemake(){
        deck.addAll(usedDeck);
        shuffleTheDeck();
    }
    private static final List<Card> usedDeck = new ArrayList<>();
    public static List<Card> getDeck() {
        return deck;
    }

    static {
        for (int i = 0; i < Card.getSymbolsArr().length; i++) {
            for (int j = 0; j < Card.getValuesArr().length; j++) {
                Card card = new Card(Card.getNamesArr()[j], Card.getValuesArr()[j], Card.getSymbolsArr()[i]);
                deck.add(card);
            }
        }
    }
    public static void setDeck(List<Card> deck) {
        DeckOfCards.deck = deck;
    }
    public static void printDeck() {
        deck.forEach(card -> card.getCardInfo());
    }
    public static void shuffleTheDeck() {
        List<Card> shuffledDeck = deck;
        Collections.shuffle(shuffledDeck);
        setDeck(shuffledDeck);
    }
    public static ArrayList<Card> sortDeckInNumberOrder() {
        ArrayList<Card> numberDeck = (ArrayList<Card>) deck.stream()
                .sorted(Comparator.comparing(Card::getValue))
                .collect(Collectors.toList());
        return numberDeck;
    }
    public static ArrayList<Card> sortDeckBySuit() {
        return (ArrayList<Card>) deck.stream()
                .sorted(Comparator.comparing(Card::getSymbol))
                .collect(Collectors.toList());
    }
    public static Card dealCard() {
        Card userCard =  deck.get(0);
        deck.remove(userCard);
        usedDeck.add(userCard);
        userCard.getCardInfo();
        return userCard;
    }
}
