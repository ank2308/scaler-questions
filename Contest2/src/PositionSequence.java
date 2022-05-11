
public class PositionSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PositionSequence ps = new PositionSequence();
		System.out.println(ps.solve(8, 21));
	}
	public int solve(int A, int B ) {
		int val = 2;
		int temp = B;
		temp = temp-1;
		int length = A-1;
		while (temp-(length*val) > 0) {
			temp=temp-val;
			length--;
			val = val+1;
		}
		if((temp-(length*val)) == 0) {
			return --length;
		}
		return length;
	}
}
