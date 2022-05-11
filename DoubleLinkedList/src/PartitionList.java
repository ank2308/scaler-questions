
public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] Ar = {1, 2, 3, 4, 5};
		ListNode A = new ListNode(Ar[0]);
		ListNode top = A;
		for (int i = 1; i < Ar.length; i++) {
			ListNode B = new ListNode(Ar[i]);
			A.next = B;
			A = A.next;
		}
		PartitionList rnl = new PartitionList();
		System.out.println(rnl.partition(top, 1));
	}
	
	public ListNode partition(ListNode A, int B) {
		if(A== null || A.next == null) {
			return A;
		}
		ListNode top = null;
		ListNode temp1 = A;
		ListNode temp2 = null;
		ListNode Less = null;
		ListNode High = null;
		ListNode topHigh = null;
		while (temp1!=null) {
			if(temp1.val < B) {
				temp2 = temp1.next;
				temp1.next = null;
				if(Less == null) {
					Less = temp1;
					top = Less;
				} else {
					Less.next = temp1;
					Less = Less.next;
				}
				temp1 = temp2;
			} else {
				temp2 = temp1.next;
				temp1.next = null;
				if(High == null) {
					High = temp1;
					topHigh = High;
				} else {
					High.next = temp1;
					High = High.next;
				}
				
				temp1 = temp2;
			}
		}
		if(top != null) {
		Less.next = topHigh;
		} else {
			return topHigh;
		}
		return top;
    }

}
