import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ReverseNElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,2,3,4,5};
		ReverseNElements ren = new ReverseNElements();
		System.out.println(Arrays.toString(ren.solve(A, 3)));
	}
	public int[] solve(int[] A, int B) {
		Deque<Integer> reverse = new LinkedList<>();
		for (int i = 0; i < B; i++) {
			reverse.add(A[i]);
		}
		for (int i = 0; i < B; i++) {
			A[i] = reverse.pollLast();
		}
		return A;
    }

}
