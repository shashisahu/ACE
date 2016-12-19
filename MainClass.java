package sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {
	public static void main(String[] args) throws InterruptedException {
			Object lock=new Object();
			AtomicInteger counter=new AtomicInteger(1);
			Thread t1 = new Thread(new Thread1(1, "Thread1",counter,lock));
			Thread t2 = new Thread(new Thread2(2, "Thread2",counter,lock));
			Thread t3 = new Thread(new Thread3(3, "Thread3",counter,lock));
			t1.start();t2.start();t3.start();
			t1.join();t2.join();t3.join();
			
	}

}
