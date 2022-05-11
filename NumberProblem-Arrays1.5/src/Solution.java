import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(0);
		ar.add(9);
		ar.add(0);
		ar.add(9);
		
		ar = s.plusOne(ar);
		System.out.println(ar);
	}
	
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int j=0;
		for (int i = 0; i < A.size(); ) {
			if(A.get(i) == 0) {
				A.remove(i);
			} else {
				j++;
			}
			if(j!=0) {
				break;
			}
		}
		A.trimToSize();
		int i=A.size()-1;
        for(; i > -1 ; i--) {
        	if(A.get(i) != 9 ) {
        		A.set(i, A.get(i) + 1);
        		break;
        	} else {
        		A.set(i, 0);
        	}
        }
        if(i == -1) {
        	A.add(0, 1);
        }
        return A;
    }

}
