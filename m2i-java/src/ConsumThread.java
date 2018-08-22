import java.util.concurrent.ConcurrentLinkedQueue;

public class ConsumThread extends Thread {
	private ConcurrentLinkedQueue<String> queue;
	
	ConsumThread (ConcurrentLinkedQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while (true) {
			String msg = this.queue.poll();
			System.out.println(msg);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
