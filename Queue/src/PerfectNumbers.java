import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectNumbers pn = new PerfectNumbers();
		System.out.println(pn.solve(3));
	}
	public String solve(int A) {
		Queue<String> comb = new LinkedList<>();
		comb.add("1");
		comb.add("2");
		ArrayList<String> ar = new ArrayList<String>();
		StringBuilder temp;
		for (int i = 0; i < A;) {
			temp = new StringBuilder();
			temp.append(comb.peek());
			comb.add(temp.toString() + "1");
			comb.add(temp.toString() + "2");
			ar.add(comb.poll() + temp.reverse());
			i++;
		}
		return ar.get(A-1);
    }
	
	

}
