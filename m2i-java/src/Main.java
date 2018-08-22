import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

	public static void main(String[] args) {
	     ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
	      	
		ProductThread p = new ProductThread(queue);
		ConsumThread c = new ConsumThread(queue);
		
		p.start();
		c.start();
	}

}
