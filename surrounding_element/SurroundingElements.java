import java.util.List;
import java.util.ArrayList;

public class SurroundingElements {
	
	private static final int[][] DIRECTIONS;
	private String[][] elementsArray;

	static {
		DIRECTIONS = 
			new int[][] {
				new int[]{0, -1}, new int[]{0, 1},
				new int[]{1, 0}, new int[]{1, -1}, new int[]{1, 1},
				new int[]{-1, 0}, new int[]{-1, -1}, new int[]{-1, 1}
			};		
	}
	
	public SurroundingElements(String[][] inputArray) {
		this.elementsArray = inputArray;
	}
	
	public ArrayList<String> getSurroundingElements(int rowIndex, int columnIndex) {
		ArrayList<String> surroundingElements = new ArrayList<>();
		for(int[] direction : DIRECTIONS) {
			int currentRow = rowIndex + direction[0];
			int currentColumn = columnIndex + direction[1];
			if(currentRow < elementsArray.length && currentRow >= 0 &&
			currentColumn < elementsArray[currentRow].length && currentColumn >= 0) {
				surroundingElements.add(elementsArray[currentRow][currentColumn]);
			}
		}
		return surroundingElements;
	}
	
	public static void main(String[] args) {
		String[][] inputArray = new String[][]{
				new String[]{"a", "b", "c", "d"},
				new String[]{"f", "g", "h", "i", "j"},
				new String[]{"k", "l", "m"},
				new String[]{"p"},
			};
		SurroundingElements se = new SurroundingElements(inputArray);
		ArrayList<String> result = se.getSurroundingElements(2, 2);
		for(String ce : result) {
			System.out.print(ce + " ");
		}
	}
}