public class ExtendedLetter extends Letter {
    private String content; // stores the letter's content
    private int family; // stores the family of the letter
    private boolean related; // is a indication whether the letter is related to a another letter in the word
    private static final int SINGLETON = -1; // constant declaration for a singleton family

    /**
     * This ExtendedLetter declaration above
     * is an extension from the Letter class,
     * with each instance having a content, a family, and a related flag
     * @author Adit Bhimani
     * @param content stores the letter's content
     * @param family stores the family of the letter
     * @param related is a indication whether the letter is related to a another letter in the word
     * @param SINGLETON constant declaration for a singleton family
     */


    /**
     * This public ExtendedLetter
     * is a constructor that initializes an ExtendedLetter
     * with the provided content.
     * The family is initialized to be a singleton and related is set to false.
     * @param s the content of the letter
     */

    public ExtendedLetter(String s) {
        super(' ');
        content = s;
        family = SINGLETON;
        related = false;
    }

    /**
     * This public ExtendedLetter is a similar constructor to the one above
     * that initializes an ExtendedLetter with the provided content.
     * The family is initialized to be a singleton and related is set to false.
     * @param s the content of the letter (same as above)
     * @param fam which is the family of the letter
     */

    public ExtendedLetter(String s, int fam) {
        super(' ');
        content = s;
        family = fam;
        related = false;
    }

    /**
     * This public boolean equals method
     * checks if this ExtendedLetter is equal to another object.
     * If the other object is an ExtendedLetter,
     * it checks if their content and family are the same.
     * This method also ovverides the equals method of the object class
     * @param other the object to compare with this ExtendedLetter
     * @return true if the objects are equal, false otherwise
     */

    @Override
    public boolean equals(Object other) {
        if (other instanceof ExtendedLetter) {
            ExtendedLetter otherLetter = (ExtendedLetter) other;
            if(otherLetter.family == this.family) {
                related = true; // set related to true if the families are the same
            }
            if (otherLetter.content == this.content) { // return true if the contents are the same
                return true;
            } else {
                return false; // if not; then return false
            }
        }
        return false;
    }

    /**
     * This toString method returns a string representation of this
     * ExtendedLetter.
     * If the letter is unused and related,
     * it adds '.' before and after the content.
     * Otherwise, it adds decorators before and after the content.
     * @return the string representation of this ExtendedLetter
     */

    @Override
    public String toString() {
        if (isUnused() && related) {
            return "." + content + ".";
        } else {
            return decorator() + content + decorator();
        }
    }

    /**
     * Converts arrays of contents and codes to an array of Letters.
     * Throws an exception if the length of the two arrays is not equal.
     * @param content the array of contents
     * @param codes the array of codes
     * @return the array of Letters
     * @throws IllegalArgumentException if the lengths of the content
     * and codes arrays are not equal
     */

    public static Letter[] fromStrings(String[] content, int[] codes) {
        if (content.length != codes.length) {
            throw new IllegalArgumentException("Content and codes arrays must have the same length.");
        }

        Letter[] letters = new Letter[content.length];
        for (int i = 0; i < content.length; i++) {
            // Create an ExtendedLetter with a family if the code is not SINGLETON
            if (codes[i] != SINGLETON) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            } else {
                // Create an ExtendedLetter without a family if the code is SINGLETON
                letters[i] = new ExtendedLetter(content[i]);
            }
        }
        return letters;
    }
}