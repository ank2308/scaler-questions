import java.util.LinkedList;
import java.util.Queue;

public class SumOfMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2,1};
		SumOfMinMax sm = new SumOfMinMax();
		System.out.println(sm.solve(A, 2));
	}
	public int solve(int[] A, int B) {
		Queue<Integer> minQ = new LinkedList<Integer>();
		Queue<Integer> maxQ = new LinkedList<Integer>();
		minQ.add(0);
		maxQ.add(0);
		int ans = 0;
		int minElement = 0 , maxElement = 0;
		for (int i = 1; i < A.length; i++) {			
			if (A[i] < A[minQ.peek()]) {
				while (!minQ.isEmpty() && A[i] < A[minQ.peek()]) {
					minQ.poll();
				}
				minQ.add(i); 
			} else {
				minQ.add(i);
			}
			if (A[i] > A[maxQ.peek()]) {
				while (!maxQ.isEmpty() && A[i] > A[maxQ.peek()]) {
					maxQ.poll();
				}
				maxQ.add(i); 
			} else {
				maxQ.add(i);
			}
			
			if (minQ.size() == B || i-minQ.peek() == B-1) {
				minElement = A[minQ.poll()];
			} else if (i>=B-1) {
				minElement = A[minQ.peek()];
			}
			if (maxQ.size() == B || i-maxQ.peek() == B-1) {
				maxElement = A[maxQ.poll()];
				ans= ans + ( minElement + maxElement);
			} else if (i>=B-1) {
				maxElement = A[maxQ.peek()];
				ans= ans + ( minElement + maxElement);
			}
		}
		return ans;
    }
}
