

public class ThreadExample extends Thread{

	public static void main(String []  args) {
		ThreadExample t = new ThreadExample();
		ThreadExample t1 = new ThreadExample();
		t.start();
		try {
			t.join();
		}catch (Exception e) {
			System.out.println("hi");
		}
		t1.start();
	}
	
	public void run () {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(10);
			}
			catch (Exception e) {
				System.out.println("hello");
			}
			System.out.println(i+" ");
		}
	}
}
