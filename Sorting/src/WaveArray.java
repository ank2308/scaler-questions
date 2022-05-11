import java.util.Arrays;

public class WaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaveArray wa = new WaveArray();
		int [] A = {6};
		System.out.println(Arrays.toString(wa.wave(A)));
	}
	
	public int[] wave(int[] nums) {
		Arrays.sort(nums);
        int n = nums.length;
        if(n > 1)
         for(int i = 0; i < n; i += 2){
           if(i == 0){
               if(nums[i] <= nums[i+1])
                swap(nums, i, i+1);
           }
           else if(i == n-1){
               if(nums[i] <= nums[i-1])
                swap(nums, i, i-1);
           }
           else{
               //for general case check which one is greater out of (i-1, i, i+1), and swap it with i
               if(nums[i] >= nums[i-1] && nums[i] >= nums[i+1])
                continue;
                else if(nums[i-1] > nums[i+1])
                    swap(nums, i, i-1);
                else
                    swap(nums, i, i+1);
           }
         }
         return nums;
    }
	
	
	public void swap(int []A,int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
