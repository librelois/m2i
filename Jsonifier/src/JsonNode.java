
public abstract class JsonNode implements Iterable {
	abstract public void clear();

	public String toJson() {
		return toJson(1);
	}

	abstract public String toJson(int deep);
}
