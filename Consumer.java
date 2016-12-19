package pubsubwithwaitnotify;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	List queue;
	
	public Consumer(List queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		synchronized (queue) {
			while(true){
				while(queue.isEmpty()){
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Consumer Consumes : ");
				System.out.println(queue.remove(queue.size()-1));
				queue.notifyAll();
					
			}
			
		}
	}

}
