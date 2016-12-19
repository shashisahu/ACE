package MyThreadPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	BlockingQueue queue;
	List<PoolThread> threads;
	boolean isShutDown = false;

	public ThreadPool(int maxSize, int noOfThread) {
		queue = new ArrayBlockingQueue<>(maxSize);
		threads = new ArrayList<>(noOfThread);
		for (int i = 0; i < noOfThread; i++) {
			threads.add(new PoolThread(queue));
		}
		for (PoolThread poolThread : threads) {
			poolThread.start();
		}
	}

	public synchronized void execute(Runnable task) {
		if(isShutDown)
			new IllegalStateException();
		try {
			queue.put(task);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void doShutDown() {
		isShutDown = true;
		for (PoolThread poolThread : threads) {
			poolThread.doStop();
		}
	}

}
