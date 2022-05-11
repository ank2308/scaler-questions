import java.util.LinkedList;
import java.util.Queue;

/*Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input
Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:

 
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]


Example Output
Output 1:

 4
Output 2:

 -1


Example Explanation
Explanation 1:

 Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
Explanation 2:

 Task is impossible
*/

class Node {
	int x;
	int y;
	Node (int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class RottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RottenOranges oranges = new RottenOranges();
		int [][] A = {{2,1,1},{0,1,1},{1,0,1}};
		System.out.println(oranges.solve(A));
	}
	
	
	int [][] visitedAr ;
	public int solve(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		visitedAr = new int [row][col];
		int time = 0;
		Queue<Node> queue = new LinkedList<Node>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(A[i][j] == 2) {
					Node n = new Node(i,j);
					queue.add(n);
				}
			}
		}
		time = dfs(queue, time, A, row, col);
		boolean flag = true;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(A[i][j] == 1) {
					flag = false; 
				}
			}
		}
		if(flag) {
			return time;
		} else {
			return -1;
		}
    }
	
	private int dfs (Queue<Node> queue, int sum, int [][] A, int row, int column) {
		Queue<Node> newQeueu = new LinkedList<Node>();
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			markRottenOranges(A, n.x, n.y, row, column, newQeueu);
		}		
		if(!newQeueu.isEmpty()) {
			sum++;
			sum = dfs(newQeueu, sum, A, row, column);
		}
		return sum;
	}
	
	private void markRottenOranges (int [][]A, int rIndex, int cIndex, int row, int column, Queue<Node> queue) {
		int [] Rx = {-1, 0 , 1, 0};
		int [] Ry = {0, -1, 0, 1};
		for (int i = 0; i < Ry.length; i++) {
			int newR = rIndex + Rx[i];
			int newC = cIndex + Ry[i];
			if (isValid(A, newR, newC, row, column)) {
				visitedAr[newR][newC] = 1;
				A[newR][newC] = 2;
				Node node = new Node(newR, newC);
				queue.add(node);
			}			
		}
	}
	
	private boolean isValid (int [][]A, int i, int j, int row, int column) {
		if(i>=0 && j>=0 && i<row && j<column) {
			if(A[i][j] == 1 && visitedAr[i][j] == 0) {
				return true;
			}
		}
		return false;
	}

}
