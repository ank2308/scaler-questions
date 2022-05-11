
public class ReverseANum {
	public static void main(String [] args) {
		int x = -745673;
		long ans=0;
        int an=0;
        while(x!=0){
            int temp = x%10;
            x=x/10;
            ans = (ans *10) + temp;
            an = (int) ans;
            if(an != ans) {
            	an = 0;
            	break;
            }
        }
        System.out.println(an);
	}
}
