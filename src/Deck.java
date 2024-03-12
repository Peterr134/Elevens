import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck;
    int size;

    public Deck(String[] names, String[] suits, int[] pointValues){
        deck = new ArrayList<Card>();
        for(int i = 0; i < suits.length; i++){
            for(int j = 0; j < names.length; j++){
                deck.add(new Card(names[j], suits[i], pointValues[j]));
            }
        }
        size = deck.size();
    }

    public Deck(ArrayList<Card> cards){
        deck = new ArrayList<Card>();
        for(int i = 0; i < cards.size(); i++){
            deck.add(cards.get(i));
        }
        size = deck.size();
    }

    public boolean isEmpty(){
        return deck.size() == 0;
    }

    public int size(){
        return deck.size();
    }

    public Card get(int num){
        return deck.get(num);
    }

    public void add(Card newCard){
        deck.add(newCard);
        size++;
    }

    public void massAdd(ArrayList<Card> cardsList){
        for(Card card : cardsList){
            deck.add(card);
            size++;
        }
    }

    public void removeAll(){
        deck = new ArrayList<Card>();
        size = 0;
    }

    public Card deal(){
        if(deck.isEmpty()){
            return null;
        }else{
            size--;
            return deck.remove(size);
        }
    }

    public void shuffle() {
        for(int i = deck.size()-1; i > 0; i--){
            int random = (int)(Math.random() * i);
            Card storedValue = deck.get(i);
            deck.set(i,deck.get(random));
            deck.set(random, storedValue);
        }
    }
}
