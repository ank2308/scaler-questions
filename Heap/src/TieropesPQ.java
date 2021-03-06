import java.util.PriorityQueue;

public class TieropesPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {5, 12, 16, 5, 12, 19, 4, 3, 18, 15, 16};
		TieropesPQ tr = new TieropesPQ();
		System.out.println(tr.solve(A));
	}
	
	public int solve(int[] A) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < A.length; i++) {
			minHeap.add(A[i]);
		} int sum = 0;
		while (minHeap.size() > 1) {
			int minA = minHeap.poll();
			int minB = minHeap.poll();
			int temp = minA + minB;
			sum = sum + temp;
			minHeap.add(temp);
		}
		return sum;
	}

}
