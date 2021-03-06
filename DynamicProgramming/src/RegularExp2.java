/*Problem Description

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' . ' : Matches any single character.
' * ' : Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Problem Constraints

1 <= length(A), length(B) <= 104



Input Format

The first argument of input contains a string A.
The second argument of input contains a string B denoting the pattern.



Output Format

Return 1 if the patterns match else return 0.



Example Input

Input 1:

 A = "aab"
 B = "c*a*b"
Input 2:

 A = "acz"
 B = "a.a"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
 So, return 1.
Explanation 2:

 '.' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0.*/

public class RegularExp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "aasdfasdfasdfasdfas";
		String B = "aasdf.*asdf.*asdf.*asdf.*s";
		RegularExp2 exp2 = new RegularExp2();
		System.out.println(exp2.isMatch(A, B));
	}

	public int isMatch(final String A, final String B) {
		if (match(A, B, A.length(), B.length())) {
			return 1;
		} else {
			return 0;
		}
    }
	
	private boolean match(String A, String B, int i, int j) {
		if(i==0 && j==0) {
			return true;
		}
		if(j==0)
			return false;
		if(i==0) {
			while(j!=0) {
				if(j>1 && B.charAt(j-1) == '*')
					j=j-2;
				else
					return false;
			}
			return true;
		}
		if(A.charAt(i-1) == B.charAt(j-1) || B.charAt(j-1) == '.') {
			return match(A,B,i-1,j-1);
		} else if(B.charAt(j-1) == '*') {
			if(B.charAt(j-2) == A.charAt(i-1) || B.charAt(j-2) == '.') {
				return match(A,B,i-1,j) || match(A,B,i-1,j-2) ||match(A,B,i,j-2);
			} else {
				return match(A,B,i,j-2);
			}
		} else {
			return false;
		}
		
	}
}
