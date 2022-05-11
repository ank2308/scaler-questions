
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.solve(6816621, 8157697));
	}
	
	public int solve(int A, int B) {
		if(A>B) {
			return A-B;
		} else {
			return B-A;
		}
		
    }
}
