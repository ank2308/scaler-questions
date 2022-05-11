import java.util.HashMap;

public class FactorialArray {
	
	public static void main(String[] args) {
		FactorialArray factorialArray = new FactorialArray();
		int [] A = {2,3,5};
		System.out.println(factorialArray.solve(A));
	}
	
	public int solve(int[] A) {
		int mod = (int) (Math.pow(10, 9) + 7);
		long [] factorialArray = new long[A.length];
		HashMap<Integer, Long> factorialMap = new HashMap<>(); 
		for (int i = 0; i < factorialArray.length; i++) {
			factorialArray[i] = findFactorial(A[i], factorialMap);
		}
		return 1;
    }
	
	private long findFactorial (int n, HashMap<Integer, Long> factorialArray) {
		if (n==1) {
			return 1;
		}
		if (factorialArray.containsKey(n)) {
			return factorialArray.get(n);
		} else {
			long factorial = n*findFactorial(n-1, factorialArray);
			factorialArray.put(n, factorial);
			return factorial;
		}
	}

}
