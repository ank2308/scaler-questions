import java.util.ArrayList;
import java.util.HashMap;

/*Problem Description

There is a rectangle with left bottom as (0, 0) and right up as (x, y).

There are N circles such that their centers are inside the rectangle.

Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.



Problem Constraints

0 <= x , y, R <= 100

1 <= N <= 1000

Center of each circle would lie within the grid



Input Format

1st argument given is an Integer x , denoted by A in input.

2nd argument given is an Integer y, denoted by B in input.

3rd argument given is an Integer N, number of circles, denoted by C in input.

4th argument given is an Integer R, radius of each circle, denoted by D in input.

5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle

6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle



Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).



Example Input

Input 1:

 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]
Input 2:

 x = 1
 y = 1
 N = 1
 R = 1
 A = [1]
 B = [1]


Example Output

Output 1:

 NO
Output 2:

 NO


Example Explanation

Explanation 1:

 There is NO valid path in this case
Explanation 2:

 There is NO valid path in this case*/
public class ValidPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPath validPath = new ValidPath();
		int [] A = {2};
		int [] B = {3};
		validPath.solve(2, 3, 1, 1, A, B);
	}
	
	public String solve(int A, int B, int C, int D, int[] E, int[] F) {
		int [][] arr = new int [A+1][B+1];
		for (int i = 0; i <= A; i++) {
			for (int j = 0; j <= B; j++) {
				arr[i][j] = 1;
			}
		}
		for (int i = 0; i < C; i++) {
			arr[E[i]][F[i]] = 0;
			makeElementsZero(arr, D, E[i], F[i], A, B);
		}
		
		dfs(arr, 0, 0, A, B);
		if(arr[A][B] == 2) {
			return "YES";
		} else {
			return "NO";
		}
    }
	
	private void dfs(int [][] Ar, int x, int y, int row, int col) {
		int [] Rx = {-1, 0 , 1, 0, -1, 1, -1, 1};
		int [] Ry = {0, -1, 0, 1, -1, 1, 1, -1};
		if(Ar[x][y] == 1) {
			Ar[x][y] = 2;
			for (int i = 0; i < Ry.length; i++) {
				int newRx = x + Rx[i];
				int newRy = y + Ry[i];
				if(isValid(Ar, newRx, newRy, row, col)) {
					dfs(Ar, newRx, newRy, row, col);
				}
			}
		}
	}
	
	private boolean isValid (int [][]A, int i, int j, int row, int col) {
		if(i>=0 && j>=0 && i<=row && j<=col) {
			if(A[i][j] == 1) {
				return true;
			}
		}
		return false;
	}
	
	private void makeElementsZero (int [][] arr, int radius, int x, int y, int row, int col) {
		int [] Rx = {-1, 0 , 1, 0};
		int [] Ry = {0, -1, 0, 1};
		for (int i = 0; i < Ry.length; i++) {			
			for(int j = 1; j<= radius; j++) {
				int newRx = x + (Rx[i]*j);
				int newRy = y + (Ry[i]*j);
				if(isValid(arr, newRx, newRy, row, col)) {
					arr[newRx][newRy] = 0;
				}
			}
		}		
	}	

}
