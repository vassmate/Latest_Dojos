import java.util.Arrays;
import java.util.Random;

public class MineSweeper {

	public static String[][] mineField;
	private int difficulty;
	private static final int[][] DIRECTIONS;
	
	static {
		DIRECTIONS = new int[][] {{0,0},{0,1},{0,-1},{1,0},{1,1},{1,-1},{-1,0},{-1,1},{-1,-1}};
	}
	
	public MineSweeper(String[][] inputField, int fieldDifficulty) {
		mineField = inputField;
		difficulty = fieldDifficulty;
	}
	
	private int generateMines(int range) {
		Random rand = new Random();
		int randIndexOfMine = rand.nextInt(range);
		return randIndexOfMine;
	}
	
	private void fillMineField(int runs) {
		int runCount = runs;
		for(String[] row : mineField) {
			while(runCount > 0) {
				int indexOfMine = generateMines(row.length);
				row[indexOfMine] = "o";
				runCount--;
			}
			runCount = runs;
		}
	}
	
	public int[][] findMines() {
		fillMineField(difficulty);
		int[][] result = new int[mineField.length][];
		int mineCount = 0;
		for(int i = 0; i < mineField.length; i++) {
			int[] sweptRow = new int[mineField[i].length];
			for(int j = 0; j < mineField[i].length; j++) {
				for(int[] direction : DIRECTIONS) {
					int dR = direction[0] + i;
					int dC = direction[1] + j;
					if(dR >= 0 && dR < mineField.length && dC >= 0 && dC < mineField[dR].length) {
						if(mineField[dR][dC].equals("o")) {
							mineCount++;
						}
					}
				}
				sweptRow[j] = mineCount;
				mineCount = 0;
			}
			result[i] = sweptRow;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[][] initField = new String[][] {
			{"x", "x", "x", "x", "x"},
			{"x", "x", "x", "x"},
			{"x", "x"},
			{"x", "x", "x", "x", "x"},
			{"x", "x", "x", "x"},
			{"x", "x", "x"}
		};
		System.out.println("Init field:");
		for(String[] row : initField) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();

		MineSweeper sweeper = new MineSweeper(initField, 3);
		int[][] sweptField = sweeper.findMines();
		String[][] fieldToSweep = sweeper.mineField;
		
		System.out.println("Field to sweep:");
		for(String[] row : fieldToSweep) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
		
		System.out.println("Swept field:");
		for(int[] row : sweptField) {
			System.out.println(Arrays.toString(row));
		}
	}
}