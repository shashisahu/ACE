package deadlock;

public class Thread2 implements Runnable {
	Object resource1;
	Object resource2;
	
	public Thread2(Object resource1, Object resource2) {
		this.resource1 = resource1;
		this.resource2 = resource2;
	}

	@Override
	public void run() {
		synchronized (resource2) {
			System.out.println("Thread2 : inside resource 2 Lock");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (resource1) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread2 : inside resource 2 lock");
				
			}
			
		}
	}
}
