import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PossibilityOfFinishing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,2};
		int [] B = {2,1};
		PossibilityOfFinishing possibilityOfFinishing = new PossibilityOfFinishing();
		System.out.println(possibilityOfFinishing.solve(3, A, B));
	}
	int [] visitedAr;
	public int solve(int A, int[] B, int[] C) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = makeAdjMatrixDirected(B, C);
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		visitedAr = new int [A+1]; 
		int [] inDegreeNode = populateInDegree(A, adjMatrix);
		for (int i = 1; i < inDegreeNode.length; i++) {
			if(inDegreeNode[i] == 0) {
				visitedAr[i] = 1;
				queue.add(i);
				inDegreeNode[i]--;
			}
		} 
		ArrayList<Integer> topologicalSort = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int node = queue.poll();
			if(adjMatrix.containsKey(node)) {
				for(Integer n : adjMatrix.get(node)) {
					inDegreeNode[n]--;
					if(inDegreeNode[n] == 0) {
						visitedAr[n] = 1;
						queue.add(n);
					}
				}
			}
			topologicalSort.add(node);
			
		}
		visitedAr[0] =1;
		for (int i : visitedAr) {
			if(i==0) {
				return 0;
			}
		}
		return 1;
	}
	
	private int [] populateInDegree (int A, HashMap<Integer, ArrayList<Integer>> adjMatrix) {
		int  [] inDegree = new int [A+1];
		for (Integer key : adjMatrix.keySet()) {
			for (Integer node : adjMatrix.get(key)) {
				inDegree[node]++;
			}
		}
		return inDegree;
	}
	
	private HashMap<Integer, ArrayList<Integer>> makeAdjMatrixDirected (int []A, int [] B ) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			ArrayList<Integer> tempList;
			if(adjMatrix.containsKey(A[i])){
				tempList = adjMatrix.get(A[i]);
				tempList.add(B[i]);
				Collections.sort(tempList);
				adjMatrix.replace(A[i], tempList);
			} else {
				tempList = new ArrayList<>();
				tempList.add(B[i]);
				adjMatrix.put(A[i], tempList);
			}			
		}
		return adjMatrix;
	}
}
