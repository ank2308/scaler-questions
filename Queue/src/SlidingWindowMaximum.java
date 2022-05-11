import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		System.out.println(Arrays.toString(swm.slidingMaximum(A, 9)));
	}
	public int[] slidingMaximum(final int[] A, int B) {
		Deque<Integer> slidingWindow = new LinkedList<Integer>();
		slidingWindow.add(0);
		int [] ans = new int [A.length - B + 1];
		int index = 0;
		if(B != 1) {
			for (int i = 1; i < A.length; i++) {
				
				if(slidingWindow.size() == B || i-slidingWindow.peek() > B-1) {
					slidingWindow.poll();
				}
				
				if(!slidingWindow.isEmpty() && A[i] > A[slidingWindow.peek()]) {
					while(!slidingWindow.isEmpty()) {
						slidingWindow.poll();
					}
					slidingWindow.add(i);
				} else {
					while(!slidingWindow.isEmpty() && A[i] > A[slidingWindow.getLast()]) {
						slidingWindow.removeLast();
					}
					slidingWindow.add(i);
				}
				if(i==B-1 || i-index >= B-1) {
					ans[index++] = A[slidingWindow.peek()];
				}
			}
		} else {
			return A;
		}
		return ans;
    }
}
