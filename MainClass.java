package pubsubwithwaitnotify;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		List queue= new ArrayList();
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
		
	}

}
