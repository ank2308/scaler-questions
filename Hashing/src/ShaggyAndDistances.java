import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShaggyAndDistances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {};
		ShaggyAndDistances sd = new ShaggyAndDistances();
		System.out.println(sd.solve(A));
	}
	
	public int solve(int[] A) {
		HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
		int minDist = Integer.MAX_VALUE;
		int tempDist;
		for (int i = 0; i < A.length; i++) {
			if(distances.containsKey(A[i])) {
				tempDist = i - distances.get(A[i]);
				if(tempDist < minDist) {
					minDist = tempDist;
				}
				distances.replace(A[i], distances.get(A[i]), i);
			} else {
				distances.put(A[i], i);
			}		
		}
		if(minDist == Integer.MAX_VALUE) {
			return -1;
		}
		return minDist;
    }

}
