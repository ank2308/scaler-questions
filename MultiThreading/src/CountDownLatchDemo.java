import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CountDownLatchDemo {

	public static int [] arr = IntStream.rangeClosed(0, 5000).toArray();
	public static int total = IntStream.rangeClosed(0, 5000).sum();
	final static CountDownLatch countDownLatch = new CountDownLatch(3);
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Callable<Integer> callable1 = () -> {
			int sum = 0;
			for (int i = 0; i < arr.length/2; i++) {
				sum = sum + arr[i];
			}
			countDownLatch.countDown();
			return sum;
		};
		Callable<Integer> callable2 = () -> {
			int sum = 0;
			for (int i = arr.length/2; i < arr.length; i++) {
				sum = sum + arr[i];
			}
			countDownLatch.countDown();
			return sum;
		};
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> sum1 = executorService.submit(callable1);
		Future<Integer> sum2 = executorService.submit(callable2);
		System.out.println("Before "+ countDownLatch.getCount());
		
		System.out.println("Before "+ countDownLatch.getCount());
		
		countDownLatch.await();
		System.out.println("After " + countDownLatch.getCount());
		int sum = sum1.get() + sum2.get();
		System.out.println(sum);
		executorService.shutdown();
	}

}
