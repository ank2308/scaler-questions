
public class CountNoOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{0, 0, 1, 0, 1, 0, 1, 1, 1},{0, 1, 0, 0, 1, 1, 1, 0, 1}};
		CountNoOfIsland countNoOfIsland = new CountNoOfIsland();
		System.out.println(countNoOfIsland.solve(A));
	}
	
	int [][] visitedAr ;
	int numOfIsland = 0;
	public int solve(int[][] A) {
		int row = A.length;
		int column = A[0].length;
		visitedAr = new int [row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(visitedAr[i][j] == 0 && A[i][j] == 1) {
					numOfIsland++;
					markIslandNode(A, i, j, row, column);
				}
			}
		}
		return numOfIsland;
	}
	
	private void markIslandNode (int [][]A, int rIndex, int cIndex, int row, int column) {
		int [] Rx = {-1, 0 , 1, 0, -1, 1, -1, 1};
		int [] Ry = {0, -1, 0, 1, -1, 1, 1, -1};
		for (int i = 0; i < Ry.length; i++) {
			int newR = rIndex + Rx[i];
			int newC = cIndex + Ry[i];
			if (isValid(A, newR, newC, row, column)) {
				visitedAr[newR][newC] = 1;
				markIslandNode(A, newR, newC, row, column);
				
			}
		}
	}
	
	private boolean isValid (int [][]A, int i, int j, int row, int column) {
		if(i>=0 && j>=0 && i<row && j<column) {
			if(A[i][j] == 1 && visitedAr[i][j] == 0) {
				return true;
			}
		}
		return false;
	}

}
