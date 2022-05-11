
public class ClimbStairs {
	 public static void main(String [] args) {
		 ClimbStairs climbStairs = new ClimbStairs();
		 climbStairs.climbStairs(1);
		 
	 }
	 
	 public int climbStairs(int A) {
	        int [] ar = new int [A+1];
	        for (int i=1; i<=A; i++) {
	        	if(i==1) {
	        		ar[i] = 1;
	        	} else if(i==2) {
	        		ar[i] = 2;
	        	} else {
	        		ar[i] = -1;
	        	}
	            
	        }
	        return findWays(A, ar);
	    }

	    private int findWays(int A, int [] arr) {
	        if(arr[A] == -1) {
	            arr[A] = findWays(A-1, arr) + findWays(A-2, arr);
	            return arr[A];
	        } else {
	            return arr[A];
	        }
	    }
}
