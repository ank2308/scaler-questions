import java.util.ArrayList;
public class ShortestUniquePrefix {
	
	private static final Integer ALPHABET_SIZE = 26;
	private static TrieNode root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> wordList = new ArrayList<>();
		wordList.add("zebra");
		wordList.add("dog");
		wordList.add("duck");
		wordList.add("dove");
		ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
		System.out.println(shortestUniquePrefix.prefix(wordList));
	}
	
	private static class TrieNode {
		TrieNode [] children = new TrieNode[ALPHABET_SIZE];
		int prefixOfWords = 0;
		boolean isEndOfWord;
		TrieNode () {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				children[i] = null;
			}
		}
	}
	
	private void insert (String key) {
		TrieNode crawl = root;
		int length = key.length();
		int index;
		for (int i = 0; i < length; i++) {
			index = key.charAt(i) - 'a';
			if(crawl.children[index] == null) {
				crawl.children[index] = new TrieNode();
			}
			crawl = crawl.children[index];
			crawl.prefixOfWords++;
		}
		crawl.isEndOfWord = true;
	}
	
	private String findPrefix(String key) {
		TrieNode crawl = root;
		int length = key.length();
		int index;
		String prefix = "";
		for (int i = 0; i < length; i++) {
			index = key.charAt(i) - 'a';			
			crawl = crawl.children[index];
			prefix = prefix + key.charAt(i);
			if(crawl.prefixOfWords == 1)
				return prefix;						
		}
		return prefix;
	}
	
	public ArrayList<String> prefix(ArrayList<String> A) {
		root = new TrieNode();
		for (String string : A) {
			insert(string);
		}
		ArrayList<String> prefixList = new ArrayList<>();
		for (String string : A) {
			prefixList.add(findPrefix(string));
		}
		return prefixList;
    }
}
