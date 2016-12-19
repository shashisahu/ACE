package MyThreadPool;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread {

	BlockingQueue queue;
	boolean isStop;

	public PoolThread(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (isStop) {
					throw new IllegalStateException();
				}
				Runnable r = (Runnable) queue.take();
				r.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void doStop() {
		this.isStop = true;
		this.interrupt();
	}

}
