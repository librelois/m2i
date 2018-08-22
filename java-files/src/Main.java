import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		BufferedWriter f = null;
		try {
			f = new BufferedWriter(new FileWriter("file.txt"));
			for (int i=0;i<10;i++) {
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
		FindMinLineInFile finder = new FindMinLineInFile("file.txt");
		System.out.println("Minimum = "+ finder.find_min_line());
	}
}
