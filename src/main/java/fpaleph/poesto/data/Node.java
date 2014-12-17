package fpaleph.poesto.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Node implements Serializable {

	public static enum TYPE {
		NORMAL, NOTABLE, KEYSTONE, MASTERY;

		@Override
		public String toString() {
			if (this == NORMAL) {
				return "Normal";
			} else if (this == NOTABLE) {
				return "Notable";
			} else if (this == KEYSTONE) {
				return "Keystone";
			} else if (this == MASTERY) {
				return "Mastery";
			} else {
				return null;
			}
		}
	}

	/**
	 * Automatically generated serial version UID.
	 */
	private static final long serialVersionUID = -9134843162384495978L;

	public int id = -1;
	public String name = null;
	public TYPE type = TYPE.NORMAL;
	public int group = -1;
	public String icon = null;
	public int orbit, station = -1;
	public Set<Integer> neighbors = new HashSet<>();
	public List<String> description = new ArrayList<>();
	public int root = -1;

	public Node() {
		// defined in order to preserve the null constructor
	}

	public Node(JsonObject node) {
		this.id = node.get("id").getAsInt();
		this.name = node.get("dn").getAsString();

		if (node.get("m").getAsBoolean()) {
			this.type = TYPE.MASTERY;
		} else if (node.get("ks").getAsBoolean()) {
			this.type = TYPE.KEYSTONE;
		} else if (node.get("not").getAsBoolean()) {
			this.type = TYPE.NOTABLE;
		} else {
			this.type = TYPE.NORMAL;
		}

		this.group = node.get("g").getAsInt();
		this.icon = node.get("icon").getAsString();
		this.orbit = node.get("o").getAsInt();
		this.station = node.get("oidx").getAsInt();

		for (JsonElement neighbor : node.getAsJsonArray("out")) {
			this.neighbors.add(neighbor.getAsInt());
		}

		for (JsonElement line : node.getAsJsonArray("sd")) {
			this.description.add(line.getAsString());
		}

		for (JsonElement root : node.getAsJsonArray("spc")) {
			this.root = root.getAsInt();
			break;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (group != other.group)
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (neighbors == null) {
			if (other.neighbors != null)
				return false;
		} else if (!neighbors.equals(other.neighbors))
			return false;
		if (orbit != other.orbit)
			return false;
		if (root != other.root)
			return false;
		if (station != other.station)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + group;
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((neighbors == null) ? 0 : neighbors.hashCode());
		result = prime * result + orbit;
		result = prime * result + root;
		result = prime * result + station;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[id=").append(id)
		  .append(", name=\"").append(name).append('\"')
		  .append(", type=").append(type)
		  .append(", group=").append(group)
		  .append(", icon=").append(icon)
		  .append(", orbit=").append(orbit)
		  .append(", station=").append(station)
		  .append(", neighbors=").append(neighbors)
		  .append(", description=").append(description)
		  .append(", root=").append(root)
		  .append("]");
		return sb.toString();
	}
}
