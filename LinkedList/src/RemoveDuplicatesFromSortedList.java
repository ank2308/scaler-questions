
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A = new ListNode(1);
		ListNode top = A;
//		for (int i = 2; i <=4; i++) {
//			ListNode B = new ListNode(i);
//			A.next = B;
//			A = A.next;
//			ListNode C = new ListNode(i);
//			A.next = C;
//			A = A.next;
//		}
		RemoveDuplicatesFromSortedList rnl = new RemoveDuplicatesFromSortedList();
		rnl.deleteDuplicates(top);
	}
	
	public ListNode deleteDuplicates(ListNode A) {
		ListNode top = A;
		while(A != null && A.next != null) {
			while(A.next!=null && A.val == A.next.val) {
				A.next = A.next.next;
			}
			A = A.next;
		}
		return top;
    }
}
