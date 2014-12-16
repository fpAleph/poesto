package fpaleph.poesto;

import java.awt.Point;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class SkillTreeBuilder {

	public static SkillTree fromJson(JsonObject rawJson) {
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
		JsonArray root = rawJson.getAsJsonObject("root")
							    .getAsJsonArray("out");
		for (JsonElement element : root) {
			int nodeId = element.getAsInt();
			int id = st.nodes.get(nodeId).root;
			JsonObject character = characterData.getAsJsonObject(Integer.toString(id));
			st.characters.put(id, new Character(id, character, classes, nodeId));
		}
		
		return st;
	}
}
