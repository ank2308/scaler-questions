
public class LetsParty {

	public static void main (String [] args) {
		LetsParty party = new LetsParty();
		System.out.println(party.solve(19));
	}
	
	public int solve(int A) {
		int [] ar = new int [A+1];
		for (int i = 1; i <= A; i++) {
			if(i==1) {
				ar[i] = 1;
			} else if(i==2) {
				ar[i] = 2;
			} else {
				ar[i] = -1;
			}
		}
		int ans = findWays (A, ar) % 10003;
		return ans;
    }
	
	private int findWays(int n, int [] ar) {
		if(ar[n] == -1) {
			ar[n] = (findWays(n-1, ar) + findWays(n-2, ar) * (n-1)) % 10003;
			return ar[n];
		} else {
			return ar[n];
		}
	}
}
