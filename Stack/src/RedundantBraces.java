import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "a+b";
		RedundantBraces rb = new RedundantBraces();
		System.out.println(rb.braces(A));
	}
	
	public int braces(String A) {
		char [] exp = A.toCharArray();
		int countOperator = 0;
		Stack<Character> charAr = new Stack<>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '(') {
				charAr.push(exp[i]);
			} else if (exp[i] == '+' || exp[i] == '-' || exp[i] == '*' || exp[i] == '/') {
				if(!charAr.isEmpty())
					countOperator++;
			} else if (exp[i] == ')') {
				if(countOperator != 0) {
					charAr.pop();
					if(charAr.isEmpty()) {
						countOperator = 0;
					} else {
						countOperator--;
					}
				} 
			}
			
		}
		if(charAr.isEmpty()) {
			return 0;
		}
		return 1;
    }

}
