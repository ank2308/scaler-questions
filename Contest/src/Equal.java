
public class Equal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {3321,231,23,43};
		Equal eq = new Equal();
		System.out.println(eq.solve(A));
	}
	public int solve(int [] A) {
		
		int min = findGCD(A);
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			int temp = A[i];
			while(temp > min) {
				temp = (int) Math.floor(temp/2);
				count++;
			}
		}
		
		return count;
		
	}
	
	static int findGCD(int arr[])
    {
        int result = 0;
        for (int element: arr){
            result = gcd(result, element);
 
            if(result == 1)
            {
               return 1;
            }
        }
 
        return result;
    }
	
	static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
