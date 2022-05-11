
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sln = new Solution();
		System.out.println(sln.solve(5));
	}
	
	public int solve(int A) {
		int pow = 0;
		while(A>0) {
			pow++;
			A = A/2;
		}
		return (int)Math.pow(2, pow-1);
	}

}
