import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "))))";
		BalancedParanthesis bp = new BalancedParanthesis();
		System.out.println(bp.solve(S));
	}
	
	public int solve(String A) {
		char [] ar = A.toCharArray();
		Stack<Character> charAr = new Stack<>();
		int i;
		for ( i = 0; i < ar.length; i++) {
			if(ar[i] == '(' || ar[i] == '{' || ar[i] == '[') {
				charAr.push(ar[i]);
			} else if (ar[i] == ')' && (charAr.isEmpty() || charAr.peek() != '(')) {
				break ;
			} else if (ar[i] == '}' && (charAr.isEmpty() || charAr.peek() != '{')) {
				break ;
			} else if (ar[i] == ']' && (charAr.isEmpty() || charAr.peek() != '[')) {
				break ;
			} else {
				charAr.pop();
			}
			
		}
		if(charAr.isEmpty() && i == ar.length) {
			return 1;
		} 
		return 0;
    }

}
