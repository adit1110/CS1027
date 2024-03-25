package BridgeBuilderAdv;

import java.util.Arrays; // library importation for arrays

/**
 * 150 word explanation:
 * 
 * The GameBoard class represents the game board where the game will be played. The approach I had used towards designing the code involved creating a 2D char array 
 * to represent the board, with each position initialized to '.' to indicate an empty position. I also had used public methods, which were implemented
 * to place tokens on the board, and to check that if a position is empty, and retrieve the board size, display the board,
 * and to check for a win in different directions, and to check for a tie. The code follows a logical structure,
 * iterating over different rows and columns to perform the necessary checks and operations.
 * 
 * During development, the main challenge that I had mainly faced was ensuring that the indexing and handling of positions were being handled correctly
 * within the board. I gave careful attention to avoid any potential out-of-bounds errors and to properly handle any different win conditions. 
 * 
 * To ensure the correctness of the solution, I used the test cases that were given to me in the assignment page.
 * These test cases already did cover various aspects of the code, including board initialization, token placement,
 * checking for wins and ties, as well as the interaction between different classes. It all ran well and according to what the test cases were trying to show.
*/


/**
	* This GameBoard Class below is the main code for the GameBoard side of the game
	* 
	* @author Adit Bhimani
	* @param char [][] board (the shape of the board)
	* @param int size (basic declaration of the size of the board)
*/

public class GameBoard {
	private char [][] board; // this is an 2D array which is initialized to represent the game board
	private int size; // this private size variable declares the size of the board

/**
 	* This GameBoard Class below is the main code for the GameBoard side of the game
 	* The size of the board gets initialized with a value given by the user
 	* All of the positions are initially set to "."
 	* 
 	* @param size (the size of the game board)
*/	

	public GameBoard(int size) {
		this.size = size;
		board = new char[size][size];
		for (char[] boardRow: board) {
			Arrays.fill(boardRow, '.'); // the board is initialized with "." all around
		}
	}

/**
	 * This placeToken method places the specified token at the given row and column on the game board.
	 *
	 * @param boardRow the row index to place the token
	 * @param boardCol the column index to place the token
	 * @param token the token to be placed on the board
*/
	public void placeToken(int boardRow, int boardCol, char token) {
		board[boardRow][boardCol] = token; // the token is placed at the specified row and column on the game board
	}

/**
	 * This isPositionEmpty method checks if the specified position on the board is empty (contains '.').
	 *
	 * @param boardRow the row index to check
	 * @param boardCol the column index to check
	 * @return true if the position is empty, false otherwise
*/	
	public boolean isPositionEmpty(int boardRow, int boardCol) {
		return board[boardRow][boardCol] == '.'; // Check whether the specified position on the board is empty (denoted by '.')
	}
/**
	 * This getSize method returns the size of the game board.
	 *
	 * @return the size of the game board
*/
	public int getSize() {
		return size; // return the size of the board
	}

/**
	 * Displays the current state of the game board.
	 * Prints the column headers and the contents of each cell.
*/
	public void displayBoard() {
		System.out.print("  ");
		for (int boardCol = 0; boardCol < size; boardCol++) {
			System.out.print((char) ('A' + boardCol) + " ");
		}
		System.out.println();
		
		for(int boardRow = 0; boardRow < size; boardRow++) { // this for loop prints the board onto the console, including the row and column numbers
			System.out.print(boardRow + " ");
			for (int boardCol = 0; boardCol < size; boardCol++ ) {
				System.out.print(board[boardRow][boardCol] + " ");
			}
			System.out.println();
		}
	}

/**
	 * Checks if the specified player has won in any direction on the game board.
	 *
	 * @param player the player object whose token is checked for a win
	 * @return 1 if the player has won horizontally, 3 if the player has won diagonally, 0 if no win
*/
	public int checkForWinDirection(Player player) {
		char playerToken = player.getToken();
		
		   // Check for a left-to-right win
	    for (int row = 0; row < size; row++) {
	        boolean win = true;
	        for (int col = 0; col < size; col++) {
	            if (board[row][col] != playerToken) {
	                win = false;
	                break;
	            }
	        }
	        if (win) {
	            return 1; // score returned for a left-to-right win
	        }
	    }

	    // Check for a bottom-to-top win
	    for (int col = 0; col < size; col++) {
	        boolean win = true;
	        for (int row = size - 1; row >= 0; row--) {
	            if (board[row][col] != playerToken) {
	                win = false;
	                break;
	            }
	        }
	        if (win) {
	            return 2; // score returned for a bottom-to-top win
	        }
	    }

	    // Check for a diagonal win (top-left to bottom-right)
	    boolean win = true;
	    for (int i = 0; i < size; i++) {
	        if (board[i][i] != playerToken) {
	            win = false;
	            break;
	        }
	    }
	    if (win) {
	        return 3; // Score returned for a win
	    }

	    return 0; // Score returned for no win
	}

/**
	 * Checks if the game board is in a tie state.
	 * A tie occurs when all positions on the board are filled.
	 *
	 * @return true if the game is tied, false otherwise
*/
	public boolean checkForTie() {
		// Check whether the game board is full, indicating a tie
		for (int boardRow = 0; boardRow < size; boardRow++) {
			for (int boardCol = 0; boardCol < size; boardCol++) {
				if (board[boardRow][boardCol] == '.') {
					return false; // if any position is empty, the game is not a tie as the board is not full
				}
			}
		}
		return true; // else it is a tie, as the board is full
	}

}
