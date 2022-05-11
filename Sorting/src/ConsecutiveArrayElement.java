import java.util.Arrays;

public class ConsecutiveArrayElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {3,4,2,5,6};
		ConsecutiveArrayElement ms = new ConsecutiveArrayElement();
		System.out.println(ms.solve(A));
	}
	public int solve(int[] A) {
		Arrays.sort(A);
		int ans=0;
		int diff = A[0]-1;
		for (int i = 0; i < A.length; i++) {
			if(A[i] != i+1+diff) {
				ans = 0;
				for (int j = i+1; j < A.length; j++) {
					if(A[j] == i+1) {
						ans = 1;
						break;
					}
				}
				if(ans==0) {
					return ans;
				}
			}
			ans = 1;
		}
		return ans;
    }

}
