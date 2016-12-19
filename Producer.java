package pubsubwithBQ;

import java.util.concurrent.BlockingQueue;


public class Producer<T> implements Runnable {
	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		int i=0;
		while(i<=10)
			try {
				System.out.println("Producer Produces :"+i);
				queue.put(i);
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
