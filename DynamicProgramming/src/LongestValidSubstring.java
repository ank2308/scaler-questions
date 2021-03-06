import java.util.Stack;

public class LongestValidSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidSubstring longestValidSubstring = new LongestValidSubstring();
		System.out.println(longestValidSubstring.LBSlength("((([]([[][[{([[][}"));
	}

	public int LBSlength(final String A) {
		char [] string = A.toCharArray();
		Stack<Character> stack = new Stack<>();
		int maxLength=0;
		int tempLength=0;
		for (int i = 0; i < string.length; i++) {
			if(string[i] == '(' || string[i] == '[' || string[i] == '{') {
				stack.push(string[i]);
			} else {
				
				if (stack.isEmpty()) {
					maxLength = Math.max(maxLength, tempLength);
					tempLength = 0;
				} else if((string[i] == ')' && stack.peek() == '(') || 
						(string[i] == '}' && stack.peek() == '{') || 
						(string[i] == ']' && stack.peek() == '[')) {
					stack.pop();
					tempLength+=2;
					maxLength = Math.max(maxLength, tempLength);
				} else {
					maxLength = Math.max(maxLength, tempLength);
					tempLength = 0;
					stack.clear();
				}
			}			
		}
		return maxLength;
    }
}
