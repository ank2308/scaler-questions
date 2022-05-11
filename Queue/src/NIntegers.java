import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NIntegers integers = new NIntegers();
		System.out.println(Arrays.toString(integers.solve(7)));
	}
	public int[] solve(int A) {
		Queue<String> nInteger = new LinkedList<String>();
		nInteger.add("1");
		nInteger.add("2");
		nInteger.add("3");
		String temp;
		int [] ans = new int[A];
		
		for (int i = 0; i < A; i++) {
			temp = nInteger.poll();
			ans[i] = Integer.parseInt(temp);
			nInteger.add(temp + "1");
			nInteger.add(temp + "2");
			nInteger.add(temp + "3");
		}
		return ans;
    }
}
