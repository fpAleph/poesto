package fpaleph.poesto.gui;

import javax.swing.JLayeredPane;

import fpaleph.poesto.data.SkillTree;
import fpaleph.poesto.gui.infrastructure.LayeredLayout;
import fpaleph.poesto.gui.skilltree.NodePanel;

@SuppressWarnings("serial")
public class SkillTreeLayeredPane extends JLayeredPane {

	public SkillTreeLayeredPane(SkillTree st, NodePanel np) {
		setLayout(new LayeredLayout());
		setOpaque(false);
		add(np, 1, 0);
	}
	
	public static SkillTreeLayeredPane load(SkillTree st) {
		return load(st, NodePanel.load(st));
	}
	
	public static SkillTreeLayeredPane load(SkillTree st, NodePanel np) {
		return new SkillTreeLayeredPane(st, np);
	}
	
}
