    /**
    * This class "WordLL" represents a word linked list, which is a list of Word nodes.
    * Each WordLL instance has a mystery word and a history of guessed words.
    *
    * @author Adit Bhimani
    */


    /** 150 word explanation:
     * I designed the WordLL class with the main purpose of maintaining a list of Word objects,
     * which helped in keeping track of the history of words that have been guessed.
     * The class mainly employs a linked list implementation, where each node is a Word.
     * Besides debugging towards the end, my second most significant challenge during the design process was in managing the history of guesses and
     * comparing these against the mystery word.
     * I addressed this issue by creating a 'tryWord' method.
     * This 'tryWord' method is responsible for labeling the guessed word, adding it to the history, and verifying if it matches the mystery word.
     * I also had thoroughly tested my solution by creating multiple WordLL instances,
     * with each having a different mystery word and a sequence of guesses.
     * I also made sure to check such cases, where there are no guesses or when the first guess is the correct answer.
     * In conclusion, the WordLL class plays a crucial role in the overall larger system of the program,
     * where it maintains the state and history of the word guessing process, thereby facilitating the tracking and validation of the guessing process.
     */

public class WordLL {
    private Word mysteryWord; // this is the mystery word to guess
    private LinearNode<Word> history; // this is the saved history of words that were previously guessed

    /**
     * This public WordLL constructor above
     * initializes a WordLL with the provided mystery word.
     * @param mystery is the mystery word
     */

    public WordLL(Word mystery) {
        mysteryWord = mystery;
        history = null;
    }


    public boolean tryWord(Word guess) {
        guess.labelWord(mysteryWord);

        LinearNode<Word> newNode = new LinearNode<>(guess);
        newNode.setNext(history);
        history = newNode;

        return guess.toString().equals(mysteryWord.toString());
    }

    /**
     * This public boolean tryWord method above tries a guessed word.
     * It labels the guessed word according to the mystery word
     * and adds it to the history.
     * If the string representation of the guessed word
     * is equal to the string representation of the mystery word,
     * it returns true. Otherwise, it returns false.
     * @param guess the guessed word
     * @param history is set to a new node
     * @return true if the guessed word is equal to the mystery word,
     * false otherwise
     */

    /**
     * This public String toString below
     * returns a string representation of this WordLL.
     * The string representation is a concatenation of the string representations
     * of all the words in the history, separated by new lines.
     * @return the string representation of this WordLL
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<Word> currentNode = history;
        while (currentNode != null) {
            sb.append(currentNode.getElement().toString()).append("\n");
            currentNode = currentNode.getNext();
        }
        return sb.toString();
    }
}