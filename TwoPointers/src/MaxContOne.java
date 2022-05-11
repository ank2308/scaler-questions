import java.util.Arrays;

public class MaxContOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
		MaxContOne mxc = new MaxContOne();
		System.out.println(Arrays.toString(mxc.maxone(A, 7 )));
	}
	
	public int[] maxone(int[] A, int B) {
		int finalL=0, finalR=0;
		int ans = 0;
		int tempAns =0;
		int Lpt = 0, Rpt=0;
		int countZero = 0;
		while (Rpt < A.length) {	
			if(Rpt == A.length-1 && A[Rpt] != 0) {
				tempAns++;
				if(tempAns > ans) {
					ans = tempAns;
					finalL = Lpt;
					finalR = Rpt;
				}
				break;
			} 	
			
			if(A[Rpt]==0) {
				if (countZero < B ) {
					countZero++;
					tempAns++;
					Rpt++;
				} else if(countZero == B){
					if(tempAns > ans) {
						ans = tempAns;
						finalL = Lpt;
						finalR = Rpt-1;
					}
					while (A[Lpt] != 0) {
						Lpt++;
						tempAns--;						
					}
					countZero--;
					Lpt++;
					tempAns--;
				}
			} else {
				tempAns++;
				Rpt++;
			}
			if(Rpt > A.length-1) {
				if(tempAns > ans) {
					ans = tempAns;
					finalL = Lpt;
					finalR = Rpt-1;
				}
			} 
			
			
		}
		int [] ret = new int [finalR-finalL+1];
		for (int i = 0; i<=((finalR-finalL)); i++) {
			ret[i] = finalL+i;
		}
		return ret;
	}

}
