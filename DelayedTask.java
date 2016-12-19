package DelayQ;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed,Runnable{
	long delay;
	
	public DelayedTask(long delay) {
		this.delay = delay;
	}

	@Override
	public int compareTo(Delayed o) {
		DelayedTask d1=(DelayedTask)o;
		if(this.delay>d1.delay)
			return 1;
		else if(this.delay<d1.delay)
			return -1;
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		unit.convert(delay, TimeUnit.SECONDS);
		return 0;
	}

	@Override
	public void run() {
		System.out.println("In Run of Delay :"+this.delay);	
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
