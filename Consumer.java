package pubsubwithBQ;

import java.util.concurrent.BlockingQueue;


public class Consumer<T> implements Runnable {
	private BlockingQueue<T> queue;
	
	public Consumer(BlockingQueue<T> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true){
		try {
			System.out.println("Cosumer consumes : "+queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}

}
