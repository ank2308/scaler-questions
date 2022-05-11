
public class PrintSeq implements Runnable{

	public final int PRINT_NUMBERS = 20;
	
	static int num = 1;
	
	int remainder;
	
	static Object lock = new Object();
	
	public PrintSeq(int remainder) {
		// TODO Auto-generated constructor stub
		this.remainder = remainder;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(num <= PRINT_NUMBERS-1) {
			System.out.println(Thread.currentThread().getName());
			
			synchronized (lock) {
				while(num % 3 != remainder) {
					try {
						System.out.println(Thread.currentThread().getName() +"goin to wait");
						lock.wait();						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}					
				}
				System.out.println(Thread.currentThread().getName() + " : " + num);
				num++;
				lock.notifyAll();				
			}
		}
	}

}
