import java.util.Iterator;

public class Solution {
	
	public static void main(String [] args) {
		Solution sln = new Solution();
		int [] A = {1,1,3,2,2,2,1,3,3,6};
		System.out.println(sln.singleNumber(A));
	}
	public int singleNumber(final int[] A) {
		int sum=0;
		int number=0;
		for(int i=0;i<32;i++) {
			for (int j = 0; j < A.length; j++) {
				if((A[j]&(1<<i)) >0)
					sum += 1;
			}
			if(sum%3 !=0) {
				number += (1<<i);
			}
			sum=0;
		}
		return number;
    }
}
