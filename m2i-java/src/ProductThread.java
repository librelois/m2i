import java.util.concurrent.ConcurrentLinkedQueue;

public class ProductThread extends Thread {
	ConcurrentLinkedQueue<String> queue;
	
	ProductThread (ConcurrentLinkedQueue<String> queue) {
		this.queue = queue;
	}
	public void run() {
		int count = 1;
		while (true) {
			this.queue.offer("MSG"+count);
			count++;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
	