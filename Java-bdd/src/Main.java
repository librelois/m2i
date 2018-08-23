import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	private static final String NAME = "Ll";
	private static final String CAPACITY = "invisibility";

	public static void main(String[] args) {
		// Connect to BDD
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					   "jdbc:postgresql://localhost:5432/xmen","postgres", "YcTtmW37");
			System.out.println("Successfully connected to bdd !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// launch interpreter
		CommandInterpreter ci = new CommandInterpreter(connection, NAME, CAPACITY);
		ci.launch();
		
		// Close BDD
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
