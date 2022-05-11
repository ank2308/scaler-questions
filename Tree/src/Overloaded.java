
public class Overloaded {
	
	public int sum(int a, int b) {
		System.out.println("Integer");
		return a+b;
	}
	
	public long sum(long a, long b) {
		System.out.println("LOng");
		return a+b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overloaded o = new Overloaded();
		String s= new String("abc");
		System.out.println(o.sum(5L, 5));
		System.out.println(o.sum(5L, 5L));
	}

}
