import java.util.ArrayList;
import java.util.List;

public class SubArrayZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,2,3,-2,5,-8};
		SubArrayZeroSum sm = new SubArrayZeroSum();
		System.out.println(sm.solve(A));
	}
	public int solve(int[] A) {
		long preSum =0;
		int mod = (int) (Math.pow(10, 9) + 7);
		List<Long> preSumList = new ArrayList<Long>();
		for (int i = 0; i < A.length; i++) {
			
			preSum = (preSum + A[i]) % mod;
			if(preSumList.contains(preSum) || preSum == 0) {
				return 1;
			} else {
				preSumList.add(preSum);
			}
		}
		return 0;
    }

}
