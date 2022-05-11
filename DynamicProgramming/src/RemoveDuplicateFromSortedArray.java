import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,1,2,2,3,3,3,4,4,5};
		RemoveDuplicateFromSortedArray array = new RemoveDuplicateFromSortedArray();
		System.out.println(array.removeDuplicates(A));
		System.out.println(Arrays.asList(A));
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums.length == 1){
            return 1;
        }
		int len=0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[len]) {
				nums[i] = 101;
			} else if (nums[len+1] == 101) {
				nums[len+1] = nums[i];
				nums[i]=101;
				len++;
			} else {
				len++;
			}
		}
        
		return len+1;
    }
}
