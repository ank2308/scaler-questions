import java.util.ArrayList;
import java.util.HashSet;

public class ConsecutiveLongestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {100, 4, 200, 1, 3, 2,101,102,103,99};
		ConsecutiveLongestArray ca = new ConsecutiveLongestArray();
		System.out.println(ca.longestConsecutive(A));
	}
	
	public int longestConsecutive(final int[] A) {
		HashSet<Integer> elements = new HashSet<Integer>();
		ArrayList<Integer> tempLongest = new ArrayList<>();
		ArrayList<Integer> longest = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			elements.add(A[i]);
		}
		for (int i = 0; i < A.length; i++) {
			if(!elements.contains(A[i] - 1)) {
				int k = A[i];
				do {
					tempLongest.add(k);
					k++;
				} while(elements.contains(k));
				if(tempLongest.size() > longest.size()) {
					longest = tempLongest;					
				}
				tempLongest = new ArrayList<>();
			}
		}
		
		return longest.size();
		
    }

}
