import java.util.Arrays;
import java.util.Stack;

public class SortStackUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A  = {};
		SortStackUsingStack ss = new SortStackUsingStack();
		System.out.println(Arrays.toString(ss.solve(A)));
	}
	
	public int[] solve(int[] A) {
		Stack<Integer> mainStack  = new Stack<>();
		Stack<Integer> bkStack = new Stack<>();
		if(A.length > 0) {
			mainStack.push(A[0]);
			for (int i = 1; i < A.length; i++) {
				while(!mainStack.isEmpty() && mainStack.peek() < A[i]) {
					bkStack.push(mainStack.pop());
				}
				mainStack.push(A[i]);
				while(!bkStack.isEmpty()) {
					mainStack.push(bkStack.pop());
				}
			}
		}
		int [] ans = new int [A.length];
		int i = 0;
		while(!mainStack.isEmpty()) {
			ans[i] = mainStack.pop();
			i++;
		}
		return ans;
    }

}
