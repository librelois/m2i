
public class Main {

	public static void main(String[] args) {
		ThreadA t1 = new ThreadA('+');
		ThreadA t2 = new ThreadA('-');
		ThreadA t3 = new ThreadA('*');
		
		t1.start();
		t2.start();
		t3.start();
	}

}
