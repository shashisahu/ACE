package deadlock;

public class Thread1 implements Runnable {

	Object resource1;
	Object resource2;
	
	public Thread1(Object resource1, Object resource2) {
		this.resource1 = resource1;
		this.resource2 = resource2;
	}

	@Override
	public void run() {
		synchronized (resource1) {
			System.out.println("Thread1 : inside resource1 lock");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (resource2) {
				System.out.println("Thread1 : inside resource2 lock");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

}
