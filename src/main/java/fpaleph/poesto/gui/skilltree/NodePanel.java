package fpaleph.poesto.gui.skilltree;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fpaleph.poesto.data.Archetype;
import fpaleph.poesto.data.Node;
import fpaleph.poesto.data.NodeGroup;
import fpaleph.poesto.data.SkillTree;
import fpaleph.poesto.gui.infrastructure.SkillTreeConstraints;
import fpaleph.poesto.gui.infrastructure.SkillTreeLayout;

@SuppressWarnings("serial")
public class NodePanel extends JPanel {

	public NodePanel(SkillTree st) {
		setLayout(new SkillTreeLayout(st));
		
		setBackground(new Color(0, 0, 0, 0));
		setOpaque(true);
		
		for (Archetype at : st.archetypes.values()) {
			Node node = st.nodes.get(at.node);
			NodeGroup group = st.nodeGroups.get(node.group);
			
			JLabel jLabel = new JLabel(at.name);
			add(jLabel, new SkillTreeConstraints(group.x, group.y));
		}
		
		System.out.println(getClass() + ":" + getWidth() + "x" + getHeight());
	}
	
	public static NodePanel load(SkillTree st) {
		return new NodePanel(st);
	}

}
