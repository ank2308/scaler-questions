import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class AutoComplete {

	private static final Integer ALPHABET_SIZE = 26;
	private static TrieNode root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int numOfTestCases = scn.nextInt();
		for (int i = 0; i < numOfTestCases; i++) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			scn.nextLine();
			String line = scn.nextLine();			
			String [] words = line.split(" ");
			
			int [] weight = new int [n];
			for (int j = 0; j < n; j++) {
				weight[j] = scn.nextInt();
			}
			scn.nextLine();
			String linePrefix = scn.nextLine();
			String[] prefixes = linePrefix.split(" ");
			root = new TrieNode();
			AutoComplete ac = new AutoComplete();
			for (int j = 0; j < n; j++) {
				ac.insert(words[j], weight[j]);
			}
			for (int j = 0; j < m; j++) {
				ArrayList<String> auto = ac.autoComplete(prefixes[j]);
				if (auto != null) {
				for (String string : auto) {
					System.out.print(string + " ");
				}
				} else {
					System.out.print(-1);
				}
				System.out.println();
			}
			
			
		}
	}
	
	
	
	private static class TrieNode {
		HashMap<Integer, String> wordWithWeight = new HashMap<>();
		TrieNode [] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;
		TrieNode () {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				children[i] = null;
			}
		}
	}
	
	private void insert (String key, int weight) {
		TrieNode crawl = root;
		int length = key.length();
		int index;
		for (int i = 0; i < length; i++) {
			index = key.charAt(i) - 'a';
			if(crawl.children[index] == null) {
				crawl.children[index] = new TrieNode();
			}
			crawl = crawl.children[index];	
			crawl.wordWithWeight.put(weight, key);					
		}
		crawl.isEndOfWord = true;
	}
	
	private ArrayList<String> autoComplete (String key) {
		TrieNode crawl = root;
		int length = key.length();
		int index;
		for (int i = 0; i < length; i++) {
			index = key.charAt(i) - 'a';
			if(crawl.children[index] == null) {
				return null;
			}
			crawl = crawl.children[index];
		}
		ArrayList<Integer> keys = new ArrayList<>(crawl.wordWithWeight.keySet());
		Collections.sort(keys);
		Collections.reverse(keys);
		ArrayList<String> ans = new ArrayList<>();
		for (Integer keyValue : keys) {
			ans.add(crawl.wordWithWeight.get(keyValue));
			if(ans.size() == 5)
				break;
		}
		return ans;
	}	

}
