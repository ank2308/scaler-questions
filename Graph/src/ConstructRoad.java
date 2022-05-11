import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*Problem Description
A country consist of N cities connected by N - 1 roads. King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.

Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way, that for each road (u, v) that belongs to the country, u and v belong to different sets. Also, there should be no multiple roads between two cities and no self loops.

Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.

NOTE: All cities can be visited from any city.



Problem Constraints
1 <= A <= 105

1 <= B[i][0], B[i][1] <= N



Input Format
First argument is an integer A denoting the number of cities, N.

Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .



Output Format
Return an integer denoting the maximum number of roads king can construct.



Example Input
Input 1:

 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]
Input 2:

 A = 5
 B = [
       [1, 3]
       [1, 4]
       [3, 2]
       [3, 5]
     ]


Example Output
Output 1:

 0
Output 2:

 2


Example Explanation
Explanation 1:

 We can't construct any new roads such that the country remains bipartite.
Explanation 2:

 We can add two roads between cities (4, 2) and (4, 5).*/
public class ConstructRoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,2},{1,3}};
		ConstructRoad constructRoad = new ConstructRoad();
		System.out.println(constructRoad.solve(3, A));
		
	}
	
	int [] visitedAr ;
	HashSet<Integer> red = new HashSet<>();
	HashSet<Integer> blue = new HashSet<>();
	
	public int solve(int A, int[][] B) {
		HashMap<Integer, ArrayList<Integer>> adjMatrix = makeAdjMatrix(B);
		int mod = ((int)Math.pow(10, 9)) + 7;
		visitedAr = new int [A+1];
		for (int i = 0; i <= A; i++) {
			visitedAr[i] = -1;
		 }
		 for(Integer key : adjMatrix.keySet()) {
			 if(visitedAr[key]==-1) {
				 colorGraphDFS(adjMatrix, key, 0);
			 }
		 }
		 int roadConstruct = 0;
		 for(Integer key : red) {
			 ArrayList<Integer> roadsPossible = adjMatrix.get(key);
			 roadConstruct = (roadConstruct + (Math.abs(blue.size() - roadsPossible.size()))) % mod;
		 }
		 return roadConstruct;
    }
	
	private void colorGraphDFS(HashMap<Integer, ArrayList<Integer>> adjMatrix, int key, int color) {
		visitedAr[key] = color;
		if(color == 0) {
			red.add(key);
		} else {
			blue.add(key);
		}
		for(Integer node : adjMatrix.get(key)) {
			if(visitedAr[node]  != -1) {				
			} else {
				colorGraphDFS(adjMatrix, node, 1^color);
			}
		}
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
