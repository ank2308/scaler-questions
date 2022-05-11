
public class RobHouse {
	public int rob(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		} 
		if(nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int [] dp = new int [nums.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		
		dp[0] = nums[0];
        return findMaxMoney(nums, nums.length-1, 0, dp);
    }
    private int findMaxMoney(int [] nums, int index, int money, int []dp){
        if (index<0){
            return money;
        }
        if(dp[index] != -1) {
        	return dp[index]+money;
        }
        return dp[index] = Math.max(findMaxMoney(nums, index-1, money, dp), findMaxMoney(nums, index-2, money+nums[index], dp));
    }
    
    public static void main(String [] args) {
    	RobHouse house = new RobHouse();
    	int [] nums = {2,1,1,2};
    	System.out.println(house.rob(nums));
    }
}
