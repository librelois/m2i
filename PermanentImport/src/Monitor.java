import java.io.File;
import java.util.ArrayList;

public class Monitor {
	private String dirPath;
	
	public Monitor(String dirPath) {
		this.dirPath = dirPath;
	}
	
	public ArrayList<String> waitFiles() throws InterruptedException {
		File folder = new File(dirPath);
		if (!folder.exists()) {
			System.out.println("ERROR: Folder '"+dirPath+"' don't exist !");
			System.exit(0);
		}
		File[] listOfFiles = null;
		do {
			listOfFiles = folder.listFiles();
			Thread.sleep(500);
		} while (listOfFiles == null || listOfFiles.length == 0);
		
		 ArrayList<String> filesNames = new ArrayList<>();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  String fileName = listOfFiles[i].getName();
			  System.out.println("Detect File " + listOfFiles[i].getName());
			  filesNames.add(fileName);
		  } //else if (listOfFiles[i].isDirectory()) {}
		}
		return filesNames;
	}
}
