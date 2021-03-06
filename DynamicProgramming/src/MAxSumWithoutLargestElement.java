import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class MAxSumWithoutLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] [] A = {{16, 5, 54, 55, 36, 82, 61, 77, 66, 61},{31, 30, 36, 70, 9, 37, 1, 11, 68, 14}};
		MAxSumWithoutLargestElement axSumWithoutLargestElement = new MAxSumWithoutLargestElement();
		System.out.println(axSumWithoutLargestElement.adjacent(A));
	}
	
	public int adjacent(int[][] A) {
		int [] finalAr = new int [A[0].length];
		for (int i = 0; i < finalAr.length; i++) {
			finalAr[i] = Math.max(A[0][i], A[1][i]);
		}
		int [] dp = new int[finalAr.length];		
		for (int i = 0; i < dp.length; i++) {
			if(i==0) {
				dp[0] = finalAr[0];
			} else if(i==1) {
				dp[1] = finalAr[1];
			} else {
				dp[i] = -1;
			}			
		}
		if(finalAr.length <=2) {
			return finalAr[finalAr.length-1];
		}
		int ans = adjacentSum(finalAr, dp, finalAr.length-1);
		return ans;
    }
	
	private int adjacentSum (int [] ar, int [] dp, int n) {
		if(dp[n] == -1) {
			dp[n] = Math.max(adjacentSum(ar,dp, n-1), ar[n] + adjacentSum(ar, dp, n-2));
			return dp[n];
		} else {
			return dp[n];
		}
	}

}
