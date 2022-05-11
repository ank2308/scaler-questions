
public class NextPointerBinaryTree {
	
	public static TreeLinkNode root = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode A = new TreeLinkNode(1) ;
		A.left = new TreeLinkNode(9);
		A.right = new TreeLinkNode(2);
		A.right.left = new TreeLinkNode(3);
		A.right.right = new TreeLinkNode(7);
		A.left.left = new TreeLinkNode(4);
		A.left.right = new TreeLinkNode(5);
		root = A;
		NextPointerBinaryTree nbt = new NextPointerBinaryTree();
		nbt.connect(root);
	}
	
	public void connect(TreeLinkNode root) {
        while (root!=null) {
        	connectChild(root);
        	root = root.left;
        }
    }

	private TreeLinkNode connectChild(TreeLinkNode A) {
		TreeLinkNode current = A;
		if(current.left != null) {
			while(current!=null) {
				current.left.next = current.right;
				if(current.next != null) {
					current.right.next = current.next.left;
					current = current.next;
				} else {
					current.right.next = null;
					current = null;
				}
			}
		}
		return A;
	}
}
