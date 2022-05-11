
public class PlaindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] Ar = {1};
		ListNode A = new ListNode(Ar[0]);
		ListNode top = A;
		for (int i = 1; i < Ar.length; i++) {
			ListNode B = new ListNode(Ar[i]);
			A.next = B;
			A = A.next;
		}
		PlaindromeString rnl = new PlaindromeString();
		System.out.println(rnl.lPalin(top));
	}
	
	public int lPalin(ListNode A) {
		if(A.next == null || A == null) {
			return 1;
		}
		ListNode slow = A;
		ListNode fastptr = A;
		ListNode prev = null;
		ListNode top = A;
		ListNode second = null;
		while(fastptr != null && fastptr.next != null) {
			fastptr = fastptr.next.next;
			prev = slow;
			slow = slow.next;			
		}
		if (fastptr != null) {
			prev.next = null;
			second = slow.next;
			second = reverseList(second);
			while (second != null) {
				if(second.val != top.val) {
					return 0;
				}
				second = second.next;
				top = top.next;
			}
			return 1;
		} else {
			prev.next = null;
			second = slow;
			second = reverseList(second);
			while (second != null) {
				if(second.val != top.val) {
					return 0;
				}
				second = second.next;
				top = top.next;
			}
			return 1;
		}
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
