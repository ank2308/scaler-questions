import java.util.ArrayList;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cccaacbcaabb";
		Solution s1 = new Solution();
		System.out.println(s1.partition(s));
		char [] arr = {'a','c','b','c','a'};
		System.out.println(isPalindrome(arr) );
	}
	
	ArrayList<ArrayList<String>> ans;	 
	
	public static boolean isPalindrome(char []str ) {
		for (int i = 0; i < str.length/2; i++) {
			char a = str[i];
			char b = str[str.length-(1+i)];
			if(a != b) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<ArrayList<String>> partition (String s){
		ans = new ArrayList<ArrayList<String>>();
		ArrayList<String> stack = new ArrayList<>();
		partitionHelper(s, 0, stack);
		return ans;
	}
	
	public void partitionHelper(String str, int index, ArrayList<String> stack) {
		if(str.length() == 1) {
			stack.add(str);
			ans.add(new ArrayList<>(stack));
			stack.remove(stack.size()-1);
			return;
		} 
		if(str.isEmpty()) {
			ans.add(new ArrayList<>(stack));
			return;
		}
			for (int i = 0; i < str.length(); i++) {
				String tempString = str.substring(0, index+1);
				if(isPalindrome(tempString.toCharArray())) {
					stack.add(tempString);
					partitionHelper(str.substring(index+1,str.length()), 0, stack);
					stack.remove(stack.size()-1);
				}
				index++;
			}
		
	}

}
