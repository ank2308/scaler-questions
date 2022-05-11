import java.util.Arrays;

public class RotateArrayBy90 {
	public static void main(String [] args) {
//		int [][] a = {{1,2,3},{4,5,6},{7,8,9}};
		int [][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		RotateArrayBy90 rt = new RotateArrayBy90();
		rt.solve(a);
		System.out.println(Arrays.deepToString(a));
	}
	
	public void solve(int[][] A) {
		int temp1,temp;
		int limit = (A.length);
		int tempi=0,tempj=0;
		int length = A.length-1;
//		length = length >= 3 ? length-1:length;
		for(int i=0;i<limit/2;i++) {
			for(int j=i;j<((length)-i);j++) {
				tempi = j;
				tempj = length-i;
				temp = A[tempi][tempj];
				A[tempi][tempj] = A[i][j];
				for (int k = 0; k < 3; k++) {
					temp1 = tempi;
					tempi = tempj;
					tempj = length-temp1;
					temp1 = A[tempi][tempj];
					A[tempi][tempj] = temp;
					temp = temp1;
				}				
			}
		}
    }
}
