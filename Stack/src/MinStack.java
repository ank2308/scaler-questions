
public class MinStack {
//	19 P 10 P 9 g P 8 g P 7 g P 6 g p g p g p g p g p g

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack st = new MinStack();
		st.push(10);
		st.push(9);
		System.out.println(st.getMin());
		st.push(8);
		System.out.println(st.getMin());
		st.push(7);
		System.out.println(st.getMin());
		st.push(6);
		System.out.println(st.getMin());
		st.pop();
		System.out.println(st.getMin());
		st.pop();
		System.out.println(st.getMin());
		st.pop();
		System.out.println(st.getMin());
		st.pop();
		System.out.println(st.getMin());
		st.pop();
		System.out.println(st.getMin());
	}
	
	private class Node {
		int data;
		Node link;
	}
	
	Node top;
	Node minStack;
	
	public MinStack() {
		this.top = null;
	}
	
	public void push(int x) {
		Node temp = new Node();		
		temp.data = x;
		temp.link = top;
		top = temp;
		if(minStack == null) {
			Node min = new Node();		
			min.data = x;
			min.link = minStack;
			minStack = min;
		} else {
			if(x <= minStack.data) {
				Node min = new Node();		
				min.data = x;
				min.link = minStack;
				minStack = min;
			}
		}
    }

    public void pop() {
    	if(top == null) {
    		return ;
    	}
    	if(minStack.data == top.data) {
    		minStack = minStack.link;
    	}
    	top = top.link;
    	
    }

    public int top() {
    	if(top == null) {
    		return -1;
    	}
    	return top.data;
    }

    public int getMin() {
    	if(minStack == null) {
    		return -1;
    	}
    	return minStack.data;
    }

}
