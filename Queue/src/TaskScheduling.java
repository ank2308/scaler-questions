import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1};
		int [] B = {1};
		TaskScheduling ts = new TaskScheduling();
		System.out.println(ts.solve(A, B));
	}

	public int solve(int[] A, int[] B) {
		Queue<Integer> number = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			number.add(A[i]);
		}
		int cycles = 0;
		for (int i = 0; i < B.length; i++) {
			while (B[i] != number.peek()) {
				number.add(number.poll());
				cycles++;
			} 
			number.poll();
			cycles++;
			
		}
		return cycles;
    }
}
