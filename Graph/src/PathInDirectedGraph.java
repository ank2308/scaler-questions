import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PathInDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,2},{4,1},{2,4},{3,4},{4,5},{1,3}};
		PathInDirectedGraph pig = new PathInDirectedGraph();
		System.out.println(pig.solve(5, A));
	}
	
	public int solve(int A, int[][] B) {
		HashMap<Integer, List<Integer>> graphData = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			List<Integer> tempList = null;
			if(graphData.containsKey(B[i][0])) {
				tempList = graphData.get(B[i][0]);
				tempList.add(B[i][1]);
				graphData.replace(B[i][0], tempList);
			} else {
				tempList = new ArrayList<>();
				tempList.add(B[i][1]);
				graphData.put(B[i][0], tempList);
			}
		}
		Queue<Integer> listNodes = new LinkedList<>();
		boolean [] visitedArray = new boolean [A+1];
		for (int i = 0; i < visitedArray.length; i++) {
			visitedArray[i] = false;
		}
		listNodes.add(1);
		visitedArray[1] = true;
		while (!listNodes.isEmpty()) {
			int tempVal = listNodes.poll();
			List<Integer> tempList = graphData.get(tempVal);
			if(tempList!=null) {
				for (Integer value : tempList) {
					if(!visitedArray[value]) {
						listNodes.add(value);
						visitedArray[value] = true;
					}
				}
			}
		}
		if(visitedArray[A]) {
			return 1;
		}else {
			return 0;
		}
    }

}
