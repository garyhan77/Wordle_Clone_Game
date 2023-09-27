/**
 * This class represents a word in the format of a singly-linked list
 * @author Tianyi Han
 */
public class Word {
    /**
     * New LinearNode of type Letter
     */
    private LinearNode<Letter> firstLetter;

    /**
     * This method represents a word consisting of multiple letters in the form of a linked list
     * @param letters
     */
    public Word(Letter[] letters){
        firstLetter = new LinearNode<>();
        firstLetter.setElement(letters[0]);
        LinearNode<Letter> headNode = firstLetter;
        for(int i = 1; i< letters.length; i++){
            LinearNode<Letter> newletter = new LinearNode<Letter>();
            newletter.setElement(letters[i]);
            headNode.setNext(newletter);
            headNode = headNode.getNext();
        }
    }

    /**
     * This is a toString method outputting the users guess
     * @return a string represention of users last guess
     */
    public String toString(){
        String finalString = "";
        finalString += "Word: ";
        LinearNode<Letter> tempNode = firstLetter;
        while(tempNode != null){
            finalString += tempNode.getElement().toString();
            finalString += " ";
            tempNode = tempNode.getNext();
        }
        return finalString;
    }

    /**
     * This method modifies the users guess, labeling each letter with its label respective to the mystery word
     * @param mystery
     * @return users guess word with every letter labelled with its correct labels
     */
    public boolean labelWord(Word mystery){
        int count = 0;
        String mysString = mystery.toString();

        Letter[] result = new Letter[(mysString.length()-6)/4];
        for (int i = 6; i < mysString.length(); i+=4) {
            result[(i-6)/4] = new Letter(mysString.charAt(i+1));
        }
        LinearNode<Letter> tempNode = firstLetter;
        while(tempNode != null){
            boolean foundUsed = false;
            for(int i = 0; i < result.length; i++){
                if(result[i].equals(tempNode.getElement())){
                    tempNode.getElement().setUsed();
                    foundUsed = true;
                }
            }
            if(foundUsed == false){
                tempNode.getElement().setUnused();
            }
            tempNode = tempNode.getNext();
        }

        tempNode = firstLetter;
        boolean setCorrect = true;
        while(tempNode != null && count < result.length){

            if(tempNode.getElement().equals(result[count])){
                tempNode.getElement().setCorrect();
            }
            else{
                setCorrect = false;
            }
            tempNode = tempNode.getNext();
            count++;
        }
        if(tempNode == null && count == result.length && setCorrect == true){
            return true;
        }
        return false;
    }

    /*public static void main(String[] args) {
        Letter[] arr = new Letter[4];
        arr[0] = new Letter('F');
        arr[1] = new Letter('I');
        arr[2] = new Letter('S');
        arr[3] = new Letter('H');

        Letter[] arr2 = new Letter[4];
        arr2[0] = new Letter('F');
        arr2[1] = new Letter('I');
        arr2[2] = new Letter('S');
        arr2[3] = new Letter('H');

        Word word2 = new Word(arr2);

        Word newWord = new Word(arr);

        newWord.labelWord(word2);
        System.out.println(newWord);

    }*/
}
