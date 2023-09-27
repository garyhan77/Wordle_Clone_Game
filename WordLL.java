/**
 * This class represent a history of all of the user's guesses made in this round
 * @author Tianyi Han
 */

/**
 * When designing this class, there was some highs and lows. To begin, setting up the variables and contructor
 * was pretty straight forward. As far as the tryWord method goes, i first called the labelWord method on guess
 * passing through the mystery word as a parameter. Then i created a new LinearNode of type word to store the guess word
 * This is so i can add it to the history linked list. To prepend the node to history i had to consider 2 cases.
 * First of all, what if there were no words stored in history? That means i have to set the node newGuess to history.
 * Secondly, if history has something in the then we have to modify its pointers so that our newGuess is the head node
 * To achieve this, we set the node after newGuess to history which "appends" everything in history to the end of newGuess.
 * Then we set history to newGuess to update history. There was an issue in the toString method where my history was being
 * deleted everytime the while loop ran. This was caused by making changes to history directly which results in me losing
 * reference. I fixed this issue my making temp node and set it to history. This way i don't lose reference to the original linked list
 */
public class WordLL {

    /**
     * a random word the user needs to guess
     */
    private Word mysteryWord;
    /**
     * a linked list storing a list of word guessed my the user
     */
    private LinearNode<Word> history;

    /**
     * Constructor initializing the history linked list and the mystery word
     * @param mystery
     */
    public WordLL(Word mystery){
        history = null;
        mysteryWord = mystery;
    }

    /**
     * this method prepends the new guess to the front of the history. It will return true if the guess
     * is identical to mystery word and return false otherwise
     * @param guess
     * @return true or false respectively
     */
    public boolean tryWord(Word guess){
        guess.labelWord(mysteryWord);
        LinearNode<Word> newGuess = new LinearNode<>(guess);
        if(history == null){
            history = newGuess;
        }
        else{
            newGuess.setNext(history);
            history = newGuess;
        }
        if(guess.equals(mysteryWord)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * toString method construct a list of string for each of the guess in history
     * @return string representation of entire guess history
     */
    public String toString(){
        String finalString = "";
        LinearNode<Word> tempNode = history;
        while(tempNode!=null){
            finalString += tempNode.getElement().toString();
            finalString += "\n";
            tempNode = tempNode.getNext();
        }

        return finalString;
    }
}
