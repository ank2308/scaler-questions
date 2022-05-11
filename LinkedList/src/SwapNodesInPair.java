
public class SwapNodesInPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A = new ListNode(1);
		ListNode top = A;
		for (int i = 2; i <=6; i++) {
			ListNode B = new ListNode(i);
			A.next = B;
			A = A.next;
		}
		SwapNodesInPair rnl = new SwapNodesInPair();
		rnl.swapPairs(top);
	}
	
	public ListNode swapPairs(ListNode A) {
		if(A.next != null) {
			ListNode top = A.next;
			ListNode temp1 = A;
			ListNode temp2 = A.next;
			ListNode prev = null;
			
			while (temp1.next != null && temp2 != null) {
				temp1.next = temp2.next;
				temp2.next = temp1;
				if(prev != null) {
					prev.next = temp2;
				}
				prev = temp1;
				if(temp1.next == null) {
					break;
				}
				temp2 = temp1.next.next;
				temp1 = temp1.next;
				
			}
			return top;
			
		}
		return A;
    }
}
