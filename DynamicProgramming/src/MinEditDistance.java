/*Problem Description

Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Problem Constraints

1 <= length(A), length(B) <= 450



Input Format

The first argument of input contains a string, A.
The second argument of input contains a string, B.



Output Format

Return an integer, representing the minimum number of steps required.



Example Input

Input 1:

 A = "abad"
 B = "abac"
Input 2:

 A = "Anshuman"
 B = "Antihuman


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Exlanation 1:

 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
 
Explanation 2:

 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.*/
public class MinEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinEditDistance editDistance = new MinEditDistance();
		System.out.println(editDistance.minDistance("Anshuman", "Antihuman"));
	}
	
	public int minDistance(String A, String B) {
		char[] Ar = A.toCharArray();
		char[] Br = B.toCharArray();
		int m = Ar.length;
		int n = Br.length;
		return findLowestCommonSubsequence(Ar, Br, m, n);
	}
	
	private int findLowestCommonSubsequence (char [] Ar, char [] Br, int m, int n) {		
		int [][] dp = new int [m+1][n+1];
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i < m+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(Ar[i-1] == Br[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j]);
					dp[i][j] = 1+dp[i][j];
				}
			}
		}
		return dp[m][n];
	}

}
