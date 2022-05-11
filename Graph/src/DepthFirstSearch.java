import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Templates;

public class DepthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 1, 2, 3, 4, 3, 4, 1};
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		System.out.println(depthFirstSearch.solve(A, 7, 7));
	}
	public int solve(int[] A, final int B, final int C) {
		// Constructing graph
		Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if(adj.containsKey(A[i])) {
				ArrayList<Integer> tempList = adj.get(A[i]);
				tempList.add(i+1);
			} else {
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(i+1);
				adj.put(A[i], tempList);
			}
		}	
		return isAccessible(adj, B, C, A.length);
	}
	
	private int isAccessible(Map<Integer, ArrayList<Integer>> adj, int B, int C, int len) {
		
		if(!adj.containsKey(C)) {
			return 0;
		}
		for(Integer ele : adj.get(C)) {
			
				if(ele == B) {
					return 1;
				} else if(ele != C) {
					int temp = isAccessible(adj, B, ele, len);
					if(temp == 1) {
						return 1;
					}
				}
		}
		return 0;
	}
}
