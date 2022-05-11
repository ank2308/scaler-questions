import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = {{1,7,9,7,2} , {2,5,6,5,2}};
		
		MEX obj = new MEX();
		System.out.println(obj.solve(2, 5, A));
	}
	
	private int solve(int N, int M, int[][]Ar) {
		List<Integer> tempNum = null;
		Map<Integer, Integer> presentNum = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			tempNum = new ArrayList<>();
			for(int j=0;j<M;j++) {
				
				if(!tempNum.contains(Ar[i][j])) {
					tempNum.add(Ar[i][j]);
					if(presentNum.containsKey(Ar[i][j])) {
						int temp = presentNum.get(Ar[i][j]);
						temp++;
						presentNum.replace(Ar[i][j], temp);
					} else {asd
						presentNum.put(Ar[i][j], 1);
					}
				} 
			}
		}
		int sum = 0;
		for(Map.Entry<Integer, Integer> entry:presentNum.entrySet()) {
			sum = sum + (N - entry.getValue());
		}
		return sum;
	}

}
