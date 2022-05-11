
public class AddNumberAsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ar = {9,9};
		int [] ar2 = {1};
		ListNode A = new ListNode(ar[0]);
		ListNode top = A;
		ListNode B = new ListNode(ar2[0]);
		ListNode top2 = B;
		for (int i = 1; i < ar.length; i++) {
			ListNode C = new ListNode(ar[i]);
			A.next = C;
			A = A.next;
			
		}
		for (int i = 0; i < ar2.length; i++) {
			ListNode D = new ListNode(ar2[i]);
			B.next = D;
			B = B.next;
		}
		AddNumberAsList rnl = new AddNumberAsList();
		System.out.println(rnl.addTwoNumbers(top, top2));
	}
	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		String first = "";
		String second = "";
		while (A!=null) {
			first = A.val + first;
			A = A.next;
		}
		while (B!=null) {
			second = B.val + second;
			B = B.next;
		}
		int sum = Integer.parseInt(first) + Integer.parseInt(second);
		ListNode top = null;
		ListNode anstop = null;
		while (sum>0) {
			int temp = sum % 10;
			sum = sum / 10;
			ListNode ele = new ListNode(temp);
			if(top == null) {
				top = ele;	
				anstop = top;
			} else {
				top.next = ele;
				top = top.next;
			}
		}
		return anstop;
    }
}
