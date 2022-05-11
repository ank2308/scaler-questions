
public class MergeTwoList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] ar = {2,4,6,7,9};
		int [] ar2 = {1,3,5,8,10};
		ListNode A = new ListNode(ar[0]);
		ListNode top = A;
		ListNode B = new ListNode(ar2[0]);
		ListNode top2 = B;
		for (int i = 1; i < ar.length; i++) {
			ListNode C = new ListNode(ar[i]);
			A.next = C;
			A = A.next;
			ListNode D = new ListNode(ar2[i]);
			B.next = D;
			B = B.next;
		}
		MergeTwoList rnl = new MergeTwoList();
		rnl.mergeTwoLists(top, top2);
	}
	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		
		ListNode top = null;
		if (A.val <= B.val) {
			top = A;
			A = A.next;
		} else {
			top = B;
			B = B.next;
		}
		ListNode temp = top;
		while(A!=null && B!=null) {
			if(A.val <= B.val) {
				temp.next = A;
				A = A.next;
				temp = temp.next;
			} else {
				temp.next = B;
				B = B.next;
				temp = temp.next;
			}
		}
		while (B != null) {
			temp.next = B;
			B = B.next;
			temp = temp.next;
		} 
		while (A != null) {
			temp.next = A;
			A = A.next;
			temp = temp.next;
		}
		return top;
    }
}
