
public class DistributeCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 5, 2, 1};
		DistributeCandy candy = new DistributeCandy();
		System.out.println(candy.candy(A));
	}
	
	public int candy(int[] A) {
		int [] Lmax = new int [A.length];
		int [] RMax = new int [A.length];
		Lmax[0] = A[0];
		for(int i=1;i<A.length;i++) {
			if(A[i]>A[i-1]) {
				Lmax[i] = Lmax[i-1]+1;
			} else {
				Lmax[i] = 1;
			}
		}
		RMax[A.length-1]=1;
		for(int i=A.length-2;i>=0;i--) {
			if(A[i]>A[i+1]) {
				RMax[i] = RMax[i+1]+1;
			}else {
				RMax[i] = 1;
			}
		}
		int totalCandy=0;
		for(int i=0;i<A.length;i++) {
			totalCandy = totalCandy + (Math.max(RMax[i], Lmax[i]));
		}
		return totalCandy;
	}

}
