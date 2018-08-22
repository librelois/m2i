import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		FileWriter f = null;
		try {
			f = new FileWriter("file.txt");
			for (int i=0;i<1000;i++) {
				int random = (int) (Math.random() * 100);
				String str = String.format("%d\r\n", random);
				f.write(str);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
