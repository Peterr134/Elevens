import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevensRunner {
    public static void main(String[] args) {
        ElevensBoard board = new ElevensBoard();
        board.newGame();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if (board.anotherPlayIsPossible()) {
                System.out.println(board.toString());
                System.out.println("Remaning cards in deck: " + board.deckSize());
                System.out.println("Type the cards you wish to select in this format: 1,2,3");
                String input = scanner.nextLine();
                if(input.equals("Win")){
                    board.win();
                    System.out.println(board.toString());
                    System.out.println("Remaning cards in deck: " + board.deckSize());
                    System.out.println("Type the cards you wish to select in this format: 1,2,3");
                    input = scanner.nextLine();
                }
                    List<Integer> selectedCards = new ArrayList<Integer>();
                    String[] nums = input.split(",");
                    for (String num : nums) {
                        selectedCards.add(Integer.parseInt(num));
                    }
                if (board.isLegal(selectedCards)) {
                    board.replaceSelectedCards(selectedCards);
                    if (board.gameIsWon()) {
                        System.out.println("You win!");
                        break;
                    }
                } else {
                    System.out.println("That's not a legal move!");
                }
            }else{
                break;
            }
        }
    }
}
