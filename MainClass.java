package CustomBlockingQ;

public class MainClass {

	public static void main(String[] args) {
		
		BlockingQueue qu = new BlockingQueue(10);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i=1;
				while(true)
					if(i<=20){
					qu.put(i);
					i++;
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
			}
			
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(true)
					System.out.println("Getting Elements from custom Blocking queue :"+qu.get()+",");
			}
		}).start();
	}
}
