import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> ans = new ArrayList<>();
	        Arrays.sort(nums);
	        
	        for(int i =0; i<nums.length;i++) {
	            int j = i+1;
	            int k = nums.length-1;
	            while(j<k){
	                int sum = nums[j]+nums[k];
	                if(sum == -nums[i])
	                    ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
	                else if (sum>-nums[i]) k--;
	                else j++;
	            }
	        }
	        return ans;
	    }

}
