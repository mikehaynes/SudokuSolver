package solver.sudoku;

import java.util.Scanner;

import static java.lang.System.out;

public class InputManager {
	
	private int[][] puzzle_grid;
	
	InputManager() {
		puzzle_grid = new int[SudokuPuzzle.size][SudokuPuzzle.size];
	}
	
	/* Use this function to get the start puzzle from the user.
	 * Returns true if the user has entered "quit", returns false otherwise.
	 */
	public boolean getInput() {
		Scanner scanner = new Scanner(System.in);
		String delims = "[ ]";
		
		out.println("Input the puzzle line by line, seperating numbers with spaces.\n" +
		            "Use \"-\" to indicate empty spaces.\n");
		
		for (int i = 0; i < SudokuPuzzle.size; ++i) {  // for each row
			
			out.print("Input row " + (i + 1) + ": ");
			String row = scanner.nextLine();  // get the whole row
				
			if (row.toLowerCase().contains("quit")) {  // if user wants to quit
				scanner.close();
				return true;
			}
				
			String[] tokens = row.split(delims);  // split the line into the numbers
				
			if (tokens.length != SudokuPuzzle.size) {  // if user didn't input enough numbers
				out.println("ERROR: Wrong input size.\n");
				scanner.close();
				return getInput();
			}
				
			for(int x = 0; x < SudokuPuzzle.size; ++x) {  // for each number in the row
					
				if (tokens[x].equals("-")) {  // if the space is empty
					puzzle_grid[i][x] = 0;
				}
				else {  // parse the number
					try {
						int val = Integer.parseInt(tokens[x]);
						
						if (val < 1 || val > 9) {
							out.println("ERROR: Number needs to be between 1 and 9.\n");
							scanner.close();
							return getInput();
						}
						
						puzzle_grid[i][x] = val;
					}
					catch (NumberFormatException e) {  // if parseInt() throws an exception
						out.println("ERROR: Invlid input.\n");
						scanner.close();
						return getInput();
					}
				}
			}
		}
		scanner.close();
		out.println();
		return false;
	}
	
	public int[][] getPuzzle() {
		return puzzle_grid;
	}

}
