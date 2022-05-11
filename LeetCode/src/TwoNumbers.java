import java.util.Iterator;

public class TwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode A = new ListNode(9);
		ListNode root1 = A;
		A.next = new ListNode(9);
		A.next.next = new ListNode(1);
		
		ListNode B = new ListNode(1);
		ListNode root2 = B;
//		B.next = new ListNode(2);
//		B.next.next = new ListNode(1);
		TwoNumbers numbers = new TwoNumbers();
		numbers.addTwoNumbers(root1, root2);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode ans = null;
       ListNode root = null;
       int carry = 0;
       while(l1 != null && l2 != null) {
    	   int temp = l1.val+l2.val+carry;
    	   carry=0;
    	   if (temp>9) {    		   
    		   if(ans == null) {    			  
    			   ans = new ListNode(temp%10);
    			   root = ans;
    		   } else {
    			   ans.next = new ListNode(temp%10);
    			   ans = ans.next;
    		   }
    		   carry=1;
    	   } else {
    		   
    		   if(ans == null) {
    			   ans = new ListNode(temp);
    			   root = ans;
    		   } else {
    			   ans.next = new ListNode(temp);
    			   ans = ans.next;
    		   }
    	   }
    	   
    	   l1 = l1.next;
    	   l2 = l2.next;
       }
       while(l1 != null) {
    	   int temp = l1.val + carry;
    	   carry = 0;
    	   if(temp > 9) {
    		   if(ans == null) {    			   
    			   ans = new ListNode(temp%10);
    			   root = ans;
    		   } else {
    			   ans.next = new ListNode(temp%10);
    			   ans = ans.next;
    		   }
    		   carry = 1;
    	   } else {
    		   if(ans == null) {
    			   
    			   ans = new ListNode(temp%10);
    			   root = ans;
    		   } else {
    			   ans.next = new ListNode(temp%10);
    			   ans = ans.next;
    		   }
    	   }
    	   l1 = l1.next;
       }
       while(l2 != null) {
    	   int temp = l2.val + carry;
    	   carry = 0;
    	   if(temp > 9) {
    		   if(ans == null) {
    			   
    			   ans = new ListNode(temp%10);
    			   root = ans;
    		   } else {
    			   ans.next = new ListNode(temp%10);
    			   ans = ans.next;
    		   }
    		   carry = 1;
    	   } else {
    		   if(ans == null) {
    			   
    			   ans = new ListNode(temp%10);
    			   root = ans;
    		   } else {
    			   ans.next = new ListNode(temp%10);
    			   ans = ans.next;
    		   }
    	   }
    	   l2 = l2.next;
       }
       if(carry == 1) {
    	   ans.next = new ListNode(carry);
    	   
       }
       return root;
    }
}
