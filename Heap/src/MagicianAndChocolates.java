import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2147483647, 2000000014, 2147483647};
		MagicianAndChocolates chocolates = new MagicianAndChocolates();
		System.out.println(chocolates.nchoc(10, A));
	}
	
	public int nchoc(int A, int[] B) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		long sum = 0;
		int mod = (int) (Math.pow(10, 9) + 7);
		for (int i = 0; i < B.length; i++) {
			maxHeap.add(B[i]);
		}
		for (int i = 0; i < A; i++) {
			int temp = maxHeap.poll();
			maxHeap.add(temp/2);
			sum = (sum + temp);
		}
		return (int) (sum%mod);
    }

}
