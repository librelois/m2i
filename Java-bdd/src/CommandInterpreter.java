import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CommandInterpreter {
	private Connection bdd;
	private String author;
	private String capacity;
	
	CommandInterpreter(Connection bdd, String author, String capacity) {
		this.bdd = bdd;
		this.author = author;
		this.capacity= capacity;
	}
	
	public ArrayList<String> get_messages(String user) throws SQLException {
		String sql = "SELECT message FROM xmen";
		if (!user.equals("*")) {
			sql += String.format(" WHERE nom='%s'", user);
		}
		//System.out.println("DEBUG: exec query="+sql);
		Statement st = bdd.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ArrayList<String> messages = new ArrayList<>();
		while(rs.next()) {
			messages.add(rs.getString("message"));
		}
		return messages;
	}
	
	public void add_entry(String msg) throws SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String sql = String.format("INSERT INTO xmen (date, message, nom, pouvoir) VALUES(DATE('%s'), '%s', '%s', '%s')", dateFormat.format(new Date()), msg, author, capacity);
		//System.out.println("DEBUG: exec query="+sql);
		Statement st = bdd.createStatement();
		st.execute(sql);
	}
	
	public void launch() {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		while(!quit) {
			// Input
			System.out.println("Enter a command>");
			String [] user_command = sc.nextLine().split(" ");
			
			// Treat user command
			switch (user_command[0].toLowerCase()) {
				case "ajouter":
					try {
						add_entry(user_command[1]);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(String.format("Message \"%s\" ajouté.", user_command[1]));
				break;
				case "afficher":
					ArrayList<String> msgs = null;
					try {
						msgs = get_messages(user_command[1]);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (String msg: msgs) {
						System.out.println(msg);
					}
				break;
				case "quit": quit = true; break;
			}
		}
		sc.close();
	}
}
