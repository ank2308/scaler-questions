import java.util.ArrayList;
import java.util.Iterator;

public class LogestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"abcdefgh", "aefghijk", "abcefgh"
		ArrayList<String> A = new ArrayList<>();
		A.add("abab");
		A.add("ab");
		A.add("abcd");
		LogestCommonPrefix commonPrefix = new LogestCommonPrefix();
		System.out.println(commonPrefix.longestCommonPrefix(A));
	}
	
	public String longestCommonPrefix(String [] A) {
		int min = Integer.MAX_VALUE;
		ArrayList<char []> ar = new ArrayList<>();
		for (String string : A) {
			char [] temp = string.toCharArray();
			ar.add(temp);
			min = Math.min(min, temp.length);
			
		}
		char [] temp = new char[min];
		for (char[] cs : ar) {
			if(cs.length == min) {
				temp = cs;
			}
		}
		ar.remove(temp);
		String s = "";
		boolean flag = true;
		for (int i = 0; i < min; i++) {
			
			for (char[] cs : ar) {
				if(cs[i] != temp [i]) {
					flag = false;
					break;
				}
			}
			if(flag == false) {
				break;
			} else {
				s=s+temp[i];
			}
		}
		return s;
    }

}
