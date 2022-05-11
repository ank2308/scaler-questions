import java.util.ArrayList;
import java.util.HashMap;

public class MinWeightedCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int [] visitedAr ;
	int cycleWeight = 0;
	int minCycleWt = 0;
	
	public int solve(int A, int[][] B) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = makeAdjMatrix(B);
		visitedAr = new int [A+1];
		for(Integer key : adjMatrix.keySet()) {
			if(visitedAr[key]==0 && findCycleUsingDFS(adjMatrix, key, 0)) {
				return 1;
			}
		}
		return 0;
    }
	
	private HashMap<Integer, ArrayList<Integer>> makeAdjMatrix (int [][]A ) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			ArrayList<Integer> tempList;
			if(adjMatrix.containsKey(A[i][0])){
				tempList = adjMatrix.get(A[i][0]);
				tempList.add(A[i][1]);
				tempList.add(A[i][2]);
				adjMatrix.replace(A[i][0], tempList);
			} else {
				tempList = new ArrayList<>();
				tempList.add(A[i][1]);
				tempList.add(A[i][2]);
				adjMatrix.put(A[i][0], tempList);
			}
			if(adjMatrix.containsKey(A[i][1])){
				tempList = adjMatrix.get(A[i][1]);
				tempList.add(A[i][0]);
				tempList.add(A[i][2]);
				adjMatrix.replace(A[i][1], tempList);
			} else {
				tempList = new ArrayList<>();
				tempList.add(A[i][0]);
				tempList.add(A[i][2]);
				adjMatrix.put(A[i][1], tempList);
			}
		}
		return adjMatrix;
	}
	
	private boolean findCycleUsingDFS (HashMap<Integer, ArrayList<Integer>> adjMatrix, int key, int prev) {
		visitedAr[key] = 1;
		for(Integer node : adjMatrix.get(key)) {
			if(node != prev) {
				if(visitedAr[node] == 1) {
					return true;
				} else {
					boolean flag = findCycleUsingDFS(adjMatrix, node, key);
					if(flag) {
						return flag;
					}
				}
			}
		}
		return false;		
	}

}
