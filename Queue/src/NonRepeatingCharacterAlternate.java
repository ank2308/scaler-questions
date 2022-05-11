import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NonRepeatingCharacterAlternate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "gu";
		NonRepeatingCharacterAlternate npc = new NonRepeatingCharacterAlternate();
		System.out.println(npc.solve(A));
	}
	
	public String solve(String A) {
		char [] ar = A.toCharArray();
		Queue<Character> uniqueString = new LinkedList<>();
		Map<Character, Integer> un = new HashMap<Character, Integer>();
		uniqueString.add(ar[0]);
		un.put(ar[0], 1);
		StringBuilder ans = new StringBuilder();
		ans.append(uniqueString.peek());
		int freq = 0;
		for (int i = 1; i < ar.length; i++) {
			if(!uniqueString.isEmpty() && ar[i] == uniqueString.peek()) {
				freq = un.get(ar[i]);
				un.replace(ar[i], ++freq);
				uniqueString.poll();	
				while(!uniqueString.isEmpty() && un.get(uniqueString.peek()) > 1) {
					uniqueString.poll();
				}
			} else {				
				if(un.containsKey(ar[i])) {
					freq = un.get(ar[i]);
					un.replace(ar[i], ++freq);
					
				} else {
					uniqueString.add(ar[i]);
					un.put(ar[i], 1);
				}
			}
			if(uniqueString.isEmpty()) {
				ans.append("#");
			} else {
				ans.append(uniqueString.peek());
			}
			
		}
		return ans.toString();
	}
}
