
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.gcd(4, 6));
	}
	public int gcd(int A, int B) {
		if(B == 0) {
			return A;
		}
		return gcd(B,A%B);
    }
}
