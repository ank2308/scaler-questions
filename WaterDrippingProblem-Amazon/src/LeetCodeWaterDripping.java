import java.util.ArrayList;

public class LeetCodeWaterDripping {

	public static void main (String [] args) {
		int [] A = {1,2,1};
		LeetCodeWaterDripping codeWaterDripping = new LeetCodeWaterDripping();
		System.out.println(codeWaterDripping.maxArea(A));
	}
	public int maxArea(int[] A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int Lmax [] = new int [A.length];
        int Rmax [] = new int [A.length];
        int lmax = A[0], rmax=A[A.length-1];
        int sum = 0;
        Lmax[0] = lmax;
        Rmax[A.length-1] = rmax;
        for(int i=1; i<A.length; i++){
            if(lmax > A[i]){
                Lmax[i] = lmax;
            } else {
                Lmax[i] = A[i];
                lmax = A[i];
            }            
        }
        for (int i = A.length-1; i >= 0; i--) {
        	if(rmax > A[i]){
                Rmax[i] = rmax;
            } else {
                Rmax[i] = A[i];
                rmax = A[i];
            }
		}
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i < Rmax.length; i++) {
        	if(Lmax[i] > Lmax[i-1]) {
        		maxIndex = i;
        	}
			sum = Math.min(Lmax[i], Rmax[i]) * (i-maxIndex);
			max = Math.max(max, sum);
		}
        return sum;
	}
}
