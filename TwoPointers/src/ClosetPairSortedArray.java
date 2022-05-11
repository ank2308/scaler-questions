import java.util.Arrays;

public class ClosetPairSortedArray {
	
	public static void main(String [] args) {
		int [] A = {6, 7, 9, 13, 21, 29, 56, 74, 77, 83, 84, 88, 93, 96, 101, 104, 114, 115, 122, 125, 144, 147, 151, 152, 154, 161, 165, 167, 174, 179, 185, 189, 192, 194, 198, 201, 203, 208, 224, 229, 230, 238, 252, 253, 257, 264, 266, 275, 278, 279, 282, 284, 291, 312, 316, 322, 332, 335, 336, 339, 364, 380, 381, 384, 387, 388, 390, 392, 394, 395, 401, 403, 431, 432, 440, 442, 443, 444, 446, 451, 454, 461, 470, 483, 492};
		int [] B = {2, 8, 13, 16, 19, 21, 22, 23, 37, 48, 63, 66, 68, 71, 72, 95, 102, 116, 123, 127, 131, 132, 146, 148, 153, 171, 173, 179, 187, 194, 215, 220, 227, 229, 240, 245, 254, 255, 257, 259, 271, 276, 277, 286, 296, 312, 314, 318, 321, 333, 339, 341, 343, 355, 356, 359, 363, 364, 380, 390, 393, 398, 401, 409, 413, 417, 427, 442, 444, 446, 454, 455, 459, 460, 468, 471, 473, 475, 476, 478, 479, 482, 483, 488, 489};
		ClosetPairSortedArray csp = new ClosetPairSortedArray();
		System.out.println(Arrays.toString(csp.solve(A, B, 409)));
	}
	
	public int[] solve(int[] A, int[] B, int C) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		int diff = -1;
		int absDiff = 0;
		int finalDiff = Integer.MAX_VALUE;
		for (int i = 0, j=B.length-1; i<A.length && j>=0;) {
			diff = A[i]+B[j];
			absDiff = (Math.abs(diff - C));
			if(absDiff < finalDiff ) {
				x = i;
				y = j;
				finalDiff = absDiff;
			} 
			
			if(absDiff == finalDiff && i<=x && j<=y) {
				x = i;
				y = j;
				finalDiff = absDiff;
			}
			if(diff < C) {				
				i++;				
			} else {
				j--;
			}
			
		}
		int [] ans = {A[x],B[y]};
		return ans;
    }
}
