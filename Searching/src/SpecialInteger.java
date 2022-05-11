
public class SpecialInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {5, 17, 100, 11} ;
		SpecialInteger si = new SpecialInteger();
		System.out.println(si.solve(A, 10));
	}
	public int solve(int[] A, int B) {
		int start = 1;
		int end = A.length;
		int [] prefixAr = new int [A.length];
		prefixAr[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			prefixAr[i] = prefixAr[i-1] + A[i]; 
		}
		while(start<=end) {
			int mid = (start+end)/2;
			if (arrayExist(prefixAr, mid, B)) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return end!=0?end:-1;
    }
	
	private boolean arrayExist(int [] A, int size,  int B) {
		int sizeEle = 0;
		boolean flag = true;
		for (int i = 0; i < A.length; i++) {
			if(i>=size) {
				if(sizeEle > B) {
					flag = false;
					break;
				}	
				sizeEle = A[i] - A[i-size];
			} else {
				sizeEle = A[i];
			}		
		}
		if(sizeEle > B) {
			flag = false;
		}	
		return flag;
	}
}
