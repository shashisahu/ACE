package pubsubwithBQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {
	private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
	public static void main(String[] args) {
		new Thread(new Producer<Integer>(queue)).start();
		new Thread(new Consumer<Integer>(queue)).start();
	}
}
