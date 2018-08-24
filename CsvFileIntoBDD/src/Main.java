import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static Connection openBdd() {
		Connection bdd = null;
		// Connect to BDD
		try {
			Class.forName("org.postgresql.Driver");
			bdd = DriverManager.getConnection("jdbc:postgresql://localhost:5432/csv", "postgres", "YcTtmW37");
			System.out.println("Successfully connected to bdd !");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bdd;
	}

	public static void main(String[] args) {
		// Get filePath
		Scanner sc = new Scanner(System.in);
		System.out.println("Chemin du fichier >");
		String filePath = sc.nextLine();
		
		// Open BDD
		Connection bdd = openBdd();
		
		// Process
		ImportCsvFile imp = new ImportCsvFile(bdd, filePath);
		imp.process();
		
		// Close bdd
		try {
			bdd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
