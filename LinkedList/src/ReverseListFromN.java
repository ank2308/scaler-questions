
public class ReverseListFromN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A = new ListNode(1);
		ListNode top = A;
		for (int i = 2; i <= 6; i++) {
			ListNode B = new ListNode(i);
			A.next = B;
			A = A.next;
		}
		ReverseListFromN rn = new ReverseListFromN();
		System.out.println(rn.reverseList(top, 3));
	}
	public ListNode reverseList(ListNode A, int B) {
		ListNode prev = null;
		ListNode next = A.next;
		ListNode current = A;
		ListNode last = A;
		ListNode tempLast = null;
		ListNode top = A;
		int index = 1, it= 1;
		boolean flag = true; 
		if(B!=1) {
			while(current.next!=null ) {			
				while(index%B!=0 || (B==1 &&current.next!=null)) {
					index++;
					current.next = prev;
					prev = current;
					current = next;
					next = next.next;				
				}	
				if(current.next == null) {
					flag = false	;
				}
				current.next = prev;
				if(it == 1) {
					top = current;
				}
				if(it >=2) {
					last.next = current;
					last = tempLast;
				}
				if(next != null && flag) {
				index=1;
				prev = null;
				current = next;
				next = next.next;
				tempLast = current;
				it++;
				} else {
					break;
				}
				
			}
		}
		return top;
    }

}
