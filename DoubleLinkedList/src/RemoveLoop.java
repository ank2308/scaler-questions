
public class RemoveLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A = new ListNode(1);
		ListNode top = A;
		ListNode loop = null;
		for (int i = 2; i <=5; i++) {
			ListNode B = new ListNode(i);
			if(i==3) {
				loop = B;
			}
			A.next = B;
			A = A.next;
		}
		A.next = loop; 
		RemoveLoop rn = new RemoveLoop();
		System.out.println(rn.solve(top));
	}
	
	public ListNode solve(ListNode A) {
		if(A==null || A.next == null ) {
			return A;
		}
		ListNode top = A;
		ListNode slow = A;
		ListNode fast = A;
		ListNode prev = null;
		while (1>0) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {				
				break;
			}
		}
		slow = A;
		if (slow == fast) {
			prev = fast;
			fast = fast.next;
			while (slow!=fast) {
				prev = fast;
				fast = fast.next;
			}
		} else {
			while (slow != fast) {
				prev = fast;
				slow = slow.next;
				fast = fast.next;
			}
		}
		prev.next = null;
		return top;
    }

}
