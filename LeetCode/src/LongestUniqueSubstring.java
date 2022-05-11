import java.util.HashSet;

public class LongestUniqueSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "pwwkew";
		LongestUniqueSubstring longestUniqueSubstring = new LongestUniqueSubstring();
		System.out.println(longestUniqueSubstring.lengthOfLongestSubstring(s));
	}
	
	public int lengthOfLongestSubstring(String s) {
		char [] ar = s.toCharArray();
        int max = 0;
        int n = ar.length;
        int i=0,j=0;
        HashSet<Character> slidingWindow = new HashSet<>();
        for (; j< n; j++) {
			if(slidingWindow.contains(ar[j])) {
				while(slidingWindow.contains(ar[j])) {
					slidingWindow.remove(ar[i]);
					i++;
				}
				slidingWindow.add(ar[j]);
			} else {
				slidingWindow.add(ar[j]);
				max = Math.max(max, j-i+1);
			}
		}
        return max;
    }

}
