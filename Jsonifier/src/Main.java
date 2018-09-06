
public class Main {
	public static void main(String[] args) {
		ObjectNode json = new ObjectNode();
		ArrayNode persons = new ArrayNode();
		// Create first Person
		ObjectNode p1 = new ObjectNode();
		p1.put("lastname", "DUPONT")
			.put("firstname", "Jean")
			.put("age", 42);
		// Create second Person
		ObjectNode p2 = new ObjectNode();
		p2.put("lastname", "DURAND")
			.put("firstname", "Jacques")
			.put("age", 46);
		// Add p1 and p2 to persons
		persons.add(p1).add(p2);
		// Put persons in json node
		json.put("persons", persons);
		System.out.println(json.toJson());
	}
}
