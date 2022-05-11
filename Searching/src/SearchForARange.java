import java.util.Arrays;

public class SearchForARange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForARange sf = new SearchForARange();
		int [] A = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.println(Arrays.toString(sf.searchRange(A, 10)));
	}
	
	public int[] ans = {-1,-1};
	
	public int[] searchRange(final int[] A, int B) {
		if(A.length == 1) {
			if(A[0] == B) {
				ans[0]=0;
				ans[1]=0;
			}
		} else {
		range(A,0,A.length-1,B);
		}
		return ans;
    }
	
	public void range(int [] A,int start,int end, int B) {
		if(start>end) {
			return;
		}
		int mid = (start + end)/2;
		
		if(A[mid] == B) {
			if(mid==A.length-1) {
				ans[1]=mid;
				return;
			}
			if(mid==0) {
				ans[0]=mid;
				return;
			}
			if(A[mid+1]>B) {
				ans[1] = mid;
				if(ans[0]==-1) {
					range(A,start,mid-1,B);
				} else {
					return;
				}
			}
			if(A[mid-1]<B) {
				ans[0]=mid;
				if(ans[1]==-1) {
					range(A,mid+1,end,B);
				} else {
					return;
				}
			}
			if(ans[1] !=-1 && ans[0] !=-1) {
				return;
			}
		}
		if(A[mid]<B) {
			range(A,mid+1,end,B);
		} else if(A[mid]>B) {
			range(A,start,mid-1,B);
		} else {
			range(A,start,mid-1,B);
			range(A,mid+1,end,B);
		}
		
	}

}
