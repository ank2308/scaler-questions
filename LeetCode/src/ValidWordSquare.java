import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidWordSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ar = new ArrayList<>();
		ar.add("ball");
		ar.add("area");
		ar.add("read");
		ar.add("lady");
		ValidWordSquare validWordSquare = new ValidWordSquare();
		boolean flag = validWordSquare.validWordSquare(ar);
		System.out.println(flag);
	}
	
	public boolean validWordSquare(List<String> words) {
		StringBuilder s = new StringBuilder(words.get(0));
		int n = s.length();
		char [][] characterAr = new char[n][n];
		int index = 0;
        for (String word : words) {			
			char [] wordAr = word.toCharArray();
			if(wordAr.length > n) {
				return false;
			}
			for (int i = 0; i < wordAr.length; i++) {
				characterAr[index][i] = wordAr[i];
			}
			index++;
		}
        int [][] dp = new int[n][n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(dp[i][j] == 0) {
        			if(characterAr[i][j] != characterAr[j][i]) {
        				return false;
        			} else {
        				dp[i][j] = 1;
        				dp[j][i] = 1;
        			}
        		}
        	}
        }
        return true;
    }

}
