import java.util.concurrent.ConcurrentLinkedQueue;

public class ProductThread extends Thread {
	private ConcurrentLinkedQueue<String> queue;
	
	ProductThread (ConcurrentLinkedQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		int count = 0;
		while (true) {
			String msg = String.format("MSG%d", count++);
			this.queue.add(msg);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	