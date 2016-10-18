
public class StringIndex {

	private String stringForSearch;

	public StringIndex(String stringForSearch) {
		this.stringForSearch = stringForSearch;
	}

	public String getStringForSearch() {
		return this.stringForSearch;
	}

	public int getIndexOf(char charToFind) {
		int result = -1;
		for (int i = 0; i < stringForSearch.length(); i++) {
			char currentChar = stringForSearch.charAt(i);
			if (currentChar == charToFind) {
				result = i;
				break;
			}
		}
		return result;
	}

	public int getIndexOf(char charToFind, int endIndex) {
		int result = -1;
		if (endIndex > stringForSearch.length() - 1) {
			return result;
		}
		for (int i = 0; i < endIndex; i++) {
			char currentChar = stringForSearch.charAt(i);
			if (currentChar == charToFind) {
				result = i;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		StringIndex strInd = new StringIndex("hello");
		System.out.println(strInd.getIndexOf('o'));
	}
}