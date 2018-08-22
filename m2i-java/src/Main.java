import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

	public static void main(String[] args) {
	     ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
	      	
		ProductThread p = new ProductThread(queue);
		ConsumThread c1 = new ConsumThread(queue);
		ConsumThread c2 = new ConsumThread(queue);
		
		p.start();
		c1.start();
		c2.start();
	}

}
