/*Problem Description

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.



Problem Constraints

1 <= M, N <= 500

-100 <= A[i] <= 100



Input Format

First and only argument is a 2D integer array A denoting the grid of size M x N.



Output Format

Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.



Example Input

Input 1:

 A = [ 
       [-2, -3, 3],
       [-5, -10, 1],
       [10, 30, -5]
     ]
Input 2:

 A = [ 
       [1, -1, 0],
       [-1, 1, -1],
       [1, 0, -1]
     ]


Example Output

Output 1:

 7
Output 2:

 1


Example Explanation

Explanation 1:

 Initially knight is at A[0][0].
 If he takes the path RIGHT -> RIGHT -> DOWN -> DOWN, the minimum health required will be 7.
 At (0,0) he looses 2 health, so health becomes 5.
 At (0,1) he looses 3 health, so health becomes 2.
 At (0,2) he gains 3 health, so health becomes 5.
 At (1,2) he gains 1 health, so health becomes 6.
 At (2,2) he looses 5 health, so health becomes 1.
 At any point, the health point doesn't drop to 0 or below. So he can rescue the princess with minimum health 7.
 
Explanation 2:

 Take the path DOWN -> DOWN ->RIGHT -> RIGHT, the minimum health required will be 1.*/
public class DungeonPrincess {
	
	public static void main(String [] args) {
		int [][] A = {{-39, -65, -93, -51, -97, -46, -32, -89, -70, -56, -14, -95, 2, -3, -32, -7, 8, -10, -16, -92},
				  {-95, -55, -99, -51, -7, -82, -93, -6, -8, -54, -76, -20, -80, -2, 9, -100, -81, -78, -58, -27},
				  {-76, -44, -40, -47, -50, -82, -21, -98, -28, 0, -10, 2, -90, -6, -12, -91, -28, -98, 1, -49},
				  {-18, -54, -95, -51, 8, -18, -33, -18, -44, 2, 3, -11, -81, -35, 7, -19, -82, -42, -21, -45},
				  {-57, -63, -42, -70, -66, -65, -52, -81, -17, -23, -91, 1, -68, -52, -42, 1, -65, -43, -69, -18},
				  {-57, -49, -35, -56, -20, -36, -42, -47, -70, -26, -53, -41, -9, -98, 2, -25, 8, -6, -99, -47},
				  {-76, -64, -8, -18, -3, 9, -23, -6, -93, -43, -82, -82, -47, -30, -48, -2, -54, -6, -19, -47},
				  {-4, -96, -28, 10, -95, -25, -29, -37, 4, -87, -58, -68, -7, -92, -34, -48, -21, -17, -55, -91},
				  {-28, -8, 5, -96, -17, -56, -54, -79, -17, 8, -92, -20, -65, -96, -88, -87, 6, -68, -46, -1},
				  {-25, -79, -27, -77, -88, 7, -70, 3, -10, -58, 10, 6, 5, -55, -94, -41, -26, -19, -39, -12},
				  {-46, -92, 9, -90, -31, -86, -1, 4, -40, -41, -95, 1, -60, -69, -42, -67, -45, -65, -47, -91},
				  {-32, -99, 4, -65, -10, -83, -67, -96, -69, -63, 4, -43, -48, -98, -16, -73, -21, 1, -81, -56},
				  {0, -1, -86, -71, -75, -1, -95, -22, -12, -38, -39, 10, -98, -53, -84, -60, -42, -85, -21, -98},
				  {-33, -6, -31, -66, -70, -27, -25, -99, -26, 8, -86, -68, -92, -63, -62, -95, -8, -65, -13, -31},
				  {-7, -84, -17, -66, -84, -13, 2, -34, -22, -96, -81, -89, -61, -34, 10, -23, -96, 3, -2, -82},
				  {-30, -48, 1, -40, -84, -7, -8, -90, -32, -5, 7, -53, -64, -25, -73, -82, -85, -40, 1, -35},
				  {-80, -83, -91, -90, -73, 2, -18, -25, -76, -72, -6, -28, -49, -86, 3, -80, -63, 4, -85, 3},
				  {6, -8, -52, 1, -57, -72, -73, -28, -88, -74, -25, -46, -93, -76, -10, -44, -92, -38, -70, -74},
				  {-43, -24, -98, -36, -77, -81, -2, -90, 1, -42, 3, -82, -2, -32, -80, -32, -12, -60, -79, -32},
				  {-91, -82, -65, 8, -12, -64, -42, -82, -66, -16, -97, -96, -79, -29, -79, -6, -6, -19, 3, 4}};
		DungeonPrincess dungeonPrincess = new DungeonPrincess();
		System.out.println(dungeonPrincess.calculateMinimumHP(A));
	}
	
	public int calculateMinimumHP(int[][] A) {
		int row = A.length;
		int column = A[0].length;
		int [][] dp = new int [row][column];
		dp[0][0] = A[0][0];
		for (int i = 1; i < row; i++) {
			dp[0][i] = dp[0][i-1] + A[0][i]; 
		}
		for (int i = 1; i < column; i++) {
			dp[i][0] = dp[i-1][0] + A[i][0]; 
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if(i==row-1 && j == column-1 && A[i][j] > 0) {
					int temp1 = dp[i-1][j];
					int temp2 = dp[i][j-1];
					dp[i][j] = Math.abs(temp1) < Math.abs(temp2) ? temp1 : temp2;
				} else {
					if(dp[i-1][j] < 0 && dp[i][j-1] < 0) {
						dp[i][j] = A[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
					} else if(dp[i-1][j] > 0 && dp[i][j-1] > 0){
						dp[i][j] = 0;
					} else {
						int temp1 = A[i][j] + dp[i-1][j];
						int temp2 = A[i][j] + dp[i][j-1];
						dp[i][j] = Math.abs(temp1) < Math.abs(temp2) ? temp1 : temp2;
					}
				}
			}
		}
		if(dp[row-1][column-1] < 0) {
			return Math.abs(dp[row-1][column-1]) + 1;
		} else {
			return 0;
		}
    }
}
