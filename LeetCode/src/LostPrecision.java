

public class LostPrecision {

	public static void main(String [] args) {
		String s = "words and 987";
		long ans = 0;
        int precision = 1;
        for(int i=0;i<s.length();i++){
        	
            if(((int)s.charAt(i))>=48 && ((int)s.charAt(i))<=57){
                ans = (ans * 10) + s.charAt(i)%48;
            }
            if(s.charAt(i) == '-'){
                precision = -1;
            }
        }
        int mod = (int)Math.pow(10,9)+7;
        int fans = (int)(ans%mod);
        System.out.println(fans*precision);
	}
}
