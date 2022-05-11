
public class MtrixSearch {
	public static void main(String [] args) {
	
		int [][] A = {{1}};
		MtrixSearch ms = new MtrixSearch();
		System.out.println(ms.searchMatrix(A, 1));
	}
	public int searchMatrix(int[][] A, int B) {
		int row = A.length;
		int column = A[0].length;
		return searchElement(A, 0, ((row*column)-1), B, column);
    }
	
	public int searchElement(int [][] A, int start, int end, int B, int column) {
		if(start > end ) {
			return 0;
		}
		int mid = (start+end) / 2;
		int i = mid/column;
		int j = mid%column;
		if(A[i][j] == B) {
			return 1;
		}
		if(B < A[i][j]) {
			return searchElement(A, start, mid-1, B, column);
		} else {
			return searchElement(A, mid+1, end, B, column);
		}
	}
}
