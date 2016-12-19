package pubsubwithwaitnotify;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	List queue;

	public Producer(List queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		synchronized (queue) {
			int i = 0;
			while (i<20) {
				while (queue.size() >= 10)
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				System.out.println("Producer produces :"+i);
				queue.add(i);
				i++;
				queue.notifyAll();
			}
		}

	}
}
