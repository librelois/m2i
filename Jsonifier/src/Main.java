
public class Main {
	public static void main(String[] args) {
		ObjectNode json = new ObjectNode();
		ArrayNode persons = new ArrayNode();
		// Create first Person
		ObjectNode p1 = new ObjectNode();
		p1.put("lastname", "DUPONT");
		p1.put("firstname", "Jean");
		p1.put("age", 42);
		persons.add(p1);
		// Create second Person
		ObjectNode p2 = new ObjectNode();
		p2.put("lastname", "DURAND");
		p2.put("firstname", "Jacques");
		p2.put("age", 46);
		persons.add(p2);
		// Put persons in json node
		json.put("persons", persons);
		System.out.println(json.toJson());
	}
}
