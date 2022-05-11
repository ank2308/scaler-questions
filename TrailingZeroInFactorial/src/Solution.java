
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sln = new Solution();
		System.out.println(sln.solve(28));
	}
	public int solve(int A) {
		int count = 0;
		for (int i = 5; A / i >= 1; i *= 5)
            count += A / i;
 
        return count;
	}
}
