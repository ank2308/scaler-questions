import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueStandard<E> {
	
	Queue<E> sharedQueue ;
	private int max = 16;
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	MyBlockingQueueStandard (int size){
		this.sharedQueue = new LinkedList<>();
		this.max  = size;
	}
	
	void put(E e) throws InterruptedException {
		lock.lock();
		try {
			if(sharedQueue.size() == max) {
				notFull.await();
			}
			sharedQueue.add(e);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public E take () throws InterruptedException {
		lock.lock();
		try {
			if(sharedQueue.size() == 0) {
				notEmpty.await();
			}
			E item = sharedQueue.remove();
			notFull.signalAll();
			return item;
		} finally {
			lock.unlock();
		}		
	}
}
