import java.util.Arrays;

public class EvenToNegative {

	private int[][] inArray;

	public EvenToNegative(int[][] inputArray) {
		this.inArray = inputArray;
	}
	
	public int[][] reverseArray() {
		for(int i = 0; i < inArray.length; i++) {			
				for(int j = 0; j < inArray[i].length; j++) {
					int currentNum = inArray[i][j];
					if((i + 1) % 2 == 0) {
						inArray[i][j] = currentNum * -1;
					}
					if((j + 1) % 2 == 0) {
						currentNum = inArray[i][j];
						inArray[i][j] = currentNum * -1;
					}
				}
		}
		return inArray;
	}
	
	public static void main(String[] args) {
		int[][] array = new int[][]{
			{1,2,3,4,5},
			{6,7,8},
			{9,10,11,12},
			{13,14}
		};
		
		EvenToNegative etn = new EvenToNegative(array);
		for(int[] nums : etn.reverseArray()) {
			System.out.println(Arrays.toString(nums));
		}
	}
}