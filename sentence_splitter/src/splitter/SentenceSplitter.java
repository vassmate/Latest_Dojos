package splitter;

public class SentenceSplitter {

	private String sentence;

	public SentenceSplitter(String input) {
		sentence = input;
	}

	public String getSentence() {
		return sentence;
	}

	public void splitSentence(int rowLength) {
		String[] splittedSentence = sentence.split(" ");
		StringBuilder result = new StringBuilder();
		int currentRowLength = 0;
		for (String word : splittedSentence) {
			if (word.length() > rowLength) {
				String sw = splitWord(word, rowLength);
				String we = word.substring(sw.length(), word.length());
				result.append("\n" + sw + "\n" + we + " ");
				currentRowLength = we.length();
			} else if (currentRowLength + word.length() >= rowLength) {
				result.append("\n" + word + " ");
				currentRowLength = word.length() + 1;
			} else {
				result.append(word + " ");
				currentRowLength += word.length() + 1;
			}
		}
		sentence = result.toString();
	}

	private String splitWord(String word, int rowLength) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rowLength; i++) {
			char currentChar = word.charAt(i);
			sb.append(currentChar);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String inputSentence = "Java is a high-level programming language originally developed by Sun Microsystems and released in 1995.";
		System.out.println(inputSentence + "\n");
		SentenceSplitter sSplitter = new SentenceSplitter(inputSentence);
		sSplitter.splitSentence(15);
		System.out.println(sSplitter.getSentence());
	}
}
