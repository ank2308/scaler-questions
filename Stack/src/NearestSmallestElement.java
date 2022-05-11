import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {39, 27, 11, 4, 24, 32, 32, 1};
		NearestSmallestElement nse = new NearestSmallestElement();
		System.out.println(Arrays.toString(nse.prevSmaller(A)));
	}
	
	public int[] prevSmaller(int[] A) {
		Stack<Integer> candidate = new Stack<>();
		ArrayList<Integer> temp = new ArrayList<>();
		if(A.length > 0) {
			candidate.push(0);
			temp.add(-1);
		} 
		for (int i = 1; i < A.length; i++) {
			while (!candidate.isEmpty() && A[i] <= A[candidate.peek()]) {
				candidate.pop();
			}
			if(!candidate.isEmpty() && A[i] > A[candidate.peek()]) {
				
				temp.add(A[candidate.peek()]);
				candidate.push(i);
			} else {
				temp.add(-1);
				candidate.push(i);
			}
		}
		int [] ans = new int [temp.size()];
		int index = 0;
		for (int i : temp) {
			ans[index] = i;
			index++;
		}
		return ans;
    }

}
