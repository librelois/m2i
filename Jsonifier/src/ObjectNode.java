import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ObjectNode extends JsonNode {
	protected HashMap<String, Object> map = new HashMap<>();

	public ObjectNode put(String key, Object value) {
		if (key == null) {
			throw new NullPointerException();
		}
		map.put(key, value);
		return this;
	}

	public Object get(String key) {
		return map.get(key);
	}

	public void remove(String key) {
		map.remove(key);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public String toJson(int deep) {
		String json = "{ \n";
		for (Entry<String, Object> e : map.entrySet()) {
			for (int i = 0; i < deep; i++) {
				json += "\t";
			}
			json += "\"";
			json += e.getKey().toString();
			json += "\": ";
			Object value = e.getValue();
			if (value instanceof JsonNode) {
				json += ((JsonNode) value).toJson(deep + 1);
			} else if (value instanceof Number) {
				json += value.toString();
			} else {
				json += "\"" + value.toString() + "\"";
			}
			json += ",\n";
		}
		json = json.substring(0, json.length() - 1);
		json += "\n";
		for (int i = 0; i < deep - 1; i++) {
			json += "\t";
		}
		json += "}";
		return json;
	}

	@Override
	public Iterator<Entry<String, Object>> iterator() {
		return map.entrySet().iterator();
	}
}
