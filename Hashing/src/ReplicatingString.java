
public class ReplicatingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplicatingString rs = new ReplicatingString();
		
		System.out.println(rs.solve(1, "mlosqnouzokpcabwqgeribqurraqdqhqdyiunwonmaerchnuntlwxdsowsgajosooakbzaqlavcecrysnlqkpkancgnnwfckimoh"));
	}

	public int solve(int A, String B) {
		char [] ch = B.toCharArray();
		if(ch.length % A != 0) {
			return -1;
		}
		int [] freq = new int [26];
		for (int i = 0; i < ch.length; i++) {
			freq[ch[i] - 'a']++;
		}
		
		for (int i = 0; i < freq.length; i++) {
			if(freq[i]%A != 0) {
				return -1;
			}			
		}
		return 1;
    }
}
