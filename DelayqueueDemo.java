package DelayQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import CustomBlockingQ.BlockingQueue;


public class DelayqueueDemo {
	public static void main(String[] args) throws InterruptedException {
		DelayQueue<Delayed> dq=new DelayQueue<>();
		DelayedTask d1=new DelayedTask(500);
		DelayedTask d2=new DelayedTask(3000);
		DelayedTask d3=new DelayedTask(4000);
		DelayedTask d4=new DelayedTask(2000);
		/*dq.add(d1);
		dq.add(d2);
		dq.add(d3);
		dq.add(d4);
		
		for (int i = 0; i < 4; i++) {
			DelayedTask dt=	(DelayedTask)dq.take();
			new Thread(dt).start();
			System.out.println(dt.delay);
		}
	}*/
		ArrayBlockingQueue workQueue=new ArrayBlockingQueue(1);
		//ThreadPoolExecutor pool=new ThreadPoolExecutor(1, 1, 10000, TimeUnit.MILLISECONDS, workQueue,);
		ThreadPoolExecutor pool= new ThreadPoolExecutor(1, 1, 100, TimeUnit.MILLISECONDS, workQueue, new ThreadPoolExecutor.AbortPolicy());
		pool.execute(d1);
		pool.execute(d2);
		pool.execute(d3);
		pool.execute(d4);
	}
}
