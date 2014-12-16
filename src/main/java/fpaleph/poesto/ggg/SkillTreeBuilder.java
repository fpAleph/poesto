package fpaleph.poesto.ggg;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import fpaleph.poesto.ClassAttributes;
import fpaleph.poesto.NodeGroup;
import fpaleph.poesto.SkillTree;

public class SkillTreeBuilder {

	private static Map<String, String> ClassNameMap;
	static {
		ClassNameMap = new HashMap<>();
		ClassNameMap.put("StrDexIntClass", "Scion");
		ClassNameMap.put("StrClass", "Marauder");
		ClassNameMap.put("DexClass", "Ranger");
		ClassNameMap.put("IntClass", "Witch");
		ClassNameMap.put("StrDexClass", "Duelist");
		ClassNameMap.put("StrIntClass", "Templar");
		ClassNameMap.put("DexIntClass", "Shadow");
	}

	public static SkillTree fromJson(JsonObject skillTreeData) {
		SkillTree st = new SkillTree();

		// Populate the character class data structure
		JsonObject constants = skillTreeData.getAsJsonObject("constants");
		JsonObject classes = constants.getAsJsonObject().getAsJsonObject("classes");
		for (Map.Entry<String, JsonElement> me : classes.entrySet()) {
			String name = me.getKey();
			int id = me.getValue().getAsInt();
			
			if (ClassNameMap.containsKey(name)) {
				name = ClassNameMap.get(name);
			}
			
			ClassAttributes ca = new ClassAttributes();
			ca.id = id;
			ca.name = name;
			st.classAttributes.put(id, ca);
		}
		
		JsonObject characterData = skillTreeData.getAsJsonObject("characterData");
		for (Map.Entry<String, JsonElement> me : characterData.entrySet()) {
			int id = Integer.parseInt(me.getKey());
			JsonObject attributes = me.getValue().getAsJsonObject();
			ClassAttributes ca = st.classAttributes.get(id);
			assert (null != ca);
			ca.s = attributes.get("base_str").getAsInt();
			ca.d = attributes.get("base_dex").getAsInt();
			ca.i = attributes.get("base_int").getAsInt();
		}
		
		JsonArray nodes = skillTreeData.getAsJsonArray("nodes");
		for (JsonElement node : nodes) {
			JsonArray spc = node.getAsJsonObject().get("spc").getAsJsonArray();
			if (0 < spc.size()) {
				int cid = spc.get(0).getAsInt();
				int nid = node.getAsJsonObject().get("id").getAsInt();
				st.classAttributes.get(cid).node = nid;
			}
		}
		
		// Store the minimum and maximum bounds for the display
		st.displayMaximum = new Point(skillTreeData.get("max_x").getAsInt(), skillTreeData.get("max_y").getAsInt());
		st.displayMinimum = new Point(skillTreeData.get("min_x").getAsInt(), skillTreeData.get("min_y").getAsInt());
		
		// Populate the node groups, and take note where to show them
		JsonObject groups = skillTreeData.getAsJsonObject("groups");
		for (Map.Entry<String, JsonElement> me : groups.entrySet()) {
			int id = Integer.parseInt(me.getKey());
			JsonObject group = me.getValue().getAsJsonObject();

			NodeGroup ng = new NodeGroup();
			ng.id = id;
			for (JsonElement je : group.getAsJsonArray("n")) {
				ng.nodes.add(je.getAsInt());
			}
			
			JsonObject orbitals = group.getAsJsonObject("oo");
			if (orbitals.has("3")) {
				ng.size = 3;
			} else if (orbitals.has("2")) {
				ng.size = 2;
			} else if (orbitals.has("1")) {
				ng.size = 1;
			} else {
				ng.size = 0;
			}

			ng.x = group.get("x").getAsDouble();
			ng.y = group.get("y").getAsDouble();
			
			st.nodeGroups.put(id, ng);
		}
		
		return st;
	}
}
