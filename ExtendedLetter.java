/**
 * This class represents a subclass of Letter and extends the functionality
 * @author Tianyi Han
 */
public class ExtendedLetter extends Letter {
    /**
     * content of the extended letter
     */
    private String content;
    /**
     * family of the extended letter
     */
    private int family;
    /**
     * boolean value stating whether the contents are related
     */
    private boolean related;
    /**
     * a constant to make sure family stays constant
     */
    private final int SINGLETON = -1;

    /**
     * Constructor to initialize all variables
     * @param s
     */
    public ExtendedLetter(String s){
        super('c');
        content = s;
        related = false;
        family = SINGLETON;
    }

    /**
     * Constructor to initialize variables (including fam for family)
     * @param s
     * @param fam
     */
    public ExtendedLetter(String s, int fam){
        super('c');
        content = s;
        related = false;
        family = fam;
    }

    /**
     * equals method checks if two objects are equal. It first checks to see if other is a instance of the ExtendeLetter class
     * then sets related to true if they belong in the same family. Lastly, it returns true if both objects content equals
     * otherwise it will return false
     * @param other
     * @return true or false respectively
     */
    public boolean equals(Object other){
        if(!(other instanceof ExtendedLetter)){
            return false;
        }
        if(((ExtendedLetter) other).family == this.family){
            this.related = true;
        }
        if(((ExtendedLetter) other).content.equals(this.content)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * toString method constructs a string in the format of .content., where content is a string
     * @return string representation of labeled content
     */
    @Override
    public String toString(){
        String decor = decorator();
        if(this.isUnused() && this.related){
            return "." + this.content + ".";
        }
        else{
            return decor + this.content + decor;
        }

    }

    /**
     * This method constructs an array letters, if codes is null the i-th entry of array will store an ExtendedLetter object created with the constructor ExtendedLetter(content[i])
     * if codes is not null the i-th entry of array letters will store an ExtendedLetter object created with the constructor ExtendedLetter(content[i],codes[i])
     * @param content
     * @param codes
     * @return the letters array of type Letter[]
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        for (int i = 0; i < content.length; i++) {
            if (codes == null) {
                letters[i] = new ExtendedLetter(content[i]);
            } else {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }
        return letters;
    }
}
