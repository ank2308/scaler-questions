import java.util.Iterator;

public class Solution {
	public int trap(final int[] A) {
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
        for (int i = 0; i < Rmax.length; i++) {
			sum = sum + (Math.min(Lmax[i], Rmax[i]) - A[i]);
		}
        return sum;
    }
	
	public static void main(String [] args) {
		int arr [] = {0,1,0,2};
		Solution s = new Solution();
		System.out.println(s.trap(arr));
	}
}
