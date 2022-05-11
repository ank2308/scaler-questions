
public class ReverseLinkListInRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		97 -> 63 -> 89 -> 34 -> 82 -> 95 -> 4 -> 70 -> 14 -> 41 -> 38 -> 83 -> 49 -> 32 -> 68 -> 56 -> 99 -> 52 -> 33 -> 54
		int [] Ar = {97, 63, 89, 34, 82, 95, 4, 70, 14, 41, 38, 83, 49, 32, 68, 56, 99, 52, 33, 54};
		ListNode A = new ListNode(Ar[0]);
		ListNode top = A;
		for (int i = 1; i < Ar.length; i++) {
			ListNode B = new ListNode(Ar[i]);
			A.next = B;
			A = A.next;
		}
		ReverseLinkListInRange rll = new ReverseLinkListInRange();
		rll.reverseBetween(top,13,15);

	}
	public ListNode reverseBetween(ListNode Are, int B, int C) {
		ListNode top = Are;
		ListNode prev = null;
		ListNode prev1 = null;
		ListNode end = null;
		ListNode end1 = null;
		ListNode reverse = null;
		int index = 1;
		while (end1 == null || (Are != null && Are.next != null)) {
			if(index == B) {
				prev1 = Are;
			} else if(prev1 == null) {
				prev = Are;
			}
			if(index == C && prev1 != null) {
				end=Are;
				end1=Are.next;
				end.next = null;
			}			
			Are = Are.next;
			index++;
			if(end != null) {
				reverse = reverseList(prev1);
				if(prev != null) {
					prev.next = reverse;
					prev1.next = end1;					
					return top;
				} else {
					prev1.next = end1;
					prev1 = reverse;
					top = prev1;
					return top;
				}
			} 
		}
		return Are;
    }
	private ListNode reverseList (ListNode A) {
		ListNode prev = null;
		ListNode next = A.next;
		ListNode current = A;		
		while(next!=null ) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
			current.next = prev;				
		}
		
		return current;
	}

}
