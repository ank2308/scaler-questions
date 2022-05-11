
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sln = new Solution();
		System.out.println(sln.solve(5000));
	}
	public int solve(int A) {
		int sum = 0;
		int x = 1;
		while(A>0) {
			x = x*5;
			if(A%2==1) {
				sum += x;
			}
			A = A/2;
		}
		return sum;
	}
}
