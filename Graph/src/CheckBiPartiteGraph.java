import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CheckBiPartiteGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{2,5},{6,7},{4,8},{2,3},{0,3},{4,7},{1,8},{3,8},{1,3}};
		CheckBiPartiteGraph biPartiteGraph = new CheckBiPartiteGraph();
		System.out.println(biPartiteGraph.solve(9, A));
		Set<Integer> s = new HashSet<>();
		ArrayList<Integer> s1 = new ArrayList<>();
		Collections.sort(s1);
	}
	
	int [] visitedAr ;
	
	public int solve(int A, int[][] B) {
		 HashMap<Integer, ArrayList<Integer>> adjMatrix = makeAdjMatrix(B);
		 visitedAr = new int [A];
		 for (int i = 0; i < A; i++) {
			visitedAr[i] = -1;
		 }
		 for(Integer key : adjMatrix.keySet()) {
			 if(visitedAr[key]==-1) {
				 if(!colorGraphDFS(adjMatrix, key, 0)) {
					 return 0;
				 }
			 }
		 }
		 return 1;
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
