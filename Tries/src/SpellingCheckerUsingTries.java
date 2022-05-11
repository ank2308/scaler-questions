import java.util.ArrayList;
import java.util.Arrays;

public class SpellingCheckerUsingTries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> A = new ArrayList<String>();
		A.add("hat");
		A.add("cat");
		A.add("rat");
		ArrayList<String> B = new ArrayList<String>();
		B.add("hat");
		B.add("ra");
		SpellingCheckerUsingTries checkerUsingTries = new SpellingCheckerUsingTries();
		System.out.println(Arrays.asList(checkerUsingTries.solve(A, B)));
	}
	
	private static final Integer ALPHABET_SIZE = 26;
	private TrieNode root;
	
	private class TrieNode {
		
		TrieNode [] children = new TrieNode[ALPHABET_SIZE];
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
			if(crawl.children[index] == null)
				crawl.children[index] = new TrieNode();
			crawl = crawl.children[index];
		}
		crawl.isEndOfWord = true;
	}
	
	private boolean isPresent (String key) {
		TrieNode crawl = root;
		int length = key.length();
		int index;
		for (int i = 0; i < length; i++) {
			index = key.charAt(i) - 'a';
			if(crawl.children[index] == null) {
				return false;
			}
			crawl = crawl.children[index];
		}
		return (crawl !=null && crawl.isEndOfWord);
	}
	
	public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
		root = new TrieNode();
        for (String temp: A)
            insert(temp);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            if (isPresent(B.get(i)) == true)
                ans.add(1);
            else ans.add(0);
        }
        return ans;
	}

}
