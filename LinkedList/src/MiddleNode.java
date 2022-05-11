
public class MiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A = new ListNode(1);
		ListNode top = A;
		for (int i = 2; i <=2; i++) {
			ListNode B = new ListNode(i);
			A.next = B;
			A = A.next;
		}
		MiddleNode rnl = new MiddleNode();
		System.out.println(rnl.solve(top));
	}
	
	public int solve(ListNode A) {
		ListNode slow = A;
		ListNode fastptr = A;
		while(fastptr != null && fastptr.next != null) {
			fastptr = fastptr.next.next;
			slow = slow.next;			
		}
		if (fastptr != null) {
			return slow.val;
		} else {
			return slow.val;
		}
    }

}
