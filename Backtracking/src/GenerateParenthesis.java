import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis gp = new GenerateParenthesis();
		System.out.println(gp.generateParenthesis(3));
	}
    ArrayList<String> str = new ArrayList<>();
	
	public ArrayList<String> generateParenthesis(int A) {
		gp("",0,A*2,0,'t');
		return str;
    }
	
	public String gp (String S, int index, int A, int sOpen, char c) {
		if(S.length() == A) {
			str.add(S);
			return "";
		}
		if(sOpen < 0 && c==')') {
			return "";
		}
		if(index != A/2) {
			return gp(S+'(',index+1,A, sOpen+1,'(') + gp(S+')',index,A,sOpen-1,')');
		} else {
			return gp(S+')',index,A,sOpen-1,')');
		}
	}

}
