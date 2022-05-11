import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PRoducerConsumer{

	
	
	public static void main(String [] args) {
		
		MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<>(5);
		
		
		
		Runnable producer = () -> {
			int num = 0;
			while(true) {
				try {
					blockingQueue.put(++num);
					System.out.println("Added" + num);
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable consumer = () -> {
			while(true) {
				try {
					System.out.println("Consumed" +  blockingQueue.take());
					TimeUnit.MILLISECONDS.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(producer);
		executorService.submit(consumer);
	}
}
