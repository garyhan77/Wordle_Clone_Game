/**
 * This class represents a single letter of the word class
 * @author Tianyi Han
 */
public class Letter {

    /**
     * letter of a word represented by a character
     */
    private char letter;
    /**
     * label that determines the status of the letter
     */
    private int label;
    /**
     * Constants, possible status for label
     */
    private final int UNSET = 0;
    private final int UNUSED = 1;
    private final int USED = 2;
    private final int CORRECT = 3;

    /**
     * Constructor creates a letter with the given char and automatically sets label to UNSET to begin with
     * @param c
     */
    public Letter(char c){
        label = UNSET;
        letter = c;
    }

    /**
     * equals method that first checks if the parameter other object is of the class Letter
     * if so, it will compare the letter attribute of otherObject and this object and return true or false respectively
     * @param otherObject
     * @return boolean stating if the two objects being compare equals
     */
    public boolean equals(Object otherObject){
        if(!(otherObject instanceof Letter)){
            return false;
        }
        Letter otherLetter = (Letter) otherObject;
        return this.letter == otherLetter.letter;
    }

    /**
     * This method retrieves a string representation corresponding to a predetermined label value
     * @return a string representation of the label being assigned to the letter
     */
    public String decorator(){
        if (label == USED){
            return "+";
        }
        else if(label == UNUSED){
            return "-";
        }
        else if(label == CORRECT){
            return "!";
        }
        else if(label == UNSET){
            return " ";
        }
        else{
            return "Incorrect label";
        }
    }

    /**
     * This method takes the predetermined label from the decorator method and construct a string in the format of
     * "decor + letter + decor"
     * @return string representation of a labeled letter
     */
    @Override
    public String toString(){
        String decor = decorator();
        return decor + letter + decor;
    }

    /**
     * setter method to set the label to unused
     */
    public void setUnused(){
        label = UNUSED;
    }

    /**
     * setter method to set the label to used
     */
    public void setUsed(){
        label = USED;
    }

    /**
     * setter method to set the label to correct
     */
    public void setCorrect(){
        label = CORRECT;
    }

    /**
     * this method checks to see if the label is set to unused
     * @return true or false respectively
     */
    public boolean isUnused(){
        if(label == UNUSED){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * this method takes a string, breaks it up to singlar characters and store it in an array
     * @param s
     * @return an array storing the string as individual characters in the same order as the original string
     */
    public static Letter[] fromString(String s) {
        Letter[] result = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = new Letter(s.charAt(i));
        }
        return result;
    }
}
