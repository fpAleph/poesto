package fpaleph.poesto.gui;

import javax.swing.JLayeredPane;

import fpaleph.poesto.data.SkillTree;
import fpaleph.poesto.gui.infrastructure.LayeredLayout;
import fpaleph.poesto.gui.skilltree.BackgroundPanel;
import fpaleph.poesto.gui.skilltree.NodePanel;

@SuppressWarnings("serial")
public class SkillTreeLayeredPane extends JLayeredPane {

	public SkillTreeLayeredPane(SkillTree st, BackgroundPanel bp, NodePanel np) {
		setLayout(new LayeredLayout());
		setOpaque(false);
		
		add(bp, 0, 0);
		add(np, 4, 0);
	}
	
	public static SkillTreeLayeredPane load(SkillTree st) {
		return load(st, BackgroundPanel.load(st), NodePanel.load(st));
	}
	
	public static SkillTreeLayeredPane load(SkillTree st, BackgroundPanel bp, NodePanel np) {
		return new SkillTreeLayeredPane(st, bp, np);
	}
	
}
