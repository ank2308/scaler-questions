import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BFSWrightedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]A = {{0,1,1}};
		BFSWrightedGraph bfsWrightedGraph = new BFSWrightedGraph();
		System.out.println(bfsWrightedGraph.solve(2, A, 0, 1));
	}
	
	int [] visitedAr;
	int [] minWeight;
	
	public int solve(int A, int[][] B, int C, int D) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = makeAdjMatrix(B);
		visitedAr = new int [A];
		minWeight = new int [A];
		PriorityQueue<Edge> minHeap = new PriorityQueue<>();
		minHeap.add(new Edge(C,0));
		for (int i = 0; i < A; i++) {
			minWeight[i] = Integer.MAX_VALUE;
		}
		minWeight[C] = 0;
		visitedAr[C] = 1;
		while(!minHeap.isEmpty()) {
			Edge n = minHeap.poll();
			if(adjMatrix.containsKey(n.v)) {
				ArrayList<Integer> adjNode = adjMatrix.get(n.v);
				for(int i=0; i<adjNode.size(); i+=2) {
					int wt = n.wt + adjNode.get(i+1);
					int v = adjNode.get(i);
					minWeight[v] = Math.min(minWeight[v], wt);
					if(visitedAr[v] == 0) {
						visitedAr[v] = 1;
						minHeap.add(new Edge(v,minWeight[v]));
					}
				}
			}
		}
		return minWeight[D]==Integer.MAX_VALUE?-1:minWeight[D];
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

}

class Edge implements Comparable<Edge>{
	int v;
	int wt;
	Edge(int v, int wt){
		this.v = v;
		this.wt = wt;
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.wt - o.wt;
	}
}
