
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Program program = new Program();
		program.start();
		Class1 c = new Class1();
		Class2 a = new Class2();
		((Class1)a).show();
		c=a;
		c.show();
	}
	
	public void start () {
		System.out.println(check("12345"));
		System.out.println(check("123456"));
		System.out.println(check(null));
	}
	
	private boolean check(String s) {
		try {
			return s.length()>5;
		} catch (NullPointerException e) {
			System.out.println("exception");
			return false;
		}
	}

}
