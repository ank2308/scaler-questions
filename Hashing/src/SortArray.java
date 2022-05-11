import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {10, 2, 18, 16, 16, 16 };
		int [] B = {3, 13, 2, 16, 4, 19};
		SortArray sa = new SortArray();
		System.out.println(Arrays.toString(sa.solve(A, B)));
	}
	
	public int[] solve(int[] A, int[] B) {
		SortedMap<Integer, Integer> map = new TreeMap<>();
		List<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < A.length; i++) {
			if(map.containsKey(A[i])) {
				map.replace(A[i], map.get(A[i]), map.get(A[i]) + 1);
			} else {
				map.put(A[i], 1);
			}
		}
		for (int i = 0; i < B.length; i++) {
			if(map.containsKey(B[i])) {				
				for (int j = 0; j < map.get(B[i]); j++) {
					ans.add(B[i]);
					
				}
				map.replace(B[i], map.get(B[i]), 0);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() != null) {
				for (int j = 0; j < entry.getValue(); j++) {
					ans.add(entry.getKey());
				}
			}
			
		}
		int [] finalAns = ans.stream().mapToInt(i->i).toArray();
		return finalAns;
	}
}
