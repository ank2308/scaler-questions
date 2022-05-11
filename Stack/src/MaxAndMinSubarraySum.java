import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxAndMinSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {39, 27, 11, 4, 24, 32, 32, 1};
		MaxAndMinSubarraySum nse = new MaxAndMinSubarraySum();
		nse.solve(A);
	}

	public int solve(int[] A) {
		Stack<Integer> candidate = new Stack<>();
		ArrayList<Integer> nsl = new ArrayList<>();
		if(A.length > 0) {
			candidate.push(0);
			nsl.add(1);
		} 
		for (int i = 1; i < A.length; i++) {
			while (!candidate.isEmpty() && A[i] <= A[candidate.peek()]) {
				candidate.pop();
			}
			if(!candidate.isEmpty() && A[i] > A[candidate.peek()]) {				
				nsl.add(i - candidate.peek());
				candidate.push(i);
			} else {
				nsl.add(i);
				candidate.push(i);
			}
		}
		System.out.println(nsl.toString());
		candidate = new Stack<>();
		ArrayList<Integer> ngL = new ArrayList<>();
		if(A.length > 0) {
			candidate.push(0);
			ngL.add(1);
		} 
		for (int i = 1; i < A.length; i++) {
			while (!candidate.isEmpty() && A[i] >= A[candidate.peek()]) {
				candidate.pop();
			}
			if(!candidate.isEmpty() && A[i] < A[candidate.peek()]) {				
				ngL.add(i-candidate.peek());
				candidate.push(i);
			} else {
				ngL.add(i);
				candidate.push(i);
			}
		}
		
		//1, 32, 32, 24, 4, 11, 27, 39
		
		ArrayList<Integer> nsR = new ArrayList<>();
		candidate = new Stack<>();
		if(A.length > 0) {
			candidate.push(A.length-1);
			nsR.add(1);
		} 
		for (int i = (A.length -2); i >= 0; i--) {
			while (!candidate.isEmpty() && A[i] <= A[candidate.peek()]) {
				candidate.pop();
			}
			if(!candidate.isEmpty() && A[i] > A[candidate.peek()]) {				
				nsR.add(candidate.peek() - i);
				candidate.push(i);
			} else {
				nsR.add(i);
				candidate.push(i);
			}
		}
		//39, 27, 11, 4, 24, 32, 32, 1
		ArrayList<Integer> ngR = new ArrayList<>();
		candidate = new Stack<>();
		if(A.length > 0) {
			candidate.push(A.length-1);
			ngR.add(1);
		} 
		for (int i = (A.length -2); i >= 0; i--) {
			while (!candidate.isEmpty() && A[i] >= A[candidate.peek()]) {
				candidate.pop();
			}
			if(!candidate.isEmpty() && A[i] < A[candidate.peek()]) {				
				ngR.add(candidate.peek() - i);
				candidate.push(i);
			} else {
				ngR.add(i);
				candidate.push(i);
			}
		}
//		Collections.reverse(ngR);
		System.out.println(ngR.toString());
		return 0;
    }
}
