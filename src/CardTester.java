/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        Card card1 = new Card("Ace", "Spades", 1);
        Card card2 = new Card("4", "Hearts", 4);
        Card card3 = new Card("10", "Clubs", 10);
        System.out.println(card1.toString());
        System.out.println(card1.matches(card2));
        Deck deck = new Deck(new String[]{"Queen", "King", "Rook", "Bishop", "Knight", "Pawn"}, new String[]{"White", "Black"}, new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(deck.deal().toString());
        System.out.println(deck.isEmpty());
        System.out.println(deck.size());
    }
}