import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaxFreqStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,46},{2,0},{1,11},{1,38},{2,0},{1,71},{2,0},{2,0},{1,45},{2,0},{1,27},{1,23},{2,0},{1,69},{2,0},{2,0},{1,76},{1,64},{2,0},{2,0},{1,13},{1,13},{1,93},{1,90},{2,0},{2,0},{2,0},{1,4},{1,63},{2,0},{1,9},{2,0},{1,26},{1,29},{2,0},{2,0},{1,26},{2,0},{1,91},{1,52},{1,89},{1,8},{1,95},{2,0},{2,0},{2,0},{2,0},{2,0},{2,0},{1,38},{2,0},{2,0},{1,65}};
		MaxFreqStack mf = new MaxFreqStack();
		System.out.println(Arrays.toString(mf.solve(A)));
	}
	public int[] solve(int[][] A) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> frequent = new Stack<Integer>();		
		int [] ans = new int [A.length];
		int length = A.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			if (A[i][0] == 1) {
				stack.push(A[i][1]);
				if(map.get(A[i][1]) == null) {
					map.put(A[i][1], 1);
				} else {
					int temp = map.get(A[i][1]);
					temp++;
					map.replace(A[i][1], temp);
				}
				if(!frequent.isEmpty()) {
					if (frequent.peek() != A[i][1]) {
						if(map.get(A[i][1]) >= map.get(frequent.peek())) {
							frequent.push(A[i][1]);
						} else {
							frequent.push(frequent.peek());
						}
					} else {
						frequent.push(frequent.peek());
					}
				} else {
					frequent.push(A[i][1]);
				}
				ans[i] = -1;
			} else {					
				int peakElement = frequent.pop();
				int freq = map.get(peakElement);
				map.replace(peakElement, --freq);
				ans[i] = peakElement;
				int [] temp = new int[stack.size()];
				int index = 0;
				while(stack.peek() != peakElement) {
					temp[index] = stack.pop();
					index++;
				}
				
			}
		}
		return ans;
    }
	
	
}
