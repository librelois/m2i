import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	private Connection db;

	public Db() {
		// Connect to BDD
		db = null;
		try {
			Class.forName("org.postgresql.Driver");
			db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/csv", "postgres", "YcTtmW37");
			System.out.println("Successfully connected to bdd !");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String[] datas) throws SQLException {
		String sql = String.format(
				"INSERT INTO eleves (id, nom, age) VALUES(%s, '%s', %s)",
				datas[0], datas[1], datas[2]);
		System.out.println("DEBUG: exec query="+sql);
		Statement st;
		st = db.createStatement();
		st.execute(sql);
	}
	
	// public ArrayList<String> selectAll();
	
	public void close() throws SQLException {
		db.close();
	}
}
