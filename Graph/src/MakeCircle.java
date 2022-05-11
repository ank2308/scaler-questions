import java.util.ArrayList;
import java.util.HashMap;

public class MakeCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] A  = {"ihgg", "gigfi", "hggii", "gh", "ihhfhfh"};
		MakeCircle circle = new MakeCircle();
		System.out.println(circle.solve(A));
	}
	
	public int solve(String[] A) {
		HashMap<Character, ArrayList<Character>> charAdjList = new HashMap<>();
		for(String str : A) {
			char first = str.charAt(0);
			char last = str.charAt(str.length()-1);
			if(charAdjList.containsKey(first)) {
				ArrayList<Character> tempList = charAdjList.get(first);
				tempList.add(last);
				charAdjList.replace(first, tempList);
			} else {
				ArrayList<Character> tempList = new ArrayList<>();
				tempList.add(last);
				charAdjList.put(first, tempList);
			}
		}
		return 0;
	}

}
