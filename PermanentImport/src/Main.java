import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	private static final String FOLDER="in";

	public static void main(String[] args) {
		// Open DB
		Db db = new Db();
		// Listen directory "in"
		Monitor m = new Monitor(FOLDER);
		
		// Start main loop
		while(true) {
			try {
				// Wait files
				ArrayList<String> filesNames = m.waitFiles();
				// Import detect files
				for (String fileName : filesNames) {
					// Compute filePath
					String filePath = FOLDER+"/"+fileName;
					// Instantiate Csv importer
					Csv importer = new Csv();
					ArrayList<String []> fileDatas = importer.importFile(filePath);
					// Write file datas in DB
					for (String [] lineDatas : fileDatas) {
						db.insert(lineDatas);
					}
					// Delete file
					File f = new File(filePath);
					f.delete();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
