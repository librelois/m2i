import java.util.concurrent.ConcurrentLinkedQueue;

public class Dispather extends Thread {
	ConcurrentLinkedQueue<String> queueMain;
	ConcurrentLinkedQueue<String> queuePairs;
	ConcurrentLinkedQueue<String> queueImpairs;
	
	Dispather(
			ConcurrentLinkedQueue<String> queueMain,
			ConcurrentLinkedQueue<String> queuePairs,
			ConcurrentLinkedQueue<String> queueImpairs
		) {
		this.queueMain = queueMain;
		this.queuePairs = queuePairs;
		this.queueImpairs = queueImpairs;
	}
	
	public void run() {
		while (true) {
			if (queueMain.size() > 0) {
				String msg = this.queueMain.poll();
				Integer n =  Integer.parseInt(msg.substring(3));
				if (n %2 == 0) {
					queuePairs.offer(msg);
				} else {
					queueImpairs.offer(msg);
				}
			}
		}
	}
}
