import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

public class ImportCsvFile {
	private Connection bdd;
	private String filePath;
	
	ImportCsvFile(Connection bdd, String filePath) {
		this.bdd = bdd;
		this.filePath = filePath;
	}
	
	public void process() {
		// Open file at filePath
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			stream.forEach(this::process_line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void process_line(String line) {
		String [] parts = line.split(";");
		String sql = String.format(
				"INSERT INTO eleves (id, nom, age) VALUES(%s, '%s', %s)",
				parts[0], parts[1], parts[2]);
		System.out.println("DEBUG: exec query="+sql);
		Statement st;
		try {
			st = bdd.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
