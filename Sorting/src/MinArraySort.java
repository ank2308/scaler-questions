import java.util.Arrays;

public class MinArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinArraySort mns = new MinArraySort();
		int [] A = {1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15};
//		int [] A = {1, 2, 3, 5, 6, 13, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19};
//		int [] A = {1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18};
		System.out.println(Arrays.toString(mns.subUnsort(A)));
	}
	
	public int[] subUnsort(int[] A) {
		int [] temp = A.clone();
		Arrays.sort(temp);
		int start=-1,end = -1;
		int [] ans;
		for (int i = 0; i < temp.length; i++) {
			if (A[i] != temp[i] && start ==-1) {
				start = i;
				end =i;
			} 
			if(A[i] != temp[i] && start !=-1) {
				end=i;
			}
		}
		if(start != -1) {
			ans=new int[2];
			ans[0] = start;
			ans[1]=end;
		} else {
			ans = new int[1];
			ans[0] = -1;
		}
		return ans;
    }

}
