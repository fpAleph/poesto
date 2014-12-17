package fpaleph.poesto.gui;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import fpaleph.poesto.data.SkillTree;
import fpaleph.poesto.gui.skilltree.BackgroundPanel;
import fpaleph.poesto.gui.skilltree.NodePanel;

@SuppressWarnings(value = "serial")
public class SkillTreePanel extends JPanel {

	public SkillTreePanel(SkillTree st, BackgroundPanel bgp, NodePanel np) {
		// TODO do we need double buffering? // super(true);
		super(true);
		setLayout(new OverlayLayout(this));
		setOpaque(false);
		// Components added early are visible over components added later
		this.add(np);
		this.add(bgp);
	}
	
	public static SkillTreePanel load(SkillTree st) {
		return load(st, BackgroundPanel.load(st), NodePanel.load(st));
	}

	public static SkillTreePanel load(SkillTree st, BackgroundPanel bgp, NodePanel np) {
		return new SkillTreePanel(st, bgp, np);
	}
	
}
