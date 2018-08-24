import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Csv {
	private ArrayList<String []> fileDatas;
	
	public Csv() {
		fileDatas = new ArrayList<>();
	}
	
	public Csv(ArrayList<String []> fileDatas) {
		this.fileDatas = fileDatas;
	}
	
	public ArrayList<String []> importFile(String filePath) {
		// Open file at filePath
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			stream.forEach(this::process_line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileDatas;
	}
	
	private void process_line(String line) {
		String [] parts = line.split(";");
		fileDatas.add(parts);
	}
}
