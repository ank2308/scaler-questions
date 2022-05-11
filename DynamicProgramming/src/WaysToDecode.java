/*Problem Description
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.



Problem Constraints
1 <= length(A) <= 105



Input Format
The first and the only argument is a string A.



Output Format
Return an integer, representing the number of ways to decode the string modulo 109 + 7.



Example Input
Input 1:

 A = "12"
Input 2:

 A = "8"


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
Explanation 2:

 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.*/

public class WaysToDecode {

	public static void main(String[] args) {
		WaysToDecode decode = new WaysToDecode();
		System.out.println(decode.numDecodings("1234"));
	}
	
	
	public int numDecodings(String A) {
		char [] Ar = A.toCharArray();
		int [] finalAr = new int [Ar.length];
		for (int i = 0; i < finalAr.length; i++) {
			finalAr[i] = (int)(Ar[i]) - 48;
		}
		return (int) findDecodings(finalAr);
    }
	
	private long findDecodings (int [] A) {
		int mod = (int) (Math.pow(10, 9) + 7);
		if(A.length == 0) {
			return 0;
		}
		if (A[0] == 0) {
			return 0;
		}
		long [] dp = new long [A.length+1];
		
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 1; i < A.length; i++) {
			if(A[i] >=1 && A[i] <= 9) {
				dp[i+1] = dp[i];
			}
			if(A[i-1] == 1) {
				dp[i+1] = (dp[i+1] + dp[i-1]) % mod;
			} else if (A[i-1]==2 && A[i]>=0 && A[i] <= 6){
				dp[i+1] = (dp[i+1] + dp[i-1]) % mod;
			}
		}
		return dp[dp.length-1];
	}

}
