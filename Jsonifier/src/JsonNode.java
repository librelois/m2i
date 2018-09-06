
public abstract class JsonNode {
	abstract public void clear();

	public String toJson() {
		return toJson(1);
	}

	abstract public String toJson(int deep);
}
