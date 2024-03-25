    /**
    * This Word class represents a word, which is a list of letters.
    * Each instance of Word is composed of a linked list of Letter nodes,
    * which starts from the first letter.
    *
    * @author Adit Bhimani
    */

public class Word {
    private LinearNode<Letter> firstLetter;

    /**
     * This public Word constructor that initializes a Word with the provided array of letters.
     * If the array of letters is empty, the firstLetter is set to null.
     * Otherwise, a linked list of Letter nodes is created from the array of letters.
     * @param letters the array of letters
     */

    public Word(Letter[] letters) {
        if (letters.length == 0) {
            firstLetter = null;
        } else {
            firstLetter = new LinearNode<>(letters[0]);
            LinearNode<Letter> currentNode = firstLetter;
            for (int i = 1; i < letters.length; i++) {
                currentNode.setNext(new LinearNode<>(letters[i]));
                currentNode = currentNode.getNext();
            }
        }
    }

    /**
     * This public LinearNode returns the first letter of this Word.
     * @return the first letter of this Word
     */

    public LinearNode<Letter> getFirstLetter() {
        return firstLetter;
    }

    /**
     * This public toString method returns a string representation of this Word.
     * The string representation is a concatenation of the string representations
     * of all the letters in this Word, separated by spaces.
     * @return the string representation of this Word
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Word: ");
        LinearNode<Letter> currentNode = firstLetter;
        while (currentNode != null) {
            sb.append(currentNode.getElement().toString() + " ");
            currentNode = currentNode.getNext();
        }
        sb.append("");
        return sb.toString();
    }

    /**
     * This public boolean labelWord labels the Word according to another Word (the mystery word).
     * It sets each letter in this Word to unused at the beginning.
     * Then it compares each letter in this Word with each letter in the mystery Word.
     * If a letter in this Word is equal to a letter in the mystery Word,
     * it sets the letter in this Word to used.
     * If the indices of the equal letters are the same,
     * it sets the letter in this Word to correct.
     * If all letters in this Word are correct, it returns true.
     * Otherwise, it returns false.
     * @param mystery the mystery Word to compare with this Word
     * @return true if all letters in this Word are correct, false otherwise
     */

    public boolean labelWord(Word mystery) {
        LinearNode<Letter> currentNode = firstLetter;
        LinearNode<Letter> mysteryNode = mystery.firstLetter;

        boolean identical = true;
        int thisIndex = 0;
        int mysteryIndex = 0;
        int correctCounter = 0;
        while (currentNode != null){
            Letter currentLetter = currentNode.getElement();
            currentLetter.setUnused();
            mysteryIndex = 0;
            mysteryNode = mystery.firstLetter;

            while (mysteryNode != null){
                Letter mysteryLetter = mysteryNode.getElement();
                if (currentLetter.equals(mysteryLetter)){
                    currentLetter.setUsed();
                    if(thisIndex == mysteryIndex){
                        currentLetter.setCorrect();
                        correctCounter++;
                    }
                }
                mysteryNode = mysteryNode.getNext();
                mysteryIndex++;
            }

            currentNode = currentNode.getNext();
            thisIndex++;
        }


        if(correctCounter == thisIndex){
            identical = true; // returns true if the counter is right
        }
        else{
            identical = false; // returns false here
        }
        return identical;

    }

}
