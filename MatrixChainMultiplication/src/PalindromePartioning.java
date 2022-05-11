
public class PalindromePartioning {

	int [][] dp = new int [502][502];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		PalindromePartioning  palindromePartioning = new PalindromePartioning();
		System.out.println(palindromePartioning.minCut(s));
	}
	
	private int minCut(String s) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				dp[i][j] = -1;
			}
		}
		return palpar(s, 0, s.length()-1);
	}
	
	private int palpar(String s, int i, int j) {
		if(i>=j) {
			return 0;
		}
		if(isPalindrome(s, i, j) == true) {
			return 0;
		}
		if(dp[i][j] != -1)
			return dp[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = 1 + palpar(s,i,k) + palpar(s,k+1,j);
			if(temp < min) {
				min = temp;
			}
		}
		return dp[i][j] = min;
	}
	
	private boolean isPalindrome (String s, int i, int j) {
		if (i==j)
			return true;
		if (i>j)
			return true;
		while (i<j) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
