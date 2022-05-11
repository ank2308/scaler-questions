import java.util.Arrays;
import java.util.HashMap;

// Problem 1 Leetcode
public class TwoSum {
	
	public static void main (String [] args) {
		int [] A = {2,7,11,15};
		TwoSum sum = new TwoSum();
		System.out.println(Arrays.asList(sum.twoSum(A, 9)));
	}
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> numWithIndices = new HashMap<>();
		int [] ans = new int [2];
        for (int i = 0; i < nums.length; i++) {
        	int temp = target - nums[i];
			if(numWithIndices.containsKey(nums[i])) {
				ans[1] = i;
				ans[0] = numWithIndices.get(nums[i]);
			} else {
				numWithIndices.put(temp, i);
			}
		}
        return ans;
    }
}
