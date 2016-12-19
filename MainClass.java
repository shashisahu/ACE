package deadlock;

public class MainClass {
	public static void main(String[] args) {
		Object resource1=new Object();
		Object resource2=new Object();
		new Thread(new Thread1(resource1,resource2)).start();
		new Thread(new Thread2(resource1,resource2)).start();
		
	}

}
