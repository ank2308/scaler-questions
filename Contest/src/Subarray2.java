
public class Subarray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {4,2,5,1};
		Subarray2 sub = new Subarray2();
		System.out.println(sub.sum(4, A));
	}
	
	public int sum(int A, int [] B) {
		int mod = (int)(Math.pow(10,9)) + 7;
		int sum = 0;
		for (int i = 0; i < B.length; i++) {
			for (int j = i; j < B.length-1; j++) {
				if(Math.abs((B[i] - B[j+1])) > 1) {
					sum = (sum + (B[j+1] - B[i])%mod)%mod;
				} else {
					sum = sum + 0;
				}
			}
		}
		if(sum < 0) {
			sum  = mod + sum;
		}
		return sum;
	}

}
