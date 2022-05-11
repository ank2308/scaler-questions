import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFreqElementWithMaxFreq {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [][] A = {{1,46},{2,0},{1,11},{1,38},{2,0},{1,71},{2,0},{2,0},{1,45},{2,0},{1,27},{1,23},{2,0},{1,69},{2,0},{2,0},{1,76},{1,64},{2,0},{2,0},{1,13},{1,13},{1,93},{1,90},{2,0},{2,0},{2,0},{1,4},{1,63},{2,0},{1,9},{2,0},{1,26},{1,29},{2,0},{2,0},{1,26},{2,0},{1,91},{1,52},{1,89},{1,8},{1,95},{2,0},{2,0},{2,0},{2,0},{2,0},{2,0},{1,38},{2,0},{2,0},{1,65}};
		int [][] A = {{1,9},{2,0},{1,8},{2,0},{1,9},{2,0},{1,2},{1,3}};
		MaxFreqElementWithMaxFreq mf = new MaxFreqElementWithMaxFreq();
		System.out.println(Arrays.toString(mf.solve(A)));
	}
	
	public int[] solve(int[][] A) {
		Map<Integer, Stack<Integer>> maxElementAtFreq = new HashMap<Integer, Stack<Integer>>();
		Map<Integer, Integer> freqMap = new HashMap<>();
		freqMap.put(A[0][1], 1);
		Stack<Integer> tempStack = new Stack<>();
		tempStack.push(A[0][1]);
		maxElementAtFreq.put(1, tempStack);
		int maxFrequency=1;
		int [] ans = new int [A.length];
		ans[0] = -1;
		int index = 1;
		for (int i = 1; i < A.length; i++) {
			int tempOpt = A[i][0];
			int tempElement = A[i][1];
			if( tempOpt == 1) {
				if(freqMap.containsKey(tempElement)) {
					int tempFrequency = freqMap.get(tempElement);
					tempFrequency++;
					freqMap.replace(tempElement, tempFrequency);
					if (!maxElementAtFreq.containsKey(tempFrequency)) {
						Stack<Integer> tempStack1 = new Stack<>();
						tempStack1.push(tempElement);
						maxElementAtFreq.put(tempFrequency, tempStack1);
						if(tempFrequency > maxFrequency)
						maxFrequency = tempFrequency;
						ans[index++] = -1;
						
					} else {
						Stack<Integer> tempStack1 = maxElementAtFreq.get(tempFrequency);
						tempStack1.push(tempElement);
						maxElementAtFreq.replace(tempFrequency, tempStack1);
						ans[index++] = -1;
						if(tempFrequency > maxFrequency)
							maxFrequency = tempFrequency;
					}
				} else {
					freqMap.put(tempElement, 1);
					if (!maxElementAtFreq.containsKey(1)) {
						Stack<Integer> tempStack1 = new Stack<>();
						tempStack1.push(tempElement);
						maxElementAtFreq.put(1, tempStack1);
						if(1 > maxFrequency)
						maxFrequency = 1;
						ans[index++] = -1;
						
					} else {
						Stack<Integer> tempStack1 = maxElementAtFreq.get(1);
						tempStack1.push(tempElement);
						maxElementAtFreq.replace(1, tempStack1);
						if(1 > maxFrequency)
						maxFrequency = 1;
						ans[index++] = -1;
					}
				}
			} else {
				Stack<Integer> tS = maxElementAtFreq.get(maxFrequency);
				int peakElement = tS.pop();
				ans[index++] = peakElement;
				maxElementAtFreq.replace(maxFrequency, tS);
				int tempFreq = freqMap.get(peakElement);
				freqMap.replace(peakElement, --tempFreq);
				if(tS.isEmpty()) {
					maxFrequency--;
				}
			}
		}
		return ans;
	}

}
