import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyboardRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] A = {"Hello","Alaska","Dad","Peace"};
		KeyboardRow keyboardRow = new KeyboardRow();
		keyboardRow.findWords(A);
	}
	
	public String[] findWords(String[] words) {
		List<String> ans = new ArrayList<>();
		List<Character> row1 = new ArrayList<>();
		row1.add('q');
		row1.add('w');
		row1.add('e');
		row1.add('r');
		row1.add('t');
		row1.add('y');
		row1.add('u');
		row1.add('i');
		row1.add('o');
		row1.add('p');
		List<Character> row2 = new ArrayList<>();
		row2.add('a');
		row2.add('s');
		row2.add('d');
		row2.add('f');
		row2.add('g');
		row2.add('h');
		row2.add('j');
		row2.add('k');
		row2.add('l');
		List<Character> row3 = new ArrayList<>();
		row3.add('z');
		row3.add('x');
		row3.add('c');
		row3.add('v');
		row3.add('b');
		row3.add('n');
		row3.add('m');
		boolean flag1Row = false;
		boolean flag2Row = false;
		boolean flag3Row = false;
		for(String word:words) {
			String tempWord= word.toLowerCase();
			char[] charAr = tempWord.toCharArray();
			flag1Row = true;
			flag2Row = true;
			flag3Row = true;
			int count =0;
			for (int i = 0; i < charAr.length; i++) {
				if(flag1Row) {
					if(row1.contains(charAr[i])) {
						flag2Row = false;
						flag3Row = false;
						count++;
					}					
				} 
				if(flag2Row) {
					if(row2.contains(charAr[i])) {
						flag1Row = false;
						flag3Row = false;
						count++;
					}					
				} 
				if(flag3Row) {
					if(row3.contains(charAr[i])) {
						flag1Row = false;
						flag2Row = false;
						count++;
					}					
				}
			}
			if(count == charAr.length) {
				ans.add(word);
			}
		}
		String [] A = new String[ans.size()];
		int i=0;
		for(String w : ans) {
			A[i] = w;
			i++;
		}
		return A;
        
    }

}
