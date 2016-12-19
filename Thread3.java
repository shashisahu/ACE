package sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread3 implements Runnable {
	int threadNo;
	String threadName;
	AtomicInteger data;
	Object lock;
	
	public Thread3(int threadNo, String threadName,AtomicInteger data,Object lock) {
		this.threadNo = threadNo;
		this.threadName = threadName;
		this.data=data;
		this.lock=lock;
	}

	@Override
	public void run() {
		synchronized (data) {
			
		while(data.get()<30){
		while(!(data.get()%3==0 && threadNo==3)){
			try {
				data.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		System.out.println("Thread No :"+threadNo +" : "+data);
		data.getAndIncrement();
		data.notifyAll();
	}}
	}
}
