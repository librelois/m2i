import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FindMinLineInFile {
	int min;
	String file_path;
	
	public FindMinLineInFile(String file_path) {
		min = -1;
		this.file_path = file_path;
	}

	public int find_min_line() {
		try (Stream<String> stream = Files.lines(Paths.get(this.file_path))) {
			stream.forEach(this::process_line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.min;
	}

	public void process_line(String line) {
		int current = Integer.parseInt(line);
		if (min > current || min < 0) {
			min = current;
		}
	}
}
