/**
 * This public class "Letter" represents a letter,
 * which has a character and a label.
 * Each Letter instance has a letter and a label.
 * The label indicates the status of the letter.
 * @author Adit Bhimani
 */

public class Letter {
    private char letter; // the letter
    private int label; // the appropriate label for the letter

    public static final int unsetLetter = 0; // A constant for a unset letter
    public static final int unusedLetter = 1; // A constant for a unused letter
    public static final int usedLetter = 2; // A constant for a used letter
    public static final int correctLetter = 3; // A constant for a correct letter

    /**
     * This public letter constructor below
     * initializes a Letter with the provided character.
     * The label is initialized to be unset.
     * @param c the character
     */

    public Letter(char c) {
        this.letter = c;
        this.label = unsetLetter;
    }

    /**
     * This public boolean equals method checks
     * if this Letter is equal to another object.
     * If the other object is a Letter,
     * it checks if their characters are the same.
     * @param otherObject the object to compare with this Letter
     * @return true if the objects are equal, false otherwise
     */

    public boolean equals(Object otherObject) {
        if (otherObject instanceof Letter) {
            Letter otherLetter = (Letter) otherObject;
            return this.letter == otherLetter.letter;
        }
        return false;
    }

    /**
     * This public string method below returns a decorator
     * according to the label of this Letter by using switch.
     * The decorator is '+' for a used letter,
     * '-' for an unused letter, '!' for a correct letter,
     * and ' ' for an unset letter.
     * @return the decorator
     */

    public String decorator() {
        switch (label) {
            case usedLetter:
                return "+";
            case unusedLetter:
                return "-";
            case correctLetter:
                return "!";
            default:
                return " ";
        }
    }

    /**
     * This public String toString method returns
     * a string representation of this Letter.
     * The string representation is the character of the letter
     * surrounded by decorators.
     * @return the string representation of this Letter
     */

    @Override
    public String toString() {
        return decorator() + letter + decorator();
    }

    /**
     * Sets the label of this Letter to unused.
     */
    public void setUnused() {
        label = unusedLetter;
    }

    /**
     * Sets the label of this Letter to unused.
     */
    public void setUsed() {
        label = usedLetter;
    }

    /**
     * Sets the label of this Letter to used.
     */
    public void setCorrect() {
        label = correctLetter;
    }

    /**
     * Sets the label of this Letter to correct.
     * @return true if the label is unused, otherwise, return false
     */
    public boolean isUnused() {
        return label == unusedLetter;
    }

    /**
     * This public static Letter method converts
     * a string to an array of Letters.
     * Each character in the string is converted to a Letter.
     * @param s the string
     * @return returns the array of Letters
     */


    public static Letter[] fromString(String s) {
        Letter[] letters = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            letters[i] = new Letter(s.charAt(i));
        }
        return letters;
    }

}