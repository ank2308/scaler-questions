
public class LogicalEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {377284,385649,22420,22981,}
	}
	private void findAnd (int n, int [] Ar) {
		long pow = (int) Math.pow(2, n);
		pow = pow-1;
		for (int i = 0; i < Ar.length; i++) {
			int ans = (int) (Ar[i] & pow);
		}
	}
	
}
