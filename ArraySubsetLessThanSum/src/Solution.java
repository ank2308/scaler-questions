import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1, 2, 8};
		Solution s = new Solution();
		System.out.println(s.solve(A, 2));
	}
	
	public int solve(int[] A, int B) {
		int ans = 0;
		List<Integer> curr = new ArrayList<>();
		data name = new data();
		ans = generate(name, 0, 0, B, A,0);
		return ans;
	}
	
	public int generate(data name, int index, int size, int B, int [] A,int level) {
		
		if(index > name.curr.size() || size==B) {
			int sum = 0;
			for (int i = 0; i < name.curr.size(); i++) {
				sum += name.curr.get(i);
			}
			if(sum <= 1000) {
				name.ans = name.ans+1;
				return name.ans++;
			} else {
				return name.ans;
			}
		}                                                                                                                                                   		
		if(level<A.length) {
			generate(name, index, size, B, A, level+1);		
		}
		name.curr.add(A[index]);
		generate(name, index+1, size+1, B, A, level-1);
		name.curr.remove(index);
		return name.ans;
	}
	
	class data {
		public List<Integer> curr = new ArrayList<>();
		int ans=0;
	}

}
