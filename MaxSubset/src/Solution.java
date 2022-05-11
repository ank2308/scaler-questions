import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 2, 8};
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.subsets(A)));
	}
	
	public int[][] subsets(int[] A) {
		int size = (int) (Math.pow(2, A.length));
        int [][] ans = new int [size][];
             
        int index=0;
        for (int i = 0; i < size; i++) {
        	int temp = size;
            int limit = 0;
            while(temp != 0) {
            	temp = temp>>1;
            	limit++;
            }   
        	int [] tempArray = new int[limit];
			for (int j = 0; j < limit; j++) {
				if((i&(1<<j)) > 0) {
					tempArray[index] = A[j];
					index++;
				}
			}
			ans[i] = tempArray;
			index = 0;
		}
        return ans;
    }
}
