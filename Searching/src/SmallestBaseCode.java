
public class SmallestBaseCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestBaseCode sbc = new SmallestBaseCode();
		System.out.println(sbc.solve("4681"));
	}
	public String solve(String A) {
		long numberInLong = Long.valueOf(A);
        int maxOne = (int) (Math.log(numberInLong + 1) / Math.log(2)) - 1;
        long res = numberInLong - 1;
        for (int i = maxOne; i > 1; i--) {
            long base = (long) Math.pow(numberInLong, 1.0 / i);
            if (geometric(base, i) == numberInLong) return String.valueOf(base); 
        }
        return String.valueOf(res);
    }
	private long geometric(long base, int m) {
        long res = 0;
        for (int i = 0; i <= m; i++) {
            res = 1 + res * base;
        }
        return res;
    }
	
	
	
}
