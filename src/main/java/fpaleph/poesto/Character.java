package fpaleph.poesto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Character implements Serializable {
	
	private static Map<String, String> names = new HashMap<>();
	static {
		names.put("StrDexIntClass", "Scion");
		names.put("StrClass", "Marauder");
		names.put("DexClass", "Ranger");
		names.put("IntClass", "Witch");
		names.put("StrDexClass", "Duelist");
		names.put("StrIntClass", "Templar");
		names.put("DexIntClass", "Shadow");
	}

	/**
	 * Automatically generated serial version UID.
	 */
	private static final long serialVersionUID = -4159787509623703980L;
	
	public int id = -1;
	public String name = null;
	public int node = -1;
	public int s, d, i = -1;

	public Character() {
		// defined in order to preserve the null constructor
	}
	
	public Character(int id, JsonObject character, JsonObject classes, int nodeId) {
		this.id = id;
		this.s = character.get("base_str").getAsInt();
		this.d = character.get("base_dex").getAsInt();
		this.i = character.get("base_int").getAsInt();
		
		for (Entry<String, JsonElement> entry : classes.entrySet()) {
			String name = entry.getKey();
			int idx = entry.getValue().getAsInt();
			
			if (idx == id) {
				if (names.containsKey(name)) {
					name = names.get(name);
				}
				this.name = name;
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[')
		  .append("id=").append(id)
		  .append(", name=\"").append(name).append("\"")
		  .append(", node=").append(node)
	      .append(", str=").append(s)
		  .append(", dex=").append(d)
		  .append(", int=").append(i)
		  .append(']');
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + d;
		result = prime * result + i;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + node;
		result = prime * result + s;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (d != other.d)
			return false;
		if (i != other.i)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (node != other.node)
			return false;
		if (s != other.s)
			return false;
		return true;
	}

}
