import java.util.ArrayList;

public class SpellingChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
		ArrayList<Integer> ans = new ArrayList<>();
		for (String word : B) {
			if(A.contains(word)) {
				ans.add(1);
			} else {
				ans.add(0);
			}
		}
		return ans;
		
    }

}
