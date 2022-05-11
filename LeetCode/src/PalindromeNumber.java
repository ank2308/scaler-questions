
public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeNumber pn = new PalindromeNumber();
//		System.out.println(pn.isPalindrome(1));
		String a = "agao";
		StringBuffer sb = new StringBuffer(a);
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	public boolean isPalindrome(int x) {
//		String s = "" + x;
//		if(s.charAt(0) == '+' || s.charAt(0) == '-') {
//			return false;
//		}
//		int len = s.length();
		if(x<0) {
			return false;
		}
		int dup = x;
		int temp = 0;
		int ans = 0;
		while(x!=0) {
			temp = x%10;
			x = x/10;
			ans = (ans*10) + temp;
		}
		if(ans == dup) {
			return true;
		} else {
			return false;
		}
    }

}
