
public class AthMagicalNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AthMagicalNum athMagicalNum = new AthMagicalNum();
		System.out.println(athMagicalNum.solve(33488383, 565, 29473));
		
	}
	
	public int solve(int A, int B, int C) {
        int mod = (int) (Math.pow(10, 9) + 7);
        long low = 1;
		long high = (long) 1e18;
		long ans = -1;
		while (low <= high) {
			long mid = (low + high) / 2;
			long magic = (mid/B + mid/C) - (mid/lcm(B,C));
			if (magic >= A) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid+1;
			}
		}
		return (int) (ans%mod);
    }

    private int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
     
    // method to return LCM of two numbers
    private int lcm(int a, int b)
    {
        return ((a*b) / gcd(a, b)) ;
    }
	
}
