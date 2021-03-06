import java.util.ArrayList;
import java.util.HashMap;

public class PoisionousGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {};
		PoisionousGraph poisionousGraph = new PoisionousGraph();
		System.out.println(poisionousGraph.solve(100000, A));
	}
	
	int [] visitedAr ;
	
	public int solve(int A, int[][] B) {
		 HashMap<Integer, ArrayList<Integer>> adjMatrix = makeAdjMatrix(B);
		 visitedAr = new int [A+1];
		 for (int i = 0; i <= A; i++) {
			visitedAr[i] = -1;
		 }
		 for(Integer key : adjMatrix.keySet()) {
			 if(visitedAr[key]==-1) {
				 if(!colorGraphDFS(adjMatrix, key, 0)) {
					 return 0;
				 }
			 }
		 }
		 if(B.length != 0) {
			 int oddColor = 0;
			 int evenColor = 0;
			 for (int i = 1; i < A+1; i++) {
				 if(visitedAr[i] == 0) {
					 evenColor++;
				 } else {
					 oddColor++;
				 }
			 }
			 return power(2, oddColor, 998244353) + power(2, evenColor, 998244353) ;
		 } else {
			 return power(3, A, 998244353);
		 }
    }
	
	private int power(int x, int y, int p)
	  {
	    int res = 1; // Initialize result
	 
	    x = x % p; // Update x if it is more than or
	    // equal to p
	 
	    if (x == 0)
	      return 0; // In case x is divisible by p;
	 
	    while (y > 0)
	    {
	 
	      // If y is odd, multiply x with result
	      if ((y & 1) != 0)
	        res = (res * x) % p;
	 
	      // y must be even now
	      y = y >> 1; // y = y/2
	      x = (x * x) % p;
	    }
	    return res;
	  }
	
	private boolean colorGraphDFS(HashMap<Integer, ArrayList<Integer>> adjMatrix, int key, int color) {
		visitedAr[key] = color;
		boolean flag = true;
		for(Integer node : adjMatrix.get(key)) {
			if(visitedAr[node]  != -1) {
				if(visitedAr[node] == color) {
					flag = false;
				}
			} else {
				flag = colorGraphDFS(adjMatrix, node, 1^color);
			}
		}
		return flag;
	}
	
	private HashMap<Integer, ArrayList<Integer>> makeAdjMatrix (int [][]A ) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			ArrayList<Integer> tempList;
			if(adjMatrix.containsKey(A[i][0])){
				tempList = adjMatrix.get(A[i][0]);
				tempList.add(A[i][1]);
				adjMatrix.replace(A[i][0], tempList);
			} else {
				tempList = new ArrayList<>();
				tempList.add(A[i][1]);
				adjMatrix.put(A[i][0], tempList);
			}
			if(adjMatrix.containsKey(A[i][1])){
				tempList = adjMatrix.get(A[i][1]);
				tempList.add(A[i][0]);
				adjMatrix.replace(A[i][1], tempList);
			} else {
				tempList = new ArrayList<>();
				tempList.add(A[i][0]);
				adjMatrix.put(A[i][1], tempList);
			}
		}
		return adjMatrix;
	}

}
