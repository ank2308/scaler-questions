
public class OddFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddFibonacci of = new OddFibonacci();
		System.out.println(of.solve(15216, 100001197));
	}
	
	public int solve(int A, int B) {
		
        int cnt = ((B/3) - ((A-1)/3));
        int result = ((B - A) + 1) - cnt;
        return result;
    }

}
