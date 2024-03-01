import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class WarRunner{

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"♠", "♥", "♦", "♣"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};


    public static void main(String[] args)
    {
        //beginningDeck is the Deck we start with.  When we deal, it gets split into two
        //Decks for each player
        Deck beginningDeck = new Deck(RANKS,SUITS,POINT_VALUES);
        beginningDeck.shuffle();
        //System.out.println(beginningDeck);
        ArrayList<Card> deck1List = new ArrayList<Card>();
        ArrayList<Card> deck2List = new ArrayList<Card>();
        for(int i = 0; i < beginningDeck.size()/2; i++){
            deck1List.add(beginningDeck.get(i));
        }
        for(int i = beginningDeck.size()/2; i < beginningDeck.size(); i++){
            deck2List.add(beginningDeck.get(i));
        }
        Deck deck1 = new Deck(deck1List);
        Deck deck2 = new Deck(deck2List);
        System.out.println("Welcome to Cards!");
        while(true){
            System.out.println("Type F to fight or S to shuffle!");
            Scanner scanner = new Scanner(System.in);
            String playerResp = scanner.nextLine();
            if(playerResp.equals("S")){
                System.out.println("Shuffled!");
                deck1.shuffle();
                deck2.shuffle();
            }else if(playerResp.equals("F")){
                Card played1 = deck1.deal();
                Card played2 = deck2.deal();
                System.out.println("You play " + played1 + ". The computer plays " + played2);
                if(played1.pointValue() > played2.pointValue()){
                    System.out.println("You take the cards");
                    deck1.add(played1);
                    deck1.add(played2);
                }else if(played2.pointValue() > played1.pointValue()){
                    System.out.println("The Computer takes the cards");
                    deck2.add(played1);
                    deck2.add(played2);
                }else{
                    System.out.println("Same point value! WARRRR!!");
                    ArrayList<Card> warCards = new ArrayList<Card>();
                    while(true) {
                        Card played1War = deck1.deal();
                        warCards.add(played1War);
                        System.out.println("Your face-up card is " + played1War);
                        Card played2War = deck2.deal();
                        warCards.add(played2War);
                        System.out.println("The computer's face-up card is " + played2War);
                        for (int i = 0; i < 2; i++) {
                            warCards.add(deck1.deal());
                            warCards.add(deck2.deal());
                        }
                        if(played1War.pointValue() != played2War.pointValue()){
                            if(played1War.pointValue() > played2War.pointValue()){
                                System.out.println("You win the war! + " + warCards.size() + " cards!");
                                deck1.massAdd(warCards);
                            }else{
                                System.out.println("You lose the war. + " + warCards.size() + " cards to computer");
                                deck2.massAdd(warCards);
                            }
                            break;
                        }
                        System.out.println("War continues...");
                    }
                }
            }
        }
    }
}
