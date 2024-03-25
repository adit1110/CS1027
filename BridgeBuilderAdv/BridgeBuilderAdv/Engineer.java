package BridgeBuilderAdv;

import java.util.Random;

/**
 	* This Engineer Class below is the main code for the Engineer's side of the game
 	* 
 	* @author Adit Bhimani
 	* @param token (engineer's token)
 	* @param hardMode (is under a boolean to determine what the difficulty for the Engineer selected is)
 	* @param random (RNG for the engineer)
*/

public class Engineer {
	private char token; // Engineer's token
	private boolean hardMode; // the flag to determine the mode of the Engineer's difficulty
	private Random random; // RNG for the engineer
	
	
/**
	* Constructor for the Engineer class.
	* It initializes the Engineer with the specified mode (hard or not).
	* Sets the default token to '0' and initializes the random number generator.
	*
	* @param hardMode the mode of the Engineer (true for hard mode, false for normal mode)
*/
	public Engineer(boolean hardMode) {
		token = '0';
		this.hardMode = hardMode;
		random = new Random();
	}

/**
	 * Makes a move for the Engineer on the game board.
	 * The move is based on the mode of the Engineer (hard or not).
	 *
	 * @param board the game board object
	 * @param playerLastRow the row index of the player's last move
	 * @param playerLastCol the column index of the player's last move
*/
	public void makeMove(GameBoard board, int playerLastRow, int playerLastCol) {
		int size = board.getSize();
		
		
		if(hardMode) {
			int boardRow = playerLastRow;
			int boardCol = playerLastCol + 1;
			
			while (boardRow < size) { // Iterate over the row to the right of the player's last position
				if (boardCol >= size) {
					boardRow++; // Move to the next row if reached the end of the current row
					boardCol = 0;
				}
				if (board.isPositionEmpty(boardRow, boardCol)) {
					board.placeToken(boardRow, boardCol, token); // place the token at the empty position and return, if a empty position is found
					return;
				}
				boardCol++;
			}
			
			// If no empty space on the same row, perform top-down search
			for (boardRow = 0; boardRow < size; boardRow++) {
				// Iterate over each row in the same column as the player's last position
				if (board.isPositionEmpty(boardRow, boardCol)) {
					// Place the token at the empty position and return, if a empty position is found
					board.placeToken(boardRow, boardCol, token);
					return;
			}
		}
	} else {
		// Generate random positions until a empty position is found
		int boardRow, boardCol;
		do {
			boardRow = random.nextInt(size);
			boardCol = random.nextInt(size);
		} while (!board.isPositionEmpty(boardRow, boardCol));
		
		// place the token at the empty position
		board.placeToken(boardRow, boardCol, token);
	}
		
	}
		
/**
	* Returns the token associated with the Engineer.
	*
	* @return the Engineer's token
*/
	public char getToken() {
		return token;
	}

}
