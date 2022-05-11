
public class ReOrderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A = new ListNode(1);
		ListNode top = A;
		for (int i = 2; i <2; i++) {
			ListNode B = new ListNode(i);
			A.next = B;
			A = A.next;
		}
		ReOrderList rnl = new ReOrderList();
		rnl.reorderList(top);
	}
	
	public ListNode reorderList(ListNode A) {
		if(A.next != null) {		
			ListNode slow = A;
			ListNode fastptr = A;	
			ListNode second = null;
			ListNode prev = null;
			while(fastptr != null && fastptr.next != null) {
				fastptr = fastptr.next.next;
				prev = slow;
				slow = slow.next;
				
			}
			if (fastptr != null) {
				second = slow.next;
				slow.next = null;
			} else {
				second = slow;
				prev.next= null;
			}
			ListNode top = A;
			ListNode temp;
			second = reverseList(second);		
			while (second != null) {
				temp = second;
				second = second.next;
				temp.next = A.next;
				A.next = temp;
				A=A.next.next;
			}
			return top;
		}
		return A;
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
