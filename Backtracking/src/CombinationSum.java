import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<>();
		A.add(6);
		A.add(2);
		A.add(3);
		
		A.add(7);
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(A, 7).toString());
	}
	
	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		
		Set<Integer> myset = A.stream().collect(Collectors.toSet());
		int [] Arr = myset.stream().mapToInt(i -> i).toArray();
		Arrays.sort(Arr);
		sum(Arr,B,0,0,new ArrayList<Integer>());
		return ans;
	}
	
	
	public void sum(int [] Arr, int B, int index, int sum, ArrayList<Integer> tempAr){
		if(sum == B) {
			ans.add(new ArrayList<Integer>(tempAr));
			return ;
		}
		if(sum > B || index > Arr.length-1) {
			return;
		}
		tempAr.add(Arr[index]);
		sum(Arr,B,index, sum+ Arr[index], tempAr);
		tempAr.remove(tempAr.size()-1);
		sum(Arr,B,index+1, sum, tempAr);
		return;
	}
	
	
}
