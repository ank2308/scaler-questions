import java.util.ArrayList;
import java.util.HashMap;

public class CycleInDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,2},{2,3},{3,4},{4,5},{5,2},{1,3}};
		CycleInDirectedGraph cycleInDirectedGraph = new CycleInDirectedGraph();
		cycleInDirectedGraph.solve(5, A);
		
	}
	
	int [] visited;
	
	public int solve(int A, int[][] B) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = makeAdjMatrixDirected(B);
		visited = new int[A+1];
		if(findCycleInDirectedGraph(adjMatrix, B[0][0]))
			return 1;
		else
			return 0;
	}
	
	private boolean findCycleInDirectedGraph(HashMap<Integer, ArrayList<Integer>> adjMatrix, int key) {
		if(visited[key] == 0) {
			visited[key] = 1;
			if(adjMatrix.containsKey(key)) {
				for(Integer node : adjMatrix.get(key)) {
					if(visited[node] == 0) {
						if(findCycleInDirectedGraph(adjMatrix, node)) {
							return true;
						}
					} else if(visited[node]==1) {
						visited[node] = 2;
						return true;
					}
				}
			}
			visited[key] = 2;
		} else if(visited[key]==1) {
			visited[key] = 2;
			return true;
		}
		return false;
	}
	
	private HashMap<Integer, ArrayList<Integer>> makeAdjMatrixDirected (int [][]A ) {
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
		}
		return adjMatrix;
	}

}
