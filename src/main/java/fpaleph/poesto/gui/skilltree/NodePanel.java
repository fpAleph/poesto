package fpaleph.poesto.gui.skilltree;

import java.awt.Dimension;

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
		setOpaque(false);
		
		// FIXME
		double zoom = 0.1726;
		
		double width = zoom * (st.coordMax.x - st.coordMin.x);
		double height = zoom * (st.coordMax.y - st.coordMin.y);
		setSize((int) Math.ceil(width), (int) Math.ceil(height));
		
		for (Archetype at : st.archetypes.values()) {
			Node node = st.nodes.get(at.node);
			NodeGroup group = st.nodeGroups.get(node.group);
			
			JLabel jLabel = new JLabel(at.name);
			add(jLabel, new SkillTreeConstraints(group.x, group.y));
			jLabel.setVisible(true);
		}
	}
	
	public static NodePanel load(SkillTree st) {
		return new NodePanel(st);
	}

}
