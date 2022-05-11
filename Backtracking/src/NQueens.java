import java.util.ArrayList;

public class NQueens {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens np = new NQueens();
		System.out.println(np.solveNQueens(4));
	}
	
	ArrayList<String> node = new ArrayList<>();
	ArrayList<ArrayList<String>> ans = new ArrayList<>();
	
	public ArrayList<ArrayList<String>> solveNQueens(int A) {
		int [] colAr = new int[A];
		int [] lDiag = new int[2*A];
		int [] rDiag = new int[2*A];
		for (int i = 0; i < rDiag.length; i++) {
			rDiag[i] = lDiag[i] = -1;
		}
		for (int i = 0; i < colAr.length; i++) {
			colAr[i] = -1;
		}
		solveQueen(A, colAr, lDiag, rDiag, 0, 0);
		return ans;
	}
	
	public void solveQueen(int A, int [] colAr, int [] lDiag, int [] rDiag, int row, int column) {
		if(row == A) {
			String str = "";
			int [] tempAr = new int [A];
			int temp = 0;
			for (int i : colAr) {
				tempAr[i] = temp;
				temp++;
			}
			for (int col : tempAr) {
				for (int j = 0; j < A; j++) {					
					if(col==j) {
						str = str + 'Q';
					} else {
						str = str + '.';
					}
				}
				node.add(str);
				str = "";
			}
			ans.add(new ArrayList<>(node));
			node = new ArrayList<>();
			return;
		}
		if(column>A-1) {
			return;
		}
		
		if(colAr[column] == -1 && (lDiag[row + column] == -1) && (rDiag[A-1+ (row - column)] == -1)) {
			colAr[column] = row;
			lDiag[row + column] = 1;
			rDiag[A-1+ (row - column)] = 1;
			solveQueen(A, colAr, lDiag, rDiag, row+1, 0);
			colAr[column] = -1;
			lDiag[row + column] = -1;
			rDiag[A-1+ (row - column)] = -1;
		}
		
		solveQueen(A, colAr, lDiag, rDiag, row, column+1);		
		return;
	}
}
