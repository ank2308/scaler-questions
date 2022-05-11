import java.util.ArrayList;
import java.util.Arrays;

public class QQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {5,1,3,1,5,4,5};
		int [][] B = {{1,5},{5,3},{3,4}};
		QQueries qq = new QQueries();
		System.out.println(Arrays.toString(qq.solve(A, B)));
	}
	public int[] solve (int []A, int[][] B) {
		
		
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if(A[j] == B[i][0]) {
					A[j] = B[i][1];
				}
			}
		}
		return A;
	}
}
