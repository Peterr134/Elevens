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

    public boolean isEmpty(){
        return deck.size() == 0;
    }

    public int size(){
        return deck.size();
    }

    public Card deal(){
        if(deck.isEmpty()){
            return null;
        }else{
            size--;
            return deck.get(size);
        }
    }
}
