import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(5090);
		A.left = new TreeNode(9569);
		A.right = new TreeNode(3628);
		
		
		VerticalOrderTraversal orderTraversal = new VerticalOrderTraversal();
		ArrayList<ArrayList<Integer>> ansReturn = orderTraversal.verticalOrderTraversal(A);
		System.out.println("abc");
	}
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		int min=0, max=0;
		int [] minMax = {0, 0};
		minMax = findMinMax(A, min, max, minMax);
		HashMap<Integer, ArrayList<Integer>> ans = new HashMap<>();
		ArrayList<ArrayList<Integer>> ansReturn = new ArrayList<>();
		ans = verticalTraversal(A, minMax[0], ans, 0);
		Iterator<Integer> iterator = ans.keySet().iterator();
	    while (iterator.hasNext()) {
	        Integer key = iterator.next();
	        ansReturn.add(ans.get(key));
	    }
	    return ansReturn;
    }
	
	private int[] findMinMax (TreeNode A,int min,int max, int [] minMax) {
		if(A==null) {			
			return minMax;
		}
		minMax[0] = Math.min(minMax[0], min);
		minMax[1] = Math.max(max, minMax[1]);
		minMax = findMinMax(A.left,min-1,max,minMax);
		minMax = findMinMax(A.right, min, max+1, minMax);
		return minMax;
	}
	
	public HashMap<Integer, ArrayList<Integer>> verticalTraversal(TreeNode A, int min,HashMap<Integer, ArrayList<Integer>> hashMap, int dist) {
		
		Queue<HashMap<Integer, TreeNode>> listTree = new LinkedList<>();
		Stack<TreeNode> root = new Stack<>();
		HashMap<Integer, TreeNode> tempNodeWithDistance = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			tempNodeWithDistance.get
		}
		tempNodeWithDistance.put(dist-min, A);
		listTree.add(tempNodeWithDistance);
		while(true) {
			if(listTree.isEmpty()) {
				break;
			}
			int nodeCount = listTree.size();
			while (nodeCount > 0) {
				HashMap<Integer, TreeNode> nodeWithDistance = listTree.peek();
				Map.Entry<Integer, TreeNode> entry = nodeWithDistance.entrySet().iterator().next();
				Integer key = entry.getKey();
				TreeNode node = entry.getValue();	
				listTree.poll();
				if(hashMap.containsKey(key)) {
					ArrayList<Integer> tempNode = hashMap.get(key);
					tempNode.add(node.val);
					hashMap.replace(key, tempNode);
				} else {
					ArrayList<Integer> arList = new ArrayList<>();
					arList.add(node.val);
					hashMap.put(key, arList);
				}
				if(node.left!=null) {
					HashMap<Integer, TreeNode> tempNodeDistance = new HashMap<>();
					tempNodeDistance.put((key-1), node.left);
					listTree.add(tempNodeDistance);
				}
				if(node.right!=null) {
					HashMap<Integer, TreeNode> tempNodeDistance = new HashMap<>();
					tempNodeDistance.put((key+1), node.right);
					listTree.add(tempNodeDistance);
				}
				nodeCount--;
			}
		}
		return hashMap;
    }
}
