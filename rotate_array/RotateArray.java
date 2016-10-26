public class RotateArray<T> {
	
	private T[][] inputArray;
	private int rotationAmount;
	
	public RotateArray (T[][] inputArray, int rotationAmount) {
		this.inputArray = inputArray;
		this.rotationAmount = rotationAmount;
	}
	
	public T[][] rotate() {
		int rotationCount = 0;
		T[][] result = inputArray;
		while(rotationCount != rotationAmount) {
			rotationCount++;
			int arraySize = inputArray[0].length;
			int rowSize = inputArray.length;
			result = (T[][]) new Object[arraySize][rowSize];
			for(int i = 0; i < result.length; i++) {
				for(int j = inputArray.length - 1; j >= 0; j--) {
					result[i][result[i].length - 1 - j] = inputArray[j][i];
				}
			}
			inputArray = result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int rotationAmount = 4;
		String[][] stringInputArray = new String[][] {
			{"a","b","c","d"},
			{"e","f","g","h"},
			{"i","j","k","l"},
			{"m","n","o","p"},
			{"q","r","s","t"}
		};
		Integer[][] integerInputArray = new Integer[][] {
			{11,12,13,14}, 
			{15,16,17,18}, 
			{19,20,21,22}, 
			{23,24,25,26}, 
			{27,28,29,30}
		};
		RotateArray<Integer> raInt = new RotateArray<>(integerInputArray, rotationAmount);
		RotateArray<String> raStr = new RotateArray<>(stringInputArray, rotationAmount);
		Object[][] resultInt = raInt.rotate();
		Object[][] resultStr = raStr.rotate();
		printArray(resultInt);
		printArray(resultStr);
	}
	
	public static void printArray(Object[][] result) {
		System.out.println();
		for(int i = 0;i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
