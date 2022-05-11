
public class ThreadDemo extends Thread{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread.sleep(1000);
			Thread.currentThread().interrupt();
		}
	}

}
