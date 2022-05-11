
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] A = {'m','a','l','y','l','a','m'};
		solution s = new solution();
		System.out.println(s.isPalindrome(A, 0));
	}
	
	public boolean isPalindrome(char []A, int i) {
		if(A[i] != A[A.length - (i+1)]) {
			return false;
		}
		if(A.length%2 == 0 && i == A.length/2) {
			return true;
		} else if(A.length%2 != 0 && i == ((A.length/2)+1)) {
			return true;
		}
		return isPalindrome(A, i+1);
		
	}

}
