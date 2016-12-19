package chache;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChacheImpl implements CacheInterface {
	
	//int cacheSize;
	long timeToLive;
	static Map<Integer,ChacheObject> cacheMap;
	
	class ChacheObject{
		long lastAccessed;
		int key;
		Object value;
		boolean isExpired;
		public ChacheObject(long lastAccessed, int key, Object value,boolean exipred ) {
			this.lastAccessed = lastAccessed;
			this.key = key;
			this.value = value;
			this.isExpired=exipred;
		}
		public long getLastAccessed() {
			return lastAccessed;
		}
		public void setLastAccessed(long lastAccessed) {
			this.lastAccessed = lastAccessed;
		}
		public boolean isExpired() {
			return isExpired;
		}
		public void setExpired(boolean isExpired) {
			this.isExpired = isExpired;
		}
		
		
	}
	
	public ChacheImpl(long timeTolive,long interval) {
		//this.cacheSize=maxNo;
		this.timeToLive=timeToLive;
		cacheMap=new ConcurrentHashMap<>();
		
		Thread t=new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
				cleanUp();
				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}
			
		});
		t.start();
	}
	
	public void cleanUp() {
		Set entrySet=cacheMap.entrySet();
		Set<Integer> listToRemove=new HashSet();
		long currentTime=System.currentTimeMillis();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			ChacheObject caheObj=(ChacheObject)entry.getValue();
			if(currentTime>=(timeToLive+caheObj.lastAccessed)){
				caheObj.setExpired(true);
				listToRemove.add(caheObj.key);
			}
		}
		for (int key : listToRemove) {
			System.out.println("Removing from cache : key : "+key);
			cacheMap.remove(key);
		}
	}
	
	public synchronized void  putObject(Object value,int key) {
		long lastAccessed=System.currentTimeMillis();
		ChacheObject cacheObject=new ChacheObject(lastAccessed, key, value,false);
		//if(cacheMap.size()<cacheSize){
		  cacheMap.put(key, cacheObject);
	//}
}
	
	public synchronized Object getObject(int key) {
		ChacheObject cObj=cacheMap.get(key);
		if(cObj.isExpired()){
			System.out.println("Not Present in cache");
			return null;
		}
		cObj.lastAccessed=System.currentTimeMillis();
		return cObj.value;
	}
	
	public static void main(String[] args) {
		ChacheImpl chacheImpl=new ChacheImpl(2000l, 400l);
		chacheImpl.putObject("Shashi", 1);
		chacheImpl.putObject("Sahu", 2);
		chacheImpl.putObject("Sapient", 3);
		chacheImpl.putObject("Aricent", 4);
		chacheImpl.putObject("TCS", 5);
		
		System.out.println(chacheImpl.getObject(1));
	}

}
