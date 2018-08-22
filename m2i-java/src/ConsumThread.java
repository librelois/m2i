import java.util.concurrent.ConcurrentLinkedQueue;

public class ConsumThread extends Thread {
	private ConcurrentLinkedQueue<String> queue;
	boolean parity;

	ConsumThread(ConcurrentLinkedQueue<String> queue, boolean parity) {
		this.queue = queue;
		this.parity = parity;
	}

	@Override
	public void run() {
		while (true) {
			if (this.queue.size() > 0) {
				String msg = this.queue.poll();
				if (msg != null) {
					System.out.println(String.format("%s : %s", (parity) ? "Pairs" : "Impairs", msg));
				}
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
