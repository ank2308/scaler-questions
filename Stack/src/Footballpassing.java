import java.util.Stack;

public class Footballpassing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
		Footballpassing fb = new Footballpassing();
		System.out.println(fb.solve(26, 10, A));
	}
	
	public int solve(int A, int B, int[] C) {
		int finalPass = A;
		Stack<Integer> passes = new Stack<>();
		for (int i = 0; i < C.length; i++) {
			if(C[i] != 0) {
				passes.push(C[i]);
			} else {
				passes.pop();
			}			
		}
		if(!passes.isEmpty())
		finalPass = passes.pop();
		return finalPass;
    }

}
