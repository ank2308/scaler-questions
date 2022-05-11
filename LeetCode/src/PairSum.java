import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2, -3, 3, 3, -2};
		System.out.println(pairSum(A, 0));
		List <Integer> in = new ArrayList<Integer>();
		Collections.unmodifiableCollection(in);
	}
	
	public static int[][] pairSum(int[] arr, int s) {
		Map<Integer, Integer> nums = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(nums.containsKey(arr[i])) {
				int temp = nums.get(arr[i]);
				temp++;
				nums.replace(arr[i], temp);
			} else {
				nums.put(arr[i], 1);
			}
		}
		Arrays.sort(arr);
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < arr.length;) {
			int val = arr[i];
			int temp = s-val;
			if(nums.containsKey(temp) && nums.get(val)>0 && nums.get(temp)>0) {
				
				ans.add(val);
				int temp1 = nums.get(temp);
				temp1--;
				if(temp1 == 0) {
					i++;
				}
				nums.replace(temp, temp1);
				
			} else {
				i++;
			}
			
		}
			
	
		Collections.sort(ans);
		int [][] finalAns = new int [ans.size()][2];
		int i = 0;
		for(Integer val : ans){
			finalAns[i][0] = val;
			finalAns[i][1] = s-val;
			i++;
		}
		return finalAns;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[][] pairSum1(int[] arr, int s) {
        // Write your code here.
		ArrayList<Integer> numsLessThanS = new ArrayList<>();
		Map<Integer, Integer> numsGreaterThanS = new HashMap<>();
		int flip = 0;
		for (int i = 0;i < arr.length;i++){
			if(s%2 == 0) {
				if(arr[i] < s/2){
					numsLessThanS.add(arr[i]);
				} else if (arr[i] > s/2){
					if(numsGreaterThanS.containsKey(arr[i])) {
						int temp = numsGreaterThanS.get(arr[i]);
						temp++;
						numsGreaterThanS.replace(arr[i], temp);
					} else {
						numsGreaterThanS.put(arr[i], 1);
					}
				} else {
					if(s/2 == arr[i] && flip == 0){
						numsLessThanS.add(arr[i]);
						flip = 1;
					} else {
						if(numsGreaterThanS.containsKey(arr[i])) {
							int temp = numsGreaterThanS.get(arr[i]);
							temp++;
							numsGreaterThanS.replace(arr[i], temp);
						} else {
							numsGreaterThanS.put(arr[i], 1);
						}
						flip = 0;
					}
				}
			} else {
				if(arr[i] <= s/2){
					numsLessThanS.add(arr[i]);
				} else if (arr[i] > s/2){
					if(numsGreaterThanS.containsKey(arr[i])) {
						int temp = numsGreaterThanS.get(arr[i]);
						temp++;
						numsGreaterThanS.replace(arr[i], temp);
					} else {
						numsGreaterThanS.put(arr[i], 1);
					}
				} 
			}			
		}
		Collections.sort(numsLessThanS);
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < numsLessThanS.size(); ) {
			int temp = s - numsLessThanS.get(i);
			if(numsGreaterThanS.containsKey(temp) && numsGreaterThanS.get(temp) > 0){
				ans.add(numsLessThanS.get(i));
				int temp1 = numsGreaterThanS.get(temp);
				temp1--;
				numsGreaterThanS.replace(temp, temp1);
			} else {
				i++;
			}
		}
		int [][] finalAns = new int [ans.size()][2];
		int i = 0;
		for(Integer val : ans){
			finalAns[i][0] = val;
			finalAns[i][1] = s-val;
			i++;
		}
		return finalAns;
    }

}
