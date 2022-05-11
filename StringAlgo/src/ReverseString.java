import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is   blue";
		ReverseString reverseString = new ReverseString();
		System.out.println(reverseString.solve(s));
	}
	public String solve(String A) {
		A = A.trim();
		String [] ar = A.split(" ");
		Stack<String> stringstack = new Stack<>();
		for (String string : ar) {
			if(string.length() > 0) {
				stringstack.add(string);
			}
		}
		String ans = "";
		while (!stringstack.isEmpty()) {
			ans = ans + stringstack.pop();
			if(!stringstack.isEmpty()) {
				ans = ans + " ";
			}
		}
		return ans;
    }
}
