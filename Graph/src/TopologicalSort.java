import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,4},{1,2},{4,2},{4,3},{3,2},{5,2},{3,5},{8,2},{8,6}};
		TopologicalSort topologicalSort = new TopologicalSort();
		System.out.println(topologicalSort.solve(8, A));
	}
	
	public int[] solve(int A, int[][] B) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = makeAdjMatrixDirected(B);
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int [] inDegreeNode = populateInDegree(A, adjMatrix);
		for (int i = 1; i < inDegreeNode.length; i++) {
			if(inDegreeNode[i] == 0) {
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
						queue.add(n);
					}
				}
			}
			topologicalSort.add(node);
			
		}
		int [] ans = topologicalSort.stream().mapToInt(i -> i).toArray();
		return ans;
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
	
	private HashMap<Integer, ArrayList<Integer>> makeAdjMatrixDirected (int [][]A ) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			ArrayList<Integer> tempList;
			if(adjMatrix.containsKey(A[i][0])){
				tempList = adjMatrix.get(A[i][0]);
				tempList.add(A[i][1]);
				Collections.sort(tempList);
				adjMatrix.replace(A[i][0], tempList);
			} else {
				tempList = new ArrayList<>();
				tempList.add(A[i][1]);
				adjMatrix.put(A[i][0], tempList);
			}			
		}
		return adjMatrix;
	}
}
