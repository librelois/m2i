
public class ThreadA extends Thread {
	char c;
	
	public ThreadA (char c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(this.c);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
