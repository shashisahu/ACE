package CustomBlockingQ;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue<T> {
	List<T> list;
	int size;

	BlockingQueue(int size) {
		this.size = size;
		this.list = new ArrayList(size);
	}

	synchronized void put(T data) {
		while (list.size() == size) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Putting data in custom queue : "+data );
		list.add(data);
		notifyAll();
	}
	
	synchronized <T> T  get() {
		while (list.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		T i=(T)list.remove(list.size()-1);
		notifyAll();
		return i;
		
	}

}
