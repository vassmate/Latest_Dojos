package which_are_in;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class WhichAreIn {

	public static String[] inArray(String[] array1, String[] array2) {
		SortedSet<String> wordSet = new TreeSet<>();
		for (String word1 : array1) {
			for (String word2 : array2) {
				if (word2.contains(word1)) {
					wordSet.add(word1);
				}
			}
		}
		return wordSet.toArray(new String[wordSet.size()]);
	}

	public static void main(String[] args) {
		String[] a1 = new String[] { "live", "arp", "strong" };
		String[] a2 = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
		System.out.println(Arrays.toString(inArray(a1, a2)));
	}

}
