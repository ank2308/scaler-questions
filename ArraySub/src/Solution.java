
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 2, 8};
		Solution s = new Solution();
		System.out.println(s.solve(A, 2));
	}
	
	public int solve(int[] A, int B) {
        return countSubsequence(A, A.length, 1000);
    }

    static int countSubsequence(int[] A, int N, int X) {
        
        // Initialize a DP array
        int [][]dp = new int[N][X + 1];
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < X + 1; j++)
            {
                dp[i][j] = -1;
            }
        }
        
        // Return the result
        return countSubsequenceUtil(0, X, A,
                                    N, dp) - 1;
    }

    static int countSubsequenceUtil(int ind, int sum, int []A, int N, int [][]dp) {
        
        // Base condition
        if (ind == N)
            return 1;
    
        // Return if the sub-problem
        // is already calculated
        if (dp[ind][sum] != -1)
            return dp[ind][sum];
    
        // Check if the current element is
        // less than or equal to sum
        if (A[ind] <= sum)
        {
            
            // Count subsequences excluding
            // the current element
            dp[ind][sum] = countSubsequenceUtil(
                            ind + 1, sum,
                            A, N, dp) +
                            
                        // Count subsequences
                        // including the current
                        // element
                        countSubsequenceUtil(
                            ind + 1,
                            sum - A[ind],
                            A, N, dp);
        }
        else
        {
            
            // Exclude current element
            dp[ind][sum] = countSubsequenceUtil(
                            ind + 1, sum,
                            A, N, dp);
        }
    
        // Return the result
        return dp[ind][sum];
    }

}
