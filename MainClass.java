package MyThreadPool;

public class MainClass {
	public static void main(String[] args) {
		ThreadPool pool=new ThreadPool(1, 1);
		final int i=1;
		pool.execute(()->System.out.println("My ThreadPool1 : "+i));
		pool.execute(()->System.out.println("My ThreadPool2 : "+i));
		pool.execute(()->System.out.println("My ThreadPool3 : "+i));
		pool.doShutDown();
		pool.execute(()->System.out.println("My ThreadPool4 : "+i));
		pool.execute(()->System.out.println("My ThreadPool5 : "+i));
		pool.execute(()->System.out.println("My ThreadPool6 : "+i));
	}
}
