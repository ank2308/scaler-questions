
public class HappyNumber {
	public boolean isHappy(int n) {
        int [] arr = new int [810];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
        int sum = 0;
        int temp = 0;
        while(n!=1) {
        	sum = 0;
        	temp = 0;
        	while(n>0) {
        		temp = n%10;
        		n=n/10;
        		sum = (int) (sum + Math.pow(temp, 2));
        	}
        	if(arr[sum] != -1) {
        		return false;
        	} else {
        		arr[sum] = 1;
        	}
        	n=sum;
        }
        return true;
    }
	
	public static void main(String [] args) {
		HappyNumber happyNumber = new HappyNumber();
		System.out.println(happyNumber.isHappy(999999999));
	}
}
