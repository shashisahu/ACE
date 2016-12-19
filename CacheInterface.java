package chache;

public interface CacheInterface {
	void putObject(Object obj,int key);
	Object getObject(int key);
}
