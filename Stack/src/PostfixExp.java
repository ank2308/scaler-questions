import java.util.Stack;

public class PostfixExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] S = {"4", "13", "5", "/", "+"};
		PostfixExp pf = new PostfixExp();
		System.out.println(pf.evalRPN(S));
	}
	
	public int evalRPN(String[] A) {
		Stack<Integer> number = new Stack<>();
		for (int i = 0; i < A.length; i++) {
			if(A[i].equals("+") || A[i].equals("-") || A[i].equals("/") || A[i].equals("*")) {
				int b = number.pop();
				int a = number.pop();
				int result = 0;
				if(A[i].equals("+"))
					result = a+b;
				if(A[i].equals("-"))
					result = a-b;
				if(A[i].equals("*"))
					result = a*b;
				if(A[i].equals("/"))
					result = a/b;
				number.push(result);
				
			} else {
				number.push(Integer.parseInt(A[i]));
			}
		}
		return number.pop();
    }

}
