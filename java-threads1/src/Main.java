import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

	public static void main(String[] args) {
	    ConcurrentLinkedQueue<String> queueMain = new ConcurrentLinkedQueue<String>();
	    ConcurrentLinkedQueue<String> queuePairs = new ConcurrentLinkedQueue<String>();
	    ConcurrentLinkedQueue<String> queueUnpairs = new ConcurrentLinkedQueue<String>();
	      	
		ProductThread p = new ProductThread(queueMain);
		Dispather d = new Dispather(queueMain, queuePairs, queueUnpairs);
		ConsumThread cPair = new ConsumThread(queuePairs, true);
		ConsumThread cUnpair = new ConsumThread(queueUnpairs, false);
		
		p.start();
		d.start();
		cPair.start();
		cUnpair.start();
	}
}
