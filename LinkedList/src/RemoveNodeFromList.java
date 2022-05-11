
public class RemoveNodeFromList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A = new ListNode(1);
		ListNode top = A;
		for (int i = 2; i <= 5; i++) {
			ListNode B = new ListNode(i);
			A.next = B;
			A = A.next;
		}
		RemoveNodeFromList rnl = new RemoveNodeFromList();
		rnl.removeNthFromEnd(top, 7);
	}
	public ListNode removeNthFromEnd(ListNode A, int B) {
		ListNode st = A;
		ListNode second = A;
		for (int i = 0; i < B; i++) {
			 
            // If count of nodes in the given
            // linked list is <= N
            if (second.next == null) {
 
                A = A.next;
                return A;
            }
            second = second.next;
        }
		while(second.next != null) {
			A = A.next;
			second = second.next;
		}
		A.next = A.next.next;
		return st;		
    }
}
