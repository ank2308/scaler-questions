import java.util.Arrays;

public class BoringString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		BoringString bs = new BoringString();
		System.out.println(bs.solve(s));
	}
	public int solve(String A) {
		char [] ar = A.toCharArray();
		String even = "";
		String odd = "";
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] % 2 == 0) {
				even = even + ar[i];
			} else {
				odd = odd + ar[i];
			}
		}
		char [] arEven = even.toCharArray();
		char [] arOdd = odd.toCharArray();
		
		Arrays.sort(arEven);
		Arrays.sort(arOdd);
		if(Math.abs(arOdd[arOdd.length - 1] - arEven[0]) != 1) {
			return 1;			
		}
		if(Math.abs(arEven[arEven.length - 1] - arOdd[0]) != 1) {
			return 1;
		}
		return 0;
    }
}
