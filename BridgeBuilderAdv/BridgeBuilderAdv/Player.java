package BridgeBuilderAdv;
/**
 	* This Player Class below is the main code for the player side of the game
 	* 
 	* @author Adit Bhimani
 	* @param player's token
 	* @param player's score
 */
public class Player {
	private char token;
	private int score;
	
/**
 	* The default constructor below sets the token and score
 	* 
 	* @param player's token (in a char, as a +)
 	* @param player's score and sets it to 0
 */
	
	public Player() {
		token = '+';
		score = 0;
	}
	
/**
 * This method takes in the board, row, and column parameters to make a move
 * 
 * @param board; takes in this for 
 * @param row; takes in this from the user to make a move on the appropriate row
 * @param col; takes in this value from the user to make a move on the appropriate column
 */
	public void makeMove(GameBoard board, int boardRow, int boardCol) {
		board.placeToken(boardRow, boardCol, token); // Place the player's token on the game board at the specified row and column

	}
/**
 * This method below returns the player's token
 * 
 * @return the player token
 * 
 */
	public char getToken() {
		return token; // return the player's token
	}
/**
 * This method returns the player's score
 * 
 * @return the player score
 */
	public int getScore() {
		return score; // return the player's current score
	}
/**
 * This method adds the specified increment to the player's score
 * 
 * @param increment the amount to increment the score by
 */
	public void addScore(int increment) {
		score += increment; // increase the player's score by the specific increment
	}		    
}
