import java.util.PriorityQueue;

public class MishaAndCandies {
	
	public static void main(String[] args) {
		int [] A = {9, 818, 174, 237, 892, 109, 522, 27, 59, 336, 605, 865, 714, 86, 708, 535, 138, 948, 836, 287, 179, 754, 466, 856, 153, 53, 958, 951, 262, 341, 769, 491, 772, 509, 336, 120, 98, 805, 169, 984, 520, 447, 256, 266, 348, 351, 60, 563, 45, 638, 29, 479, 400};
		MishaAndCandies candies = new MishaAndCandies();
		System.out.println(candies.solve(A, 852));
	}
	
	public int solve(int[] A, int B) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < A.length; i++) {
			minHeap.add(A[i]);
		}
		int sum = 0;
		while (true) {
			int temp = minHeap.poll();
			if(temp>B) {
				break;
			}
			int toAdd = temp/2;
			sum = sum + toAdd;
			if(minHeap.isEmpty()) { 
				break;
			}
			int secondSmallest = minHeap.poll();
			secondSmallest = secondSmallest + (temp-toAdd);
			minHeap.add(secondSmallest);
		}
		return sum;
    }
}
