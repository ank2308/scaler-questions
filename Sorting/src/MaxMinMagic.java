import java.util.Arrays;

public class MaxMinMagic {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxMinMagic mns = new MaxMinMagic();
		int [] A = {3,11,-1,5};
//		int [] A = {1, 2, 3, 5, 6, 13, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19};
//		int [] A = {1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18};
		System.out.println(Arrays.toString(mns.solve(A)));
	}
	
	public int[] solve(int[] A) {
		int mod = (int) (Math.pow(10, 9) + 7);
		Arrays.sort(A);
		int max=0;
				int min=0;
		int [] ans = new int[2];
		// for generating max
		for (int i = 0; i < A.length/2; i++) {
			max=(max+(Math.abs(A[A.length-1-i] - A[i])%mod))%mod; 
		}
		ans[0] = (int) max;
		//for generating min
		for (int i = 0; i < A.length; i+=2) {
			min=(min+(Math.abs(A[i+1] - A[i])%mod))%mod;
		}
        ans[1]=min;
        return ans;
    }
}
