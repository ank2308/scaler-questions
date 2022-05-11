import java.util.HashMap;

public class ColorfulNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorfulNumber cn = new ColorfulNumber();
		cn.colorful(3245);
	}

	public int colorful(int A) {
		String s = "" + A;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		char [] ch = s.toCharArray();
		for (int i = 1; i <= ch.length; i++) {
			for (int j = 0; j <= ch.length-i; j++) {
				int k =j;
				int temp = 1;
				while(k <j+i) {
					temp = temp * (ch[k] - '0');
					k++;
				}
				if(map.containsKey(temp)) {
					return 0;
				} else {
					map.put(temp, null);
				}
			}
		}
		return 1;
    }
}
