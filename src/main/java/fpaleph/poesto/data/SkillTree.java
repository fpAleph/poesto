package fpaleph.poesto.data;

import java.awt.Point;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import fpaleph.poesto.integ.SkillTreeJsonScraper;

public class SkillTree implements Serializable {

	/**
	 * Automatically generated serial version UID.
	 */
	private static final long serialVersionUID = -5577555860735908865L;

	/*-
	 * The following elements of the json schema are still not understood:
	 * 	constants->PSSCenterInnerRadius
	 *  groups->*->oo
	 *      5 is not set for any node group...
	 *      6-9 are mysterious...
	 */

	// assets, imageRoot, imageZoomLevels, skillSprites

	// characterData, constants*, nodes*
	public Map<Integer, Archetype> archetypes = new HashMap<>();

	// min_x, min_y
	public Point coordMin = null;

	// max_x, max_y
	public Point coordMax = null;

	// groups
	public Map<Integer, NodeGroup> nodeGroups = new HashMap<>();
	
	// nodes // oidx -> the hour of the clock the node points to
	public Map<Integer, Node> nodes = new HashMap<>();
	
	public static SkillTree load() {
		try {
			return loadFromJson(SkillTreeJsonScraper.scrapeData(null));
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static SkillTree loadFromJson(JsonObject rawJson) {
		SkillTree st = new SkillTree();

		// Store the minimum and maximum bounds for the coordinates
		st.coordMax = new Point(rawJson.get("max_x").getAsInt(),
								rawJson.get("max_y").getAsInt());
		st.coordMin = new Point(rawJson.get("min_x").getAsInt(),
								rawJson.get("min_y").getAsInt());

		// Populate node groups, including their coordinates
		JsonObject groups = rawJson.getAsJsonObject("groups");
		for (Entry<String, JsonElement> me : groups.entrySet()) {
			int id = Integer.parseInt(me.getKey());
			JsonObject group = me.getValue().getAsJsonObject();
			st.nodeGroups.put(id, new NodeGroup(id, group));
		}

		// Populate the nodes... this part takes quite a while
		JsonArray nodes = rawJson.getAsJsonArray("nodes");
		for (JsonElement je : nodes) {
			Node node = new Node(je.getAsJsonObject());
			st.nodes.put(node.id, node);
		}

		// Populate the character class data structure
		JsonObject characterData = rawJson.getAsJsonObject("characterData");
		JsonObject classes = rawJson.getAsJsonObject("constants")
				.getAsJsonObject("classes");
		JsonArray root = rawJson.getAsJsonObject("root").getAsJsonArray("out");
		for (JsonElement element : root) {
			int nodeId = element.getAsInt();
			int id = st.nodes.get(nodeId).root;
			JsonObject character = characterData.getAsJsonObject(Integer.toString(id));
			st.archetypes.put(id, new Archetype(id, character, classes, nodeId));
		}

		return st;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillTree other = (SkillTree) obj;
		if (archetypes == null) {
			if (other.archetypes != null)
				return false;
		} else if (!archetypes.equals(other.archetypes))
			return false;
		if (coordMax == null) {
			if (other.coordMax != null)
				return false;
		} else if (!coordMax.equals(other.coordMax))
			return false;
		if (coordMin == null) {
			if (other.coordMin != null)
				return false;
		} else if (!coordMin.equals(other.coordMin))
			return false;
		if (nodeGroups == null) {
			if (other.nodeGroups != null)
				return false;
		} else if (!nodeGroups.equals(other.nodeGroups))
			return false;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((archetypes == null) ? 0 : archetypes.hashCode());
		result = prime * result
				+ ((coordMax == null) ? 0 : coordMax.hashCode());
		result = prime * result
				+ ((coordMin == null) ? 0 : coordMin.hashCode());
		result = prime * result
				+ ((nodeGroups == null) ? 0 : nodeGroups.hashCode());
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("archetypes=").append(archetypes).append("\n");
		sb.append("coords=").append(coordMin).append("-").append(coordMax).append("\n");
		sb.append("groups=").append(nodeGroups.size()).append("\n");
		sb.append("nodes=").append(nodes.size()).append("\n");
		return sb.toString();
	}

}
