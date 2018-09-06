import java.util.ArrayList;
import java.util.Iterator;

public class ArrayNode extends JsonNode {
	protected ArrayList<Object> list = new ArrayList<>();;

	public ArrayNode add(Object value) {
		list.add(value);
		return this;
	}

	public Object get(int index) {
		return list.get(index);
	}

	public void remove(int index) {
		list.remove(index);
	}

	public int size() {
		return list.size();
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public String toJson(int deep) {
		String json = "[ \n";
		for (Object o : list) {
			for (int i = 0; i < deep; i++) {
				json += "\t";
			}
			if (o instanceof JsonNode) {
				json += ((JsonNode) o).toJson(deep + 1);
			} else if (o instanceof Number) {
				json += o.toString();
			} else {
				json += "\"" + o.toString() + "\"";
			}
			json += ",\n";
		}
		json = json.substring(0, json.length() - 1);
		json += "\n";
		for (int i = 0; i < deep - 1; i++) {
			json += "\t";
		}
		json += "]";
		return json;
	}

	@Override
	public Iterator<Object> iterator() {
		return list.iterator();
	}
}
