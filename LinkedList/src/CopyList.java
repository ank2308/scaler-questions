
public class CopyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode A = new RandomListNode(1);
		RandomListNode top = A;
		int [] ar = {2,4,1,3,0};
		for (int i = 1; i <5; i++) {
			RandomListNode B = new RandomListNode(i+1);
			A.next = B;
			A = A.next;
		}
		RandomListNode temp2 = top;
		for (int i = 0; i < ar.length; i++) {
			int index = 0;
			RandomListNode temp = top;
			
			while (index < ar[i]) {
				temp = temp.next;
				index++;
			}
			temp2.random = temp;
			temp2 = temp2.next;
			
		}
		CopyList rnl = new CopyList();
		rnl.copyRandomList(top);
	}
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode top = head;
		while (head!= null) {
			RandomListNode newNode = new RandomListNode(head.label);
			newNode.next = head.next;
			head.next = newNode;
			head = head.next.next;
		}
		head = top;
		RandomListNode copyHead = head.next;
		RandomListNode secondHead = copyHead;
		while (copyHead.next!= null) {
			copyHead.random = head.random.next;
			head = head.next.next;
			copyHead = copyHead.next.next;
		}
		copyHead.random = head.random.next;
		copyHead = secondHead;
		while (copyHead.next != null) {
			copyHead.next = copyHead.next.next;
			copyHead = copyHead.next;
		}
		return secondHead;
    }
}	
