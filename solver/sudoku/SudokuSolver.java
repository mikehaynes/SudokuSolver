package solver.sudoku;

import static java.lang.System.out;

public class SudokuSolver {

	public static void main(String[] args) {
		out.println("Welcome to the Sudoku Solver!\n" +
				    "Enter \"quit\" at any time to exit the program.\n");
		
		InputManager input = new InputManager();
		
		while(true) {
			if (input.getInput()) {
				out.println("\nThanks for using Sudoku Solver!");
				return;  // quit the program
			}
		}
	}

}
